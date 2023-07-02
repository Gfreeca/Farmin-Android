package com.gfreeca.farmin_android.domain.repository

import com.gfreeca.farmin_android.domain.model.announcement.res.GetRecruitListResModel

interface AnnouncementRepository {
    suspend fun getRecruitList(): GetRecruitListResModel
}