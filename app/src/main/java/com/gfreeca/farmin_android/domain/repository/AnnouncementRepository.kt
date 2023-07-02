package com.gfreeca.farmin_android.domain.repository

import com.gfreeca.farmin_android.domain.model.announcement.res.RecruitPostInfoModel

interface AnnouncementRepository {
    suspend fun getRecruitList(): List<RecruitPostInfoModel>
}