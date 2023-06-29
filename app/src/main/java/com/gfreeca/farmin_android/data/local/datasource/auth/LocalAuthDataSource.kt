package com.gfreeca.farmin_android.data.local.datasource.auth

interface LocalAuthDataSource {
    suspend fun getAccessToken(): String

    suspend fun getRefreshToken(): String

    suspend fun getAccessExp(): String

    suspend fun getRefreshExp(): String

    suspend fun saveTokenInfo(
        accessToken: String,
        refreshToken: String,
        accessExp: String,
        refreshExp: String
    )
}