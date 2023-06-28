package com.gfreeca.farmin_android.data.remote.datasource.auth

import com.gfreeca.farmin_android.data.remote.dto.auth.req.SignInReq
import com.gfreeca.farmin_android.data.remote.dto.auth.res.SignInRes
import com.gfreeca.farmin_android.data.remote.network.AuthAPI
import com.gfreeca.farmin_android.data.util.FarminApiHandler
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val service: AuthAPI
) : AuthDataSource {
    override suspend fun signIn(body: SignInReq): SignInRes =
        FarminApiHandler<SignInRes>()
            .httpRequest { service.signIn(body) }
            .sendRequest()
}