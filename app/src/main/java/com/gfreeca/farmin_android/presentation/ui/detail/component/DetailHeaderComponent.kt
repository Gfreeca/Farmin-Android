package com.gfreeca.farmin_android.presentation.ui.detail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailHeaderComponent(
    location: String,
    title: String,
    farmOwnerProfileImageUrl: String,
    farmName: String,
    farmOwner: String
) {
    Column(modifier = Modifier.padding(vertical = 24.dp, horizontal = 16.dp)) {
        FarmLocationInfoComponent(location = location, title = title)
        Spacer(modifier = Modifier.height(16.dp))
        FarmProfileComponent(
            farmOwnerProfileImageUrl = farmOwnerProfileImageUrl,
            farmName = farmName,
            farmOwner = farmOwner
        )
    }
}