package com.gfreeca.farmin_android.data.remote.network

import com.gfreeca.farmin_android.data.remote.dto.announcement.res.RecruitDetailInfo
import com.gfreeca.farmin_android.data.remote.dto.announcement.res.RecruitPostInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface AnnouncementAPI {
    @GET("/announcement")
    suspend fun getRecruitList(): List<RecruitPostInfo>

    @GET("/announcement/{announcement_id}")
    suspend fun getRecruitDetailInfo(
        @Path("announcement_id") announcementId: Int
    ): RecruitDetailInfo
}