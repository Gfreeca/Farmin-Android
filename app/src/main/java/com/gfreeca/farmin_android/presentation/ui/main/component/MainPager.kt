package com.gfreeca.farmin_android.presentation.ui.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.gfreeca.farmin_android.R
import com.gfreeca.farmin_android.design_system.theme.FarminTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainPager(pagerState: PagerState) {
    LaunchedEffect("Pager") {
        while (true) {
            delay(5000)
            pagerState.animateScrollToPage(if (pagerState.currentPage == 2) 0 else pagerState.currentPage + 1)
        }
    }

    FarminTheme { colors, _ ->
        Box {
            HorizontalPager(
                count = 3,
                state = pagerState,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.banner),
                    contentDescription = "Banner Image",
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                )
            }
            Column(modifier = Modifier.align(Alignment.BottomCenter)) {
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(color = if (pagerState.currentPage == 0) colors.GREEN500 else colors.GRAY600)) {
                            append("•")
                        }
                        withStyle(style = SpanStyle(color = if (pagerState.currentPage == 1) colors.GREEN500 else colors.GRAY600)) {
                            append(" • ")
                        }
                        withStyle(style = SpanStyle(color = if (pagerState.currentPage == 2) colors.GREEN500 else colors.GRAY600)) {
                            append("•")
                        }
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}