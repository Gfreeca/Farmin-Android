package com.gfreeca.farmin_android.data.remote.datasource.announcement

import com.gfreeca.farmin_android.data.remote.network.ApplicationAPI
import com.gfreeca.farmin_android.data.util.FarminApiHandler
import javax.inject.Inject

class ApplicationDataSourceImpl @Inject constructor(
    private val service: ApplicationAPI
) : ApplicationDataSource {
    override suspend fun applicationFarm(idx: Int): Unit =
        FarminApiHandler<Unit>()
            .httpRequest { service.applicationFarm(idx = idx) }
            .sendRequest()
}