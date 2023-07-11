package com.gfreeca.farmin_android.domain.usecase

import com.gfreeca.farmin_android.domain.repository.ApplicationRepository
import javax.inject.Inject

class ApplicationFarmUseCase @Inject constructor(
    private val repository: ApplicationRepository
) {
    suspend operator fun invoke(idx: Int) = kotlin.runCatching {
        repository.applicationFarm(idx = idx)
    }
}