package com.gfreeca.farmin_android.data.remote.dto.announcement.res

import com.gfreeca.farmin_android.domain.model.announcement.res.TimeInfoModel

data class TimeInfo(
    val hour: String,
    val minute: String
)

fun TimeInfo.toModel(): TimeInfoModel {
    return TimeInfoModel(
        hour = hour,
        minute = minute
    )
}
