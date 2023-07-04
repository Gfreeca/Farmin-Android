package com.gfreeca.farmin_android.presentation.ui.detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.gfreeca.farmin_android.design_system.ArrowBackIcon
import com.gfreeca.farmin_android.design_system.theme.FarminTheme

@Composable
fun DetailBannerComponent(
    bannerImageUrl: String,
    onBackButtonClick: () -> Unit
) {
    FarminTheme { colors, _ ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        ) {
            Image(
                painter = rememberAsyncImagePainter(bannerImageUrl),
                contentDescription = "Farm Banner Image",
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Red),
                contentScale = ContentScale.Crop
            )
            ArrowBackIcon(
                color = colors.WHITE,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 60.dp, start = 16.dp)
                    .clickable(onClick = onBackButtonClick)
            )
        }
    }
}