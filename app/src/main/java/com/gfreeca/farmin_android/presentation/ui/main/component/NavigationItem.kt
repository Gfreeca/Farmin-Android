package com.gfreeca.farmin_android.presentation.ui.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gfreeca.farmin_android.design_system.theme.FarminTheme

@Composable
fun NavigationItem(iconId: Int, text: String, isCurrentPage: Boolean, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .width(45.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FarminTheme { colors, typography ->
            Image(
                painter = painterResource(id = iconId),
                contentDescription = "Navigation Home Icon"
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = text,
                style = typography.caption,
                fontWeight = FontWeight.Medium,
                color = if (isCurrentPage) colors.BLACK else colors.GRAY600
            )
        }
    }
}