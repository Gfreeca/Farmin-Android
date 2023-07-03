package com.gfreeca.farmin_android.presentation.ui.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.gfreeca.farmin_android.design_system.ArrowBackIcon
import com.gfreeca.farmin_android.design_system.theme.FarminTheme
import dagger.hilt.android.AndroidEntryPoint
import com.gfreeca.farmin_android.R

@AndroidEntryPoint
class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FarminTheme { colors, typography ->
                Column() {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(R.drawable.banner),
                            contentDescription = "Farm Banner Image",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        ArrowBackIcon(
                            color = colors.WHITE,
                            modifier = Modifier
                                .align(Alignment.TopStart)
                                .padding(top = 60.dp, start = 16.dp)
                        )
                    }
                }
            }
        }
    }
}