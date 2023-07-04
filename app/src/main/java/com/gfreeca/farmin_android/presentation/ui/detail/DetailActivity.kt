package com.gfreeca.farmin_android.presentation.ui.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gfreeca.farmin_android.design_system.*
import com.gfreeca.farmin_android.design_system.theme.FarminTheme
import com.gfreeca.farmin_android.presentation.ui.detail.component.DetailBannerComponent
import com.gfreeca.farmin_android.presentation.ui.detail.component.DetailHeaderComponent
import com.gfreeca.farmin_android.presentation.ui.detail.component.FarmDetailInfoItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FarminTheme { colors, typography ->
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    item {
                        DetailBannerComponent(bannerImageUrl = "") {
                            this@DetailActivity.finish()
                        }
                    }
                    item {
                        DetailHeaderComponent(
                            location = "충주",
                            title = "충주 사과 따기 모집",
                            farmOwnerProfileImageUrl = "",
                            farmName = "지빈이네 사과 농장",
                            farmOwner = "윤지빈"
                        )
                        Divider(thickness = 8.dp, color = colors.GRAY100)
                    }
                    item {
                        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                            Spacer(modifier = Modifier.height(24.dp))
                            FarmDetailInfoItem(
                                title = "소개글",
                                description = "“지빈이네 사과 농장” 농장주 윤지빈입니다. 햇살과 물이 좋은 충주으로 귀농하여 자연과 함께 농장을 가꾸며, 사과따기체험활동을 통해 도시와 농촌이 공존하며 더불어 살아가고 있습니다. 내 가족이 먹는다는 생각으로 껍질째 먹을 수 있는 안전한 먹거리, 바른 먹거리를 생산합니다. 생산자와 소비자가 함께 더불어 살아가는 세상 \"지빈이네 사과 농장”입니다 감사합니다."
                            ) { FarmIntroduceIcon() }
                            Spacer(modifier = Modifier.height(24.dp))
                            FarmDetailInfoItem(
                                title = "시급",
                                description = "10000원"
                            ) { HourlyWageIcon() }
                            Spacer(modifier = Modifier.height(24.dp))
                            FarmDetailInfoItem(
                                title = "주요 업무",
                                description = "• 사과 따기 및 포장 작업\n" +
                                        "• 사과 상태에 따라 상품 분류"
                            ) { MajorTaskIcon() }
                            Spacer(modifier = Modifier.height(24.dp))
                            FarmDetailInfoItem(
                                title = "근무 시간",
                                description = "06:00 ~ 18:00까지"
                            ) { WorkingHoursIcon() }
                            Spacer(modifier = Modifier.height(24.dp))
                            FarmDetailInfoItem(
                                title = "기간",
                                description = "2023.05.30 ~ 2023.07.24"
                            ) { WorkingDateIcon() }
                            Spacer(modifier = Modifier.height(24.dp))
                            FarmDetailInfoItem(
                                title = "혜택 및 복지",
                                description = "• 삼시세끼 제공\n" +
                                        "• 숙소 제공\n" +
                                        "• 수확량에 따른 성과금 지급"
                            ) { BenefitsAndWelfareIcon() }
                        }
                    }
                }
            }
        }
    }
}