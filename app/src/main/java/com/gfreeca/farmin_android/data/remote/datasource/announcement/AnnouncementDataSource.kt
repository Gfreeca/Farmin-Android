package com.gfreeca.farmin_android.data.remote.datasource.announcement

import com.gfreeca.farmin_android.data.remote.dto.announcement.res.GetRecruitListRes

interface AnnouncementDataSource {
    suspend fun getRecruitList(): GetRecruitListRes
}