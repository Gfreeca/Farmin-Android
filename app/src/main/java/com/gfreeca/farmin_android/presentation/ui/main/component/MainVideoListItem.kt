package com.gfreeca.farmin_android.presentation.ui.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gfreeca.farmin_android.R
import com.gfreeca.farmin_android.design_system.theme.FarminTheme

@Composable
fun MainVideoListItem(
    thumbnailImageUrl: String,
    title: String,
    hits: String,
    timeSinceLaunch: String,
    userName: String
) {
    FarminTheme { colors, typography ->
        Column(modifier = Modifier.width(250.dp)) {
            Image(
                painter = painterResource(id = R.drawable.banner),
                contentDescription = "Thumbnail Image",
                modifier = Modifier
                    .width(250.dp)
                    .height(140.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {
                        //Todo : 받아온 Url로 연결되게 코드작성
                    },
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = title,
                style = typography.subtitle,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "조회수 ${hits}회 • $timeSinceLaunch 전",
                style = typography.label2,
                fontWeight = FontWeight.Medium,
                color = colors.GRAY600
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_map_pointer),
                    contentDescription = "User Profile"
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = userName,
                    style = typography.label2,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}