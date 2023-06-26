package com.gfreeca.farmin_android.presentation.ui.root

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gfreeca.farmin_android.R
import com.gfreeca.farmin_android.design_system.theme.FarminTheme
import com.gfreeca.farmin_android.presentation.ui.main.component.NavigationItem
import com.gfreeca.farmin_android.presentation.ui.main.screen.MainScreen
import com.gfreeca.farmin_android.presentation.ui.main.screen.RecruitScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val currentIsHome = remember {
                mutableStateOf(true)
            }
            val currentIsRecruit = remember {
                mutableStateOf(false)
            }
            val currentIsFestival = remember {
                mutableStateOf(false)
            }
            val currentIsPolicy = remember {
                mutableStateOf(false)
            }
            val currentIsMyPage = remember {
                mutableStateOf(false)
            }

            Box(modifier = Modifier.fillMaxSize()) {
                NavHost(
                    navController = navController,
                    startDestination = "Main",
                    modifier = Modifier.align(Alignment.TopCenter)
                ) {
                    composable(route = "Main") {
                        MainScreen(navController = navController)
                    }

                    composable(route = "Recruit") {
                        RecruitScreen(navController = navController)
                    }
                }
                FarminTheme { colors, _ ->
                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .background(colors.WHITE)
                    ) {
                        Divider(color = colors.GRAY200)
                        Spacer(modifier = Modifier.height(7.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            NavigationItem(
                                iconId = R.drawable.ic_navigation_home,
                                text = "홈",
                                isCurrentPage = currentIsHome.value
                            ) {
                                currentIsHome.value = true
                                currentIsRecruit.value = false
                                currentIsFestival.value = false
                                currentIsPolicy.value = false
                                currentIsMyPage.value = false

                                navController.navigate("Main")
                            }
                            Spacer(modifier = Modifier.width(19.25.dp))
                            NavigationItem(
                                iconId = R.drawable.ic_navigation_recruit,
                                text = "농장 알바",
                                isCurrentPage = currentIsRecruit.value
                            ) {
                                currentIsHome.value = false
                                currentIsRecruit.value = true
                                currentIsFestival.value = false
                                currentIsPolicy.value = false
                                currentIsMyPage.value = false

                                navController.navigate("Recruit")
                            }
                            Spacer(modifier = Modifier.width(19.25.dp))
                            NavigationItem(
                                iconId = R.drawable.ic_navigation_festival,
                                text = "지역축제",
                                isCurrentPage = currentIsFestival.value
                            ) {

                            }
                            Spacer(modifier = Modifier.width(19.25.dp))
                            NavigationItem(
                                iconId = R.drawable.ic_navigation_policy,
                                text = "지원사업",
                                isCurrentPage = currentIsPolicy.value
                            ) {

                            }
                            Spacer(modifier = Modifier.width(19.25.dp))
                            NavigationItem(
                                iconId = R.drawable.ic_navigation_profile,
                                text = "My페이지",
                                isCurrentPage = currentIsMyPage.value
                            ) {

                            }
                        }
                        Spacer(modifier = Modifier.height(7.dp))
                    }
                }
            }
        }
    }
}