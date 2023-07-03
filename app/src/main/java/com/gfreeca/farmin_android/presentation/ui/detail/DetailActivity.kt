package com.gfreeca.farmin_android.presentation.ui.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.gfreeca.farmin_android.design_system.theme.FarminTheme
import com.gfreeca.farmin_android.presentation.ui.detail.component.DetailBannerComponent
import com.gfreeca.farmin_android.presentation.ui.detail.component.DetailHeaderComponent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FarminTheme { colors, typography ->
                Column(modifier = Modifier.fillMaxSize()) {
                    DetailBannerComponent(bannerImageUrl = "") {
                        this@DetailActivity.finish()
                    }
                    DetailHeaderComponent(
                        location = "충주",
                        title = "충주 사과 따기 모집",
                        farmOwnerProfileImageUrl = "",
                        farmName = "지빈이네 사과 농장",
                        farmOwner = "윤지빈"
                    )
                }
            }
        }
    }
}