package com.gfreeca.farmin_android.presentation.ui.detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.gfreeca.farmin_android.design_system.theme.FarminTheme

@Composable
fun FarmProfileComponent(
    farmOwnerProfileImageUrl: String,
    farmName: String,
    farmOwner: String
) {
    FarminTheme { colors, typography ->
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberAsyncImagePainter(farmOwnerProfileImageUrl),
                contentDescription = "Farm Owner Profile Image",
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color.Red),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = farmName,
                    style = typography.body2,
                    color = colors.GRAY700
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = farmOwner,
                    style = typography.subtitle,
                    color = colors.BLACK,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}