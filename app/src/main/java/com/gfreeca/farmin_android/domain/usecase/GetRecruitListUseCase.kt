package com.gfreeca.farmin_android.domain.usecase

import com.gfreeca.farmin_android.domain.repository.AnnouncementRepository
import javax.inject.Inject

class GetRecruitListUseCase @Inject constructor(
    private val repository: AnnouncementRepository
) {
    suspend operator fun invoke() = kotlin.runCatching {
        repository.getRecruitList()
    }
}