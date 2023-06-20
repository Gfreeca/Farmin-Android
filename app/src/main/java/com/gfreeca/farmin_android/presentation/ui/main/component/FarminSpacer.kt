package com.gfreeca.farmin_android.presentation.ui.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gfreeca.farmin_android.design_system.theme.FarminTheme

@Composable
fun FarminSpacer() {
    FarminTheme { colors, _ ->
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(16.dp)
            .background(colors.GRAY100))
    }
}