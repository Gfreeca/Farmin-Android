package com.gfreeca.farmin_android.domain.model.auth.res

data class SignInResModel(
    val accessToken: String,
    val refreshToken: String,
    val accessExp: String,
    val refreshExp: String
)
