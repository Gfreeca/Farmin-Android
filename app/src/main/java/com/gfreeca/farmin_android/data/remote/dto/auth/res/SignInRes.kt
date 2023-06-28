package com.gfreeca.farmin_android.data.remote.dto.auth.res

data class SignInRes(
    val accessToken: String,
    val refreshToken: String,
    val accessExp: String,
    val refreshExp: String
)
