package com.gfreeca.farmin_android.data.remote.dto.announcement.res

import com.gfreeca.farmin_android.domain.model.announcement.res.RecruitPostInfoModel

data class RecruitPostInfo(
    val idx: Int,
    val thumbnail: String,
    val name: String,
    val location: String,
    val pay: String,
    val farmName: String
)

fun RecruitPostInfo.toModel(): RecruitPostInfoModel {
    return RecruitPostInfoModel(
        idx = this.idx,
        thumbnail = this.thumbnail,
        name = this.name,
        location = this.location,
        pay = this.pay,
        farmName = this.farmName
    )
}