package com.gfreeca.farmin_android.presentation.ui.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gfreeca.farmin_android.R
import com.gfreeca.farmin_android.design_system.theme.FarminTheme

@Composable
fun MainListHeader(onSeeMoreButtonClick: () -> Unit) {
    FarminTheme { colors, typography ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "\uD83E\uDDD1\u200D\uD83C\uDF3E 주변에 이런 농장 알바가 있어요.",
                style = typography.caption1,
                color = colors.BLACK,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterStart)
            )
            Row(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .clickable(onClick = onSeeMoreButtonClick),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "더보기", color = colors.GRAY600)
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow),
                    contentDescription = "Arrow Icon"
                )
            }
        }
    }
}