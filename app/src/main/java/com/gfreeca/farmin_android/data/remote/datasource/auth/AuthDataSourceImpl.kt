package com.gfreeca.farmin_android.data.remote.datasource.auth

import com.gfreeca.farmin_android.data.remote.dto.auth.req.SignInReq
import com.gfreeca.farmin_android.data.remote.dto.auth.res.SignInRes
import com.gfreeca.farmin_android.data.remote.network.AuthAPI
import retrofit2.Response
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val service: AuthAPI
) : AuthDataSource {
    override suspend fun signIn(body: SignInReq): Response<SignInRes> {
        return service.signIn(body)
    }
}