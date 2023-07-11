package com.gfreeca.farmin_android.domain.repository

interface ApplicationRepository {
    suspend fun applicationFarm(idx: Int)
}