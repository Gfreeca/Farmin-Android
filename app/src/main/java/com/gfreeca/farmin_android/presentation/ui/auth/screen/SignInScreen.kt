package com.gfreeca.farmin_android.presentation.ui.auth.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gfreeca.farmin_android.design_system.ArrowBackIcon
import com.gfreeca.farmin_android.design_system.theme.FarminTheme
import com.gfreeca.farmin_android.presentation.ui.auth.component.FarminButton
import com.gfreeca.farmin_android.presentation.ui.auth.component.FarminTextField

@Composable
fun SignInScreen(navController: NavController) {
    val id = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    val isError = remember {
        mutableStateOf(false)
    }
    val errorMsg = remember {
        mutableStateOf("")
    }

    FarminTheme { colors, typography ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter)
            ) {
                Spacer(modifier = Modifier.height(19.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    ArrowBackIcon(modifier = Modifier.clickable { navController.popBackStack() })
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "로그인", style = typography.title1, color = colors.BLACK)
                }
                Spacer(modifier = Modifier.height(29.dp))
                Text(
                    text = "아이디",
                    style = typography.label1,
                    color = colors.GRAY700,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                FarminTextField(
                    setText = id.value,
                    placeHolder = "아이디를 입력해주세요.",
                    maxLines = 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                ) {
                    id.value = it
                }
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "비밀번호",
                    style = typography.label1,
                    color = colors.GRAY700,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                FarminTextField(
                    setText = password.value,
                    placeHolder = "비밀번호를 입력해주세요.",
                    maxLines = 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                ) {
                    password.value = it
                }
                Spacer(modifier = Modifier.height(24.dp))
                if (isError.value) {
                    Text(
                        text = "*${errorMsg.value}",
                        style = typography.body2,
                        color = Color(0xFFFF001F)
                    )
                }
            }
            Column(modifier = Modifier.align(Alignment.BottomCenter)) {
                FarminButton(text = "로그인") {

                }
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}