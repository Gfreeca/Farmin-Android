package com.gfreeca.farmin_android.presentation.ui.main.screen

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gfreeca.farmin_android.presentation.ui.detail.DetailActivity
import com.gfreeca.farmin_android.presentation.ui.main.MainActivity
import com.gfreeca.farmin_android.presentation.ui.main.component.ListItem
import com.gfreeca.farmin_android.presentation.ui.main.component.RecruitTopBar
import com.gfreeca.farmin_android.presentation.viewmodel.MainViewModel

@Composable
fun RecruitScreen(
    navController: NavController,
    viewModel: MainViewModel
) {
    val itemList = viewModel.getRecruitListResponse.value!!.data!!
    val listState = rememberLazyGridState()
    val isScrolled = remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current as MainActivity

    Column(modifier = Modifier.fillMaxSize()) {
        RecruitTopBar(
            isScrolled = isScrolled.value,
            onSearchButtonClick = {

            },
            onMapPointerButtonClick = {

            }
        )
        if (itemList.isEmpty()) {
            Column(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator()
            }
        } else {
            LaunchedEffect("isScrolled") {
                snapshotFlow { listState.layoutInfo.visibleItemsInfo.first().index != 0 }.collect {
                    if (isScrolled.value != it) isScrolled.value = it
                }
            }

            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                columns = GridCells.Adaptive(minSize = 120.dp),
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                state = listState
            ) {
                items(itemList.size) {
                    ListItem(
                        imageUrl = itemList[it].thumbnail,
                        title = itemList[it].name,
                        description = itemList[it].farmName,
                        salary = itemList[it].pay,
                        area = itemList[it].location,
                        onItemClick = {
                            context.startActivity(Intent(context, DetailActivity::class.java))
                        }
                    )
                }
            }
        }
    }
}