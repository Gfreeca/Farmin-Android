package com.gfreeca.farmin_android.domain.usecase

import com.gfreeca.farmin_android.domain.model.auth.req.SignInReqModel
import com.gfreeca.farmin_android.domain.repository.AuthRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(body: SignInReqModel) = kotlin.runCatching {
        authRepository.signIn(body)
    }
}