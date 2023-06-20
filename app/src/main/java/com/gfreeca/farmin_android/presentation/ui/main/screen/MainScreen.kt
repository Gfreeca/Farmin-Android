package com.gfreeca.farmin_android.presentation.ui.main.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
        MainTopBar {
            //Todo : 프로필 페이지로 이동
        }
        MainPager(pagerState = pagerState)
        Spacer(modifier = Modifier.height(24.dp))
        MainListHeader {
            //Todo : 공고 페이지로 이동
        }
        Spacer(modifier = Modifier.height(16.dp))
        GridRecruitmentComponent()
        FarminSpacer()
    }
}