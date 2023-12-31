package com.gfreeca.farmin_android.presentation.ui.auth.screen

import android.content.Intent
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gfreeca.farmin_android.design_system.ArrowBackIcon
import com.gfreeca.farmin_android.design_system.theme.FarminTheme
import com.gfreeca.farmin_android.presentation.ui.auth.AuthActivity
import com.gfreeca.farmin_android.presentation.ui.auth.component.FarminButton
import com.gfreeca.farmin_android.presentation.ui.auth.component.FarminTextField
import com.gfreeca.farmin_android.presentation.ui.main.MainActivity
import com.gfreeca.farmin_android.presentation.viewmodel.AuthViewModel
import com.gfreeca.farmin_android.presentation.viewmodel.util.Event

@Composable
fun SignInScreen(
    navController: NavController,
    viewModel: AuthViewModel
) {
    val context = LocalContext.current as AuthActivity
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
    val buttonEnabled = remember {
        mutableStateOf(true)
    }

    observeLoginResponse(
        viewModel = viewModel,
        context = context,
        onError = {
            isError.value = true
            errorMsg.value = it
            buttonEnabled.value = true
        },
        onSuccess = {
            context.startActivity(Intent(context, MainActivity::class.java))
            context.finish()
        }
    )

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
                    visualTransformation = PasswordVisualTransformation(),
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
                FarminButton(
                    text = "로그인",
                    enabled = buttonEnabled.value
                ) {
                    if (id.value.isBlank() && password.value.isBlank()) {
                        isError.value = true
                        errorMsg.value = "아이디 및 비밀번호를 입력해주세요."
                    } else {
                        viewModel.signIn(id.value, password.value)
                        buttonEnabled.value = false
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

private fun observeLoginResponse(
    viewModel: AuthViewModel,
    context: AuthActivity,
    onSuccess: () -> Unit,
    onError: (String) -> Unit
) {
    viewModel.signInResponse.observe(context) {
        when (it) {
            is Event.Success -> onSuccess()
            is Event.BadRequest -> onError("400 배드 리퀘스트")
            is Event.NotFound -> onError("404 낫 파운드")
            else -> onError("알 수 없는 에러 발생")
        }
    }
}