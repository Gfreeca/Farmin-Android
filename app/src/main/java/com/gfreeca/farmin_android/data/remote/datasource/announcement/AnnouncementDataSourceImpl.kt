package com.gfreeca.farmin_android.data.remote.datasource.announcement

import com.gfreeca.farmin_android.data.remote.dto.announcement.res.GetRecruitListRes
import com.gfreeca.farmin_android.data.remote.network.AnnouncementAPI
import com.gfreeca.farmin_android.data.util.FarminApiHandler
import javax.inject.Inject

class AnnouncementDataSourceImpl @Inject constructor(
    private val service: AnnouncementAPI
) : AnnouncementDataSource {
    override suspend fun getRecruitList(): GetRecruitListRes =
        FarminApiHandler<GetRecruitListRes>()
            .httpRequest { service.getRecruitList() }
            .sendRequest()
}