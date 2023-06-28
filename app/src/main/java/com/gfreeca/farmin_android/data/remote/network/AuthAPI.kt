package com.gfreeca.farmin_android.data.remote.network

import com.gfreeca.farmin_android.data.remote.dto.auth.req.SignInReq
import com.gfreeca.farmin_android.data.remote.dto.auth.res.SignInRes
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPI {
    @POST("auth/sign-in")
    suspend fun signIn(
        @Body body: SignInReq
    ): Response<SignInRes>
}