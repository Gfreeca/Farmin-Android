package com.gfreeca.farmin_android.presentation.ui.main.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gfreeca.farmin_android.domain.model.announcement.res.RecruitPostInfoModel

@Composable
fun GridRecruitmentComponent(
    list: List<RecruitPostInfoModel>,
    onItemClick: () -> Unit
) {
    if (list.isEmpty()) {
        Column(
            Modifier
                .fillMaxWidth()
                .height(580.dp)
        ) {
            CircularProgressIndicator()
        }
    } else {
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
                    imageUrl = list[it].thumbnail,
                    title = list[it].name,
                    description = list[it].farmName,
                    salary = list[it].pay,
                    area = list[it].location,
                    onItemClick = onItemClick
                )
            }
        }
    }
}