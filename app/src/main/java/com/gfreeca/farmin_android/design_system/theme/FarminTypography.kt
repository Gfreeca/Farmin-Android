package com.gfreeca.farmin_android.design_system.theme

import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.gfreeca.farmin_android.R

object FarminTypography {

    private val pretendard = FontFamily(
        Font(R.font.pretendard_extralight, FontWeight.ExtraLight),
        Font(R.font.pretendard_thin, FontWeight.Thin),
        Font(R.font.pretendard_light, FontWeight.Light),
        Font(R.font.pretendard_regular, FontWeight.Normal),
        Font(R.font.pretendard_medium, FontWeight.Medium),
        Font(R.font.pretendard_bold, FontWeight.Bold),
        Font(R.font.pretendard_semibold, FontWeight.SemiBold),
        Font(R.font.pretendard_extrabold, FontWeight.ExtraBold),
        Font(R.font.pretendard_black, FontWeight.Black)
    )

    @Stable
    val title1 = TextStyle(
        fontFamily = pretendard,
        fontSize = 24.sp,
        lineHeight = 28.8.sp,
    )

    @Stable
    val title2 = TextStyle(
        fontFamily = pretendard,
        fontSize = 20.sp,
        lineHeight = 24.sp,
    )

    @Stable
    val title3 = TextStyle(
        fontFamily = pretendard,
        fontSize = 18.sp,
        lineHeight = 21.6.sp,
    )

    @Stable
    val subtitle = TextStyle(
        fontFamily = pretendard,
        fontSize = 16.sp,
        lineHeight = 19.2.sp,
    )

    @Stable
    val body1 = TextStyle(
        fontFamily = pretendard,
        fontSize = 16.sp,
        lineHeight = 22.4.sp,
    )

    @Stable
    val body2 = TextStyle(
        fontFamily = pretendard,
        fontSize = 14.sp,
        lineHeight = 19.6.sp,
    )

    @Stable
    val label1 = TextStyle(
        fontFamily = pretendard,
        fontSize = 13.sp,
        lineHeight = 15.6.sp,
    )

    @Stable
    val label2 = TextStyle(
        fontFamily = pretendard,
        fontSize = 12.sp,
        lineHeight = 14.4.sp,
    )

    @Stable
    val caption = TextStyle(
        fontFamily = pretendard,
        fontSize = 11.sp,
        lineHeight = 15.6.sp,
    )
}
