package com.gfreeca.farmin_android.data.repository

import com.gfreeca.farmin_android.data.remote.datasource.announcement.AnnouncementDataSource
import com.gfreeca.farmin_android.data.remote.dto.announcement.res.toModel
import com.gfreeca.farmin_android.domain.model.announcement.res.GetRecruitListResModel
import com.gfreeca.farmin_android.domain.repository.AnnouncementRepository
import javax.inject.Inject

class AnnouncementRepositoryImpl @Inject constructor(
    private val dataSource: AnnouncementDataSource
) : AnnouncementRepository {
    override suspend fun getRecruitList(): GetRecruitListResModel {
        return dataSource.getRecruitList().toModel()
    }
}