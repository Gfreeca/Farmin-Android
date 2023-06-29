package com.gfreeca.farmin_android.domain.repository

import com.gfreeca.farmin_android.domain.model.auth.req.SignInReqModel
import com.gfreeca.farmin_android.domain.model.auth.res.SignInResModel

interface AuthRepository {
    suspend fun signIn(body: SignInReqModel): SignInResModel

    suspend fun saveTokenInfo(
        accessToken: String,
        refreshToken: String,
        accessExp: String,
        refreshExp: String
    )
}