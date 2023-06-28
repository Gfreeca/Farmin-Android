package com.gfreeca.farmin_android.data.remote.dto.auth.res

import com.gfreeca.farmin_android.domain.model.auth.res.SignInResModel

data class SignInRes(
    val accessToken: String,
    val refreshToken: String,
    val accessExp: String,
    val refreshExp: String
)

fun SignInRes.toModel(): SignInResModel {
    return SignInResModel(
        accessToken = this.accessToken,
        refreshToken = this.refreshToken,
        accessExp = this.accessExp,
        refreshExp = this.refreshExp
    )
}
