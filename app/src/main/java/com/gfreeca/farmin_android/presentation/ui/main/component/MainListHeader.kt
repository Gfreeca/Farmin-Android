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
fun MainHeader(
    text: String,
    onSeeMoreButtonClick: () -> Unit
) {
    FarminTheme { colors, typography ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = text,
                style = typography.title3,
                color = colors.BLACK,
                fontWeight = FontWeight(700),
                modifier = Modifier.align(Alignment.CenterStart)
            )
            Row(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .clickable(onClick = onSeeMoreButtonClick),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "더보기",
                    style = typography.body2,
                    color = colors.GRAY600,
                    fontWeight = FontWeight(500)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow),
                    contentDescription = "Arrow Icon"
                )
            }
        }
    }
}