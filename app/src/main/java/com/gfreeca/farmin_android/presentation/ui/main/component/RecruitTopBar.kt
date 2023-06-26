package com.gfreeca.farmin_android.presentation.ui.main.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gfreeca.farmin_android.design_system.GrayLogoIcon
import com.gfreeca.farmin_android.design_system.GrayMapPointerIcon
import com.gfreeca.farmin_android.design_system.GraySearchIcon

@Composable
fun RecruitTopBar(
    onSearchButtonClick: () -> Unit,
    onMapPointerButtonClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(vertical = 13.dp, horizontal = 16.dp)
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.align(Alignment.CenterStart)) {
            GrayLogoIcon()
        }
        Row(modifier = Modifier.align(Alignment.CenterEnd)) {
            GraySearchIcon(modifier = Modifier.clickable(onClick = onSearchButtonClick))
            Spacer(modifier = Modifier.width(4.dp))
            GrayMapPointerIcon(modifier = Modifier.clickable(onClick = onMapPointerButtonClick))
        }
    }
}