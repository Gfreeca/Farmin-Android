package com.gfreeca.farmin_android.presentation.ui.main.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainVideoList() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(270.dp)
    ) {
        item {
            Spacer(modifier = Modifier.width(16.dp))
        }
        items(4) {
            MainVideoListItem(
                thumbnailImageUrl = "",
                title = "$it 번 동영상",
                hits = "100만",
                timeSinceLaunch = "1일",
                userName = "김현승"
            )
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}