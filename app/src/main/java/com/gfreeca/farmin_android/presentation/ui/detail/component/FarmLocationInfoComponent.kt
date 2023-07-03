package com.gfreeca.farmin_android.presentation.ui.detail.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gfreeca.farmin_android.design_system.MapPointerIcon
import com.gfreeca.farmin_android.design_system.theme.FarminTheme

@Composable
fun FarmLocationInfoComponent(
    location: String,
    title: String
) {
    FarminTheme { colors, typography ->
        Row {
            MapPointerIcon()
            Spacer(modifier = Modifier.width(3.dp))
            Text(
                text = location,
                style = typography.label1,
                fontWeight = FontWeight.Bold,
                color = colors.BLACK
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = title, style = typography.title2, color = colors.BLACK)
    }
}