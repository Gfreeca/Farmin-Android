package com.gfreeca.farmin_android.data.remote.datasource.announcement

interface ApplicationDataSource {
    suspend fun applicationFarm(idx: Int)
}