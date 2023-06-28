package com.gfreeca.farmin_android.data.remote.datasource.auth

import com.gfreeca.farmin_android.data.remote.dto.auth.req.SignInReq
import com.gfreeca.farmin_android.data.remote.dto.auth.res.SignInRes

interface AuthDataSource {
    suspend fun signIn(body: SignInReq): SignInRes
}