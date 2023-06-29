package com.gfreeca.farmin_android.data.local.storage

interface AuthDataStorage {
    fun setAccessToken(accessToken: String)

    fun getAccessToken(): String

    fun setRefreshToken(refreshToken: String)

    fun getRefreshToken(): String

    fun setAccessExpiredAt(accessExp: String)

    fun getAccessExpiredAt(): String

    fun setRefreshExpiredAt(refreshExp: String)

    fun getRefreshExpiredAt(): String
}