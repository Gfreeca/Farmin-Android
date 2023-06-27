package com.gfreeca.farmin_android.presentation.ui.auth.component

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.gfreeca.farmin_android.design_system.theme.FarminTheme

@Composable
fun SignInButton(onClick: () -> Unit) {
    FarminTheme { colors, typography ->
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = colors.GRAY600)) {
                    append("이미 팜인 회원이신가요? ")
                }
                withStyle(style = SpanStyle(color = colors.GREEN600)) {
                    append("로그인")
                }
            },
            style = typography.label1,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.clickable(onClick = onClick)
        )
    }
}