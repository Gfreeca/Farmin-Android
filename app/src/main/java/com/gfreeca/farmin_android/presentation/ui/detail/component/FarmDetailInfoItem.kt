package com.gfreeca.farmin_android.presentation.ui.detail.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gfreeca.farmin_android.design_system.theme.FarminTheme

@Composable
fun FarmDetailInfoItem(
    title: String,
    description: String? = null,
    list: List<String> = listOf(),
    icon: @Composable () -> Unit
) {
    FarminTheme { colors, typography ->
        Row {
            icon()
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = title,
                style = typography.subtitle,
                fontWeight = FontWeight.Bold,
                color = colors.BLACK
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        if (description == null) {
            Column {
                list.forEach {
                    Text(
                        text = "• $it",
                        style = typography.body1,
                        color = colors.GRAY600
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                }
            }
        } else {
            Text(
                text = description,
                style = typography.body1,
                color = colors.GRAY600
            )
        }
    }
}