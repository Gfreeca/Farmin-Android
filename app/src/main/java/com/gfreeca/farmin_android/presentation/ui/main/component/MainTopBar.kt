package com.gfreeca.farmin_android.presentation.ui.main.component

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gfreeca.farmin_android.design_system.FarminLogoIcon
import com.gfreeca.farmin_android.design_system.LogoTextIcon

@Composable
fun MainTopBar() {
    Box(
        modifier = Modifier
            .padding(vertical = 13.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(16.dp))
            FarminLogoIcon()
            Spacer(modifier = Modifier.width(5.7.dp))
            LogoTextIcon()
        }
    }
}