package com.gfreeca.farmin_android.data.remote.network

import com.gfreeca.farmin_android.data.local.storage.AuthDataStorage
import com.gfreeca.farmin_android.di.module.BaseUrl
import com.gfreeca.farmin_android.domain.exception.NeedLoginException
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import okhttp3.*
import java.io.IOException
import java.time.LocalDateTime
import javax.inject.Inject

class LoginInterceptor @Inject constructor(
    private val authDataStorage: AuthDataStorage
) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
        val request = chain.request()
        val path = request.url.encodedPath
        val method = request.method
        val ignorePath = listOf("/auth/sign-in","/auth/sign-up")
        val ignoreMethod = listOf("POST")

        ignorePath.forEachIndexed { index, s ->
            if (s == path && ignoreMethod[index] == method) {
                return chain.proceed(request)
            }
        }

        if (authDataStorage.getRefreshToken().isBlank()) {
            return chain.proceed(request)
        }

        val currentTime = LocalDateTime.now()
        val accessExp = LocalDateTime.parse(
            authDataStorage.getAccessExpiredAt().substring(0, 19)
        )
        val refreshExp = LocalDateTime.parse(
            authDataStorage.getRefreshExpiredAt().substring(0, 19)
        )
        val refreshToken = authDataStorage.getRefreshToken()

        if (currentTime.isAfter(refreshExp)) throw NeedLoginException()

        if (currentTime.isAfter(accessExp)) {
            val client = OkHttpClient()
            val refreshRequest = Request.Builder()
                .url(BaseUrl.URL + "auth")
                .patch(chain.request().body ?: RequestBody.create(null, byteArrayOf()))
                .addHeader(
                    "Refresh-Token",
                    "Bearer $refreshToken"
                )
                .build()
            val jsonParser = JsonParser()
            val response = client.newCall(refreshRequest).execute()
            if (response.isSuccessful) {
                val token = jsonParser.parse(response.body!!.string()) as JsonObject
                authDataStorage.setAccessToken(token["accessToken"].toString().removeDot())
                authDataStorage.setRefreshToken(token["refreshToken"].toString().removeDot())
                authDataStorage.setAccessExpiredAt(token["accessExp"].toString().removeDot())
                authDataStorage.setRefreshExpiredAt(token["refreshExp"].toString().removeDot())
            } else throw NeedLoginException()
        }

        val accessToken = authDataStorage.getAccessToken()

        return proceed(
            request.newBuilder()
                .addHeader("Authorization", "Bearer $accessToken")
                .build()
        )
    }

    private fun String.removeDot(): String {
        return this.replace("^\"|\"$".toRegex(), "")
    }
}