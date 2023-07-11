package com.gfreeca.farmin_android.data.remote.network

import retrofit2.http.POST
import retrofit2.http.Path

interface ApplicationAPI {
    @POST("/application/{announcement_id}")
    suspend fun applicationFarm(
        @Path("announcement_id") idx: Int
    )
}