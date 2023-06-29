package com.gfreeca.farmin_android.data.local.datasource.auth

import com.gfreeca.farmin_android.data.local.storage.AuthDataStorage
import javax.inject.Inject

class LocalAuthDataSourceImpl @Inject constructor(
    private val storage: AuthDataStorage
) : LocalAuthDataSource {
    override suspend fun getAccessToken(): String = storage.getAccessToken()

    override suspend fun getRefreshToken(): String = storage.getRefreshToken()

    override suspend fun getAccessExp(): String = storage.getAccessExpiredAt()

    override suspend fun getRefreshExp(): String = storage.getRefreshExpiredAt()

    override suspend fun saveTokenInfo(
        accessToken: String,
        refreshToken: String,
        accessExp: String,
        refreshExp: String
    ) {
        with(storage) {
            setAccessToken(accessToken)
            setRefreshToken(refreshToken)
            setAccessExpiredAt(accessExp)
            setRefreshExpiredAt(refreshExp)
        }
    }
}