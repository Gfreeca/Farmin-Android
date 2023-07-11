package com.gfreeca.farmin_android.data.repository

import com.gfreeca.farmin_android.data.remote.datasource.announcement.ApplicationDataSource
import com.gfreeca.farmin_android.domain.repository.ApplicationRepository
import javax.inject.Inject

class ApplicationRepositoryImpl @Inject constructor(
    private val dataSource: ApplicationDataSource
) : ApplicationRepository {
    override suspend fun applicationFarm(idx: Int) {
        dataSource.applicationFarm(idx)
    }
}