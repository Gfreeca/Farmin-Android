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
import com.gfreeca.farmin_android.domain.model.announcement.res.RecruitPostInfoModel

@Composable
fun GridRecruitmentComponent(
    list: List<RecruitPostInfoModel>
) {
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
        items(list.size) {
            ListItem(
                imageUrl = list[it].thumbnail,
                title = list[it].name,
                description = list[it].farmName,
                salary = list[it].pay,
                area = list[it].location
            )
        }
    }
}