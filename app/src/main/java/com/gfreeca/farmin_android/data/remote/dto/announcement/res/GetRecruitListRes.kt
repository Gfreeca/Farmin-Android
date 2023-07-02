package com.gfreeca.farmin_android.data.remote.dto.announcement.res

import com.gfreeca.farmin_android.domain.model.announcement.res.GetRecruitListResModel

data class GetRecruitListRes(
    val list: List<RecruitPostInfo>
)

fun GetRecruitListRes.toModel(): GetRecruitListResModel {
    return GetRecruitListResModel(
        list = this.list.map { it.toModel() }
    )
}
