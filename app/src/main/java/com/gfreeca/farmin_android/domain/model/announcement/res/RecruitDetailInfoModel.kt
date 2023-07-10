package com.gfreeca.farmin_android.domain.model.announcement.res

data class RecruitDetailInfoModel(
    val idx: String,
    val name: String,
    val farmName: String,
    val userName: String,
    val userProfile: String,
    val description: String,
    val pay: String,
    val mainBusiness: List<String>,
    val images: List<String>,
    val workingHours: List<TimeInfoModel>,
    val period: List<String>,
    val benefit: List<String>,
    val deadline: String,
    val location: String,
    val isApplied: String
)
