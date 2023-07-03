package com.gfreeca.farmin_android.presentation.ui.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.gfreeca.farmin_android.design_system.ArrowBackIcon
import com.gfreeca.farmin_android.design_system.theme.FarminTheme
import dagger.hilt.android.AndroidEntryPoint
import com.gfreeca.farmin_android.R
import com.gfreeca.farmin_android.design_system.MapPointerIcon

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
                    Column(modifier = Modifier.padding(vertical = 24.dp, horizontal = 16.dp)) {
                        Row {
                            MapPointerIcon()
                            Spacer(modifier = Modifier.width(3.dp))
                            Text(
                                text = "충주",
                                style = typography.label1,
                                fontWeight = FontWeight.Bold,
                                color = colors.BLACK
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "충주 사과 따기 모집", style = typography.title2, color = colors.BLACK)
                        Spacer(modifier = Modifier.height(16.dp))
                        Row {
                            Image(
                                painter = rememberAsyncImagePainter(""),
                                contentDescription = "Farm Owner Profile Image",
                                modifier = Modifier.clip(RoundedCornerShape(30.dp)),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Column {
                                Text(
                                    text = "지빈이네 사과 농장",
                                    style = typography.body2,
                                    color = colors.GRAY700
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = "윤지빈",
                                    style = typography.subtitle,
                                    color = colors.GRAY800
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}