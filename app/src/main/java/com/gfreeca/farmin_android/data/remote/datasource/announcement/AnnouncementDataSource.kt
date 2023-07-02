package com.gfreeca.farmin_android.data.remote.datasource.announcement

import com.gfreeca.farmin_android.data.remote.dto.announcement.res.RecruitPostInfo

interface AnnouncementDataSource {
    suspend fun getRecruitList(): List<RecruitPostInfo>
}