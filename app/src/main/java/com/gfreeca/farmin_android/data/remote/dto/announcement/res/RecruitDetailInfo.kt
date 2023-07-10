package com.gfreeca.farmin_android.data.remote.dto.announcement.res

import com.gfreeca.farmin_android.domain.model.announcement.res.RecruitDetailInfoModel

data class RecruitDetailInfo(
    val idx: String,
    val name: String,
    val farmName: String,
    val userName: String,
    val userProfile: String,
    val description: String,
    val pay: String,
    val mainBusiness: List<String>,
    val images: List<String>,
    val workingHours: List<TimeInfo>,
    val period: List<String>,
    val benefit: List<String>,
    val deadline: String,
    val location: String,
    val isApplied: String
)

fun RecruitDetailInfo.toModel(): RecruitDetailInfoModel {
    return RecruitDetailInfoModel(
        idx = this.idx,
        name = this.name,
        farmName = this.farmName,
        userName = this.userName,
        userProfile = this.userProfile,
        description = this.description,
        pay = this.pay,
        mainBusiness = this.mainBusiness,
        images = this.images,
        workingHours = this.workingHours.map { it.toModel() },
        period = this.period,
        benefit = this.benefit,
        deadline = this.deadline,
        location = this.location,
        isApplied = this.isApplied
    )
}
