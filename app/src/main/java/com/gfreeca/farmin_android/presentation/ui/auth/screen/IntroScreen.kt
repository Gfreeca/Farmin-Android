package com.gfreeca.farmin_android.presentation.ui.auth.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gfreeca.farmin_android.design_system.theme.FarminTheme
import com.gfreeca.farmin_android.presentation.ui.auth.component.SignInButton
import com.gfreeca.farmin_android.presentation.ui.auth.component.SignUpButton

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
                SignUpButton {
                    //TODO: 회원가입 페이지로 이동
                }
                Spacer(modifier = Modifier.height(24.dp))
                SignInButton {
                    navController.navigate("signin")
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}