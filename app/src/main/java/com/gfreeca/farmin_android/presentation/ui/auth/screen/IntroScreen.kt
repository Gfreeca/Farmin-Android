package com.gfreeca.farmin_android.presentation.ui.auth.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gfreeca.farmin_android.design_system.theme.FarminTheme

@Composable
fun IntroScreen(navController: NavController) {
    FarminTheme { colors, typography ->
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "내 주변 가까운 농촌!", style = typography.h1, color = colors.BLACK)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "팜인에서 내 주변 농촌 알바부터\n지역 축제,귀농까지",
                    style = typography.body1,
                    color = colors.GRAY600,
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(0.9f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = colors.BLUE500)
                ) {
                    Text(
                        text = "시작하기",
                        style = typography.subtitle,
                        fontWeight = FontWeight.Bold,
                        color = colors.WHITE,
                        modifier = Modifier.padding(vertical = 3.dp)
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
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
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}