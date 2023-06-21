package com.gfreeca.farmin_android.presentation.ui.main.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainPolicyList() {
    LazyColumn(modifier = Modifier.height(260.dp)) {
        items(3) {
            PolicyListItem(
                "충남",
                "안녕하세요 나의 이름은 김현승"
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}