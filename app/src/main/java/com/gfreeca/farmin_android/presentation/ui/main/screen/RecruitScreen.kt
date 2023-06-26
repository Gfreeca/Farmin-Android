package com.gfreeca.farmin_android.presentation.ui.main.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gfreeca.farmin_android.presentation.ui.main.component.ListItem
import com.gfreeca.farmin_android.presentation.ui.main.component.RecruitTopBar

@Composable
fun RecruitScreen(
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxSize()) {
        RecruitTopBar(
            onSearchButtonClick = {

            },
            onMapPointerButtonClick = {

            }
        )
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            columns = GridCells.Adaptive(minSize = 120.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(8) {
                ListItem(
                    imageUrl = "",
                    title = "충주 사과 따기 모집",
                    description = "지빈이네 사과 농장",
                    salary = "10,000",
                    area = "충주"
                )
            }
        }
    }
}