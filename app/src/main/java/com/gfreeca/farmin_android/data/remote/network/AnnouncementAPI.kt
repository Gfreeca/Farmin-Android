package com.gfreeca.farmin_android.data.remote.network

import com.gfreeca.farmin_android.data.remote.dto.announcement.res.RecruitPostInfo
import retrofit2.http.GET

interface AnnouncementAPI {
    @GET("/announcement")
    suspend fun getRecruitList(): List<RecruitPostInfo>
}