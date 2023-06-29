package com.gfreeca.farmin_android.domain.usecase

import com.gfreeca.farmin_android.domain.repository.AuthRepository
import javax.inject.Inject

class SaveTokenUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(
        accessToken: String,
        refreshToken: String,
        accessExp: String,
        refreshExp: String
    ) = kotlin.runCatching {
        repository.saveTokenInfo(
            accessToken = accessToken,
            refreshToken = refreshToken,
            accessExp = accessExp,
            refreshExp = refreshExp
        )
    }
}