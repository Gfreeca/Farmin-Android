package com.gfreeca.farmin_android.presentation.ui.main.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gfreeca.farmin_android.design_system.theme.FarminTheme
import com.gfreeca.farmin_android.presentation.ui.main.component.*
import com.gfreeca.farmin_android.presentation.viewmodel.MainViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel
) {
    val pagerState = rememberPagerState()
    val scrollState = rememberScrollState()

    FarminTheme { colors, _ ->
        Column(Modifier.fillMaxSize()) {
            MainTopBar()
            Divider(color = colors.GRAY200)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MainPager(pagerState = pagerState)
                Spacer(modifier = Modifier.height(24.dp))
                MainHeader("\uD83E\uDDD1\u200D\uD83C\uDF3E 주변에 이런 농장 알바가 있어요. ") {
                    //Todo : 공고 페이지로 이동
                }
                Spacer(modifier = Modifier.height(16.dp))
                GridRecruitmentComponent(viewModel.getRecruitListResponse.value?.data!!)
                FarminSpacer()
                Spacer(modifier = Modifier.height(24.dp))
                MainVideoListHeader {
                    //Todo : 유튭으로 이동
                }
                Spacer(modifier = Modifier.height(18.dp))
                MainVideoList()
                FarminSpacer()
                Spacer(modifier = Modifier.height(24.dp))
                MainHeader("\uD83D\uDCD1 농촌을 위한 이런 지원과 \n정책들이 있어요. ") {
                    //Todo : 지원과 정책 보러가기
                }
                Spacer(modifier = Modifier.height(16.dp))
                MainPolicyList()
            }
        }
    }
}