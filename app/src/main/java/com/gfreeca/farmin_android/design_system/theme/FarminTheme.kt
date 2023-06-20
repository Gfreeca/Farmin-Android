package com.gfreeca.farmin_android.design_system.theme

import androidx.compose.runtime.Composable
import com.gfreeca.farmin_android.design_system.theme.color.LightColor

@Composable
fun FarminTheme(
    colors: ColorTheme = LightColor,
    typography: FarminTypography = FarminTypography,
    content: @Composable (colors: ColorTheme, typography: FarminTypography) -> Unit
) {
    content(colors, typography)
}