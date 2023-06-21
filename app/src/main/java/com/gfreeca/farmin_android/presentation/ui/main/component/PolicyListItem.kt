package com.gfreeca.farmin_android.presentation.ui.main.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gfreeca.farmin_android.design_system.theme.FarminTheme

@Composable
fun PolicyListItem(
    region: String,
    description: String
) {
    FarminTheme { colors, typography ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Divider(color = colors.GRAY200)
            Spacer(modifier = Modifier.height(17.dp))
            Text(
                text = region,
                style = typography.subtitle,
                fontWeight = FontWeight.Bold,
                color = colors.BLACK
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = description,
                style = typography.body1,
                color = colors.GRAY800
            )
        }
    }
}