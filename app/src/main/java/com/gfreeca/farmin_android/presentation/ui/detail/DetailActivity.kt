package com.gfreeca.farmin_android.presentation.ui.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gfreeca.farmin_android.design_system.*
import com.gfreeca.farmin_android.design_system.theme.FarminTheme
import com.gfreeca.farmin_android.presentation.ui.auth.component.FarminButton
import com.gfreeca.farmin_android.presentation.ui.detail.component.DetailBannerComponent
import com.gfreeca.farmin_android.presentation.ui.detail.component.DetailHeaderComponent
import com.gfreeca.farmin_android.presentation.ui.detail.component.FarmDetailInfoItem
import com.gfreeca.farmin_android.presentation.viewmodel.MainViewModel
import com.gfreeca.farmin_android.presentation.viewmodel.util.Event
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel.getRecruitDetail(intent.getIntExtra("idx", 0))
        observeDetailResponse()
    }

    private fun observeDetailResponse() {
        mainViewModel.getRecruitDetailResponse.observe(this) {
            when (it) {
                is Event.Success -> {
                    val response = it.data!!

                    setContent {
                        val singapore = LatLng(1.35, 103.87)
                        val cameraPositionState = rememberCameraPositionState {
                            position = CameraPosition.fromLatLngZoom(singapore, 10f)
                        }

                        FarminTheme { colors, typography ->
                            LazyColumn(modifier = Modifier.fillMaxSize()) {
                                item {
                                    DetailBannerComponent(bannerImageUrl = response.images[0]) {
                                        this@DetailActivity.finish()
                                    }
                                }
                                item {
                                    DetailHeaderComponent(
                                        location = response.location,
                                        title = response.name,
                                        farmOwnerProfileImageUrl = response.userProfile,
                                        farmName = response.farmName,
                                        farmOwner = response.userName
                                    )
                                    Divider(thickness = 8.dp, color = colors.GRAY100)
                                }
                                item {
                                    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                                        Spacer(modifier = Modifier.height(24.dp))
                                        FarmDetailInfoItem(
                                            title = "소개글",
                                            description = response.description
                                        ) { FarmIntroduceIcon() }
                                        Spacer(modifier = Modifier.height(24.dp))
                                        FarmDetailInfoItem(
                                            title = "시급",
                                            description = response.pay
                                        ) { HourlyWageIcon() }
                                        Spacer(modifier = Modifier.height(24.dp))
                                        FarmDetailInfoItem(
                                            title = "주요 업무",
                                            list = response.mainBusiness
                                        ) { MajorTaskIcon() }
                                        Spacer(modifier = Modifier.height(24.dp))
                                        FarmDetailInfoItem(
                                            title = "근무 시간",
                                            description =
                                            "${response.workingHours[0].hour}:${response.workingHours[0].minute} ~ ${response.workingHours[1].hour}:${response.workingHours[1].minute}까지"
                                        ) { WorkingHoursIcon() }
                                        Spacer(modifier = Modifier.height(24.dp))
                                        FarmDetailInfoItem(
                                            title = "기간",
                                            description = "${response.period[0]} ~ ${response.period[1]}"
                                        ) { WorkingDateIcon() }
                                        Spacer(modifier = Modifier.height(24.dp))
                                        FarmDetailInfoItem(
                                            title = "혜택 및 복지",
                                            list = response.benefit
                                        ) { BenefitsAndWelfareIcon() }
                                        Spacer(modifier = Modifier.height(16.dp))
                                        Divider(
                                            modifier = Modifier.fillMaxWidth(),
                                            color = colors.GRAY200,
                                            thickness = 2.dp
                                        )
                                        Spacer(modifier = Modifier.height(16.dp))
                                    }
                                }
                                item {
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Row(
                                        modifier = Modifier.padding(horizontal = 16.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "마감일",
                                            style = typography.label1,
                                            fontWeight = FontWeight.Bold,
                                            color = colors.GRAY800
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(
                                            text = response.deadline,
                                            style = typography.body1,
                                            color = colors.GRAY600
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(11.dp))
                                    Column(
                                        Modifier
                                            .padding(horizontal = 16.dp)
                                    ) {
                                        Text(
                                            text = "장소",
                                            style = typography.label1,
                                            fontWeight = FontWeight.Bold,
                                            color = colors.GRAY800
                                        )
                                        Spacer(modifier = Modifier.height(11.dp))
                                        GoogleMap(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(200.dp)
                                                .clip(RoundedCornerShape(10.dp)),
                                            cameraPositionState = cameraPositionState
                                        ) {
                                            Marker(
                                                state = MarkerState(position = singapore),
                                                title = response.location,
                                                snippet = "Marker in ${response.location}"
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(26.dp))
                                        FarminButton(text = "지원하기") {
                                            //Todo 지원하기
                                        }
                                        Spacer(modifier = Modifier.height(16.dp))
                                    }
                                }
                            }
                        }
                    }
                }
                else -> {}
            }
        }
    }
}