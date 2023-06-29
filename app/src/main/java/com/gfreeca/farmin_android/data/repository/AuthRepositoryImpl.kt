package com.gfreeca.farmin_android.data.repository

import com.gfreeca.farmin_android.data.local.datasource.auth.LocalAuthDataSource
import com.gfreeca.farmin_android.data.remote.datasource.auth.AuthDataSource
import com.gfreeca.farmin_android.data.remote.dto.auth.req.SignInReq
import com.gfreeca.farmin_android.data.remote.dto.auth.res.toModel
import com.gfreeca.farmin_android.domain.model.auth.req.SignInReqModel
import com.gfreeca.farmin_android.domain.model.auth.res.SignInResModel
import com.gfreeca.farmin_android.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val dataSource: AuthDataSource,
    private val localDataSource: LocalAuthDataSource
) : AuthRepository {
    override suspend fun signIn(body: SignInReqModel): SignInResModel {
        return dataSource.signIn(
            SignInReq(
                id = body.id,
                password = body.password
            )
        ).toModel()
    }

    override suspend fun saveTokenInfo(
        accessToken: String,
        refreshToken: String,
        accessExp: String,
        refreshExp: String,
        fcmToken: String
    ) {
        localDataSource.saveTokenInfo(
            accessToken = accessToken,
            refreshToken = refreshToken,
            accessExp = accessExp,
            refreshExp = refreshExp
        )
    }
}