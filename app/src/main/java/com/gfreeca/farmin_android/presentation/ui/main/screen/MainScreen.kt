package com.gfreeca.farmin_android.presentation.ui.main.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gfreeca.farmin_android.R
import com.gfreeca.farmin_android.design_system.theme.FarminTheme
import com.gfreeca.farmin_android.presentation.ui.main.component.MainTopBar
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen(
    navController: NavController
) {
    val pagerState = rememberPagerState()

    FarminTheme { colors, typography ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            MainTopBar {
                //Todo : 프로필 페이지로 이동
            }
            Box {
                HorizontalPager(
                    count = 3,
                    state = pagerState,
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_logo_text),
                        contentDescription = ""
                    )
                }
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(color = colors.GRAY600)) {
                            append("•")
                        }
                        withStyle(style = SpanStyle(color = colors.GRAY600)) {
                            append(" • ")
                        }
                        withStyle(style = SpanStyle(color = colors.GRAY600)) {
                            append("•")
                        }
                    }
                )
            }
        }
    }
}