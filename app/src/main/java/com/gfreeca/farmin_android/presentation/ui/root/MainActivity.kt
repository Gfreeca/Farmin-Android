package com.gfreeca.farmin_android.presentation.ui.root

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
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
                                text = "홈"
                            ) {
                                navController.navigate("Main")
                            }
                            Spacer(modifier = Modifier.width(19.25.dp))
                            NavigationItem(
                                iconId = R.drawable.ic_navigation_recruit,
                                text = "농장 알바"
                            ) {
                                navController.navigate("Recruit")
                            }
                            Spacer(modifier = Modifier.width(19.25.dp))
                            NavigationItem(
                                iconId = R.drawable.ic_navigation_festival,
                                text = "지역축제"
                            ) {

                            }
                            Spacer(modifier = Modifier.width(19.25.dp))
                            NavigationItem(
                                iconId = R.drawable.ic_navigation_policy,
                                text = "지원사업"
                            ) {

                            }
                            Spacer(modifier = Modifier.width(19.25.dp))
                            NavigationItem(
                                iconId = R.drawable.ic_navigation_profile,
                                text = "My페이지"
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