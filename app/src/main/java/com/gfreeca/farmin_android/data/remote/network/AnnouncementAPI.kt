package com.gfreeca.farmin_android.data.remote.network

import com.gfreeca.farmin_android.data.remote.dto.announcement.res.GetRecruitListRes
import retrofit2.http.GET

interface AnnouncementAPI {
    @GET("/announcement")
    suspend fun getRecruitList(): GetRecruitListRes
}