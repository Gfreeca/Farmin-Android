package com.gfreeca.farmin_android.data.remote.dto.announcement.res

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
