package com.gfreeca.farmin_android.presentation.ui.main.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GridRecruitmentComponent() {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .height(580.dp)
            .padding(horizontal = 16.dp),
        columns = GridCells.Adaptive(minSize = 120.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        userScrollEnabled = false
    ) {
        items(4) {
            ListItem(
                imageUrl = "",
                title = "충주 사과 따기 모집",
                description = "지빈이네 사과 농장",
                salary = "10,000",
                area = "충주",
                variety = "사과"
            )
        }
    }
}