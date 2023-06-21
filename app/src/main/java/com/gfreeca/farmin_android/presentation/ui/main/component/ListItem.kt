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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.gfreeca.farmin_android.R
import com.gfreeca.farmin_android.design_system.theme.FarminTheme

@Composable
fun ListItem(
    imageUrl: String,
    title: String,
    description: String,
    salary: String,
    area: String,
    variety: String
) {
    FarminTheme { colors, typography ->
        Column(modifier = Modifier
            .width(164.dp)
            .clickable {

            }) {
            Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "List Item Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.ic_map_pointer),
                    contentDescription = "Map Pointer Icon"
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = area,
                    style = typography.label2,
                    color = colors.GRAY800,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                modifier = Modifier.fillMaxWidth(),
                overflow = TextOverflow.Ellipsis,
                style = typography.subtitle,
                fontWeight = FontWeight(700),
                color = colors.BLACK
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = description,
                modifier = Modifier.fillMaxWidth(),
                overflow = TextOverflow.Ellipsis,
                style = typography.caption,
                fontWeight = FontWeight(500),
                color = colors.GRAY600
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "시급 ${salary}원",
                modifier = Modifier.fillMaxWidth(),
                overflow = TextOverflow.Ellipsis,
                style = typography.label1,
                fontWeight = FontWeight(700),
                color = colors.GRAY800
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}