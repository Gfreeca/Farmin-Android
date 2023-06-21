package com.gfreeca.farmin_android.presentation.ui.main.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gfreeca.farmin_android.presentation.ui.main.component.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen(
    navController: NavController
) {
    val pagerState = rememberPagerState()
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MainHeader("\uD83E\uDDD1\u200D\uD83C\uDF3E 주변에 이런 농장 알바가 있어요. ") {
            //Todo : 프로필 페이지로 이동
        }
        MainPager(pagerState = pagerState)
        Spacer(modifier = Modifier.height(24.dp))
        MainHeader("\u200D \uD83E\uDD14 농장 알바는 뭘 할까요?") {
            //Todo : 공고 페이지로 이동
        }
        Spacer(modifier = Modifier.height(16.dp))
        GridRecruitmentComponent()
        FarminSpacer()
        Spacer(modifier = Modifier.height(24.dp))
        MainVideoListHeader {
            //Todo : 유튭으로 이동
        }
        Spacer(modifier = Modifier.height(18.dp))
        MainVideoList()
        Spacer(modifier = Modifier.height(24.dp))

    }
}