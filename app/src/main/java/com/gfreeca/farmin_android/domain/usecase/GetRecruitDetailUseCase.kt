package com.gfreeca.farmin_android.domain.usecase

import com.gfreeca.farmin_android.domain.repository.AnnouncementRepository
import javax.inject.Inject

class GetRecruitDetailUseCase @Inject constructor(
    private val repository: AnnouncementRepository
) {
    suspend operator fun invoke(id: Int) = kotlin.runCatching {
        repository.getRecruitDetailInfo(id = id)
    }
}