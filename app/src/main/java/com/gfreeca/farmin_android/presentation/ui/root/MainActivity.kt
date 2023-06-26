package com.gfreeca.farmin_android.presentation.ui.root

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gfreeca.farmin_android.design_system.theme.FarminTheme
import com.gfreeca.farmin_android.presentation.ui.main.component.Screen
import com.gfreeca.farmin_android.presentation.ui.main.screen.MainScreen
import com.gfreeca.farmin_android.presentation.ui.main.screen.RecruitScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val navItems =
                listOf(Screen.Home, Screen.Recruit, Screen.Festival, Screen.Policy, Screen.Profile)

            Scaffold(
                bottomBar = {
                    FarminTheme { colors, typography ->
                        BottomNavigation(
                            backgroundColor = colors.WHITE,
                            contentColor = colors.GRAY600
                        ) {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentRoute = navBackStackEntry?.destination?.route

                            navItems.forEach { screen ->
                                BottomNavigationItem(
                                    icon = {
                                        Image(
                                            painter = painterResource(screen.icon),
                                            contentDescription = "Nav Item Icon"
                                        )
                                    },
                                    label = {
                                        Text(
                                            text = screen.title,
                                            style = typography.caption,
                                            fontWeight = FontWeight.Medium
                                        )
                                    },
                                    selected = currentRoute == screen.route,
                                    onClick = {
                                        navController.navigate(screen.route) {
                                            popUpTo(navController.graph.startDestinationId)
                                            launchSingleTop = true
                                        }
                                    },
                                    selectedContentColor = colors.BLACK,
                                    unselectedContentColor = colors.GRAY600
                                )
                            }
                        }
                    }
                }
            ) {
                NavHost(
                    navController = navController,
                    startDestination = "home",
                    modifier = Modifier.padding(it)
                ) {
                    composable(route = "home") {
                        MainScreen(navController = navController)
                    }

                    composable(route = "recruit") {
                        RecruitScreen(navController = navController)
                    }
                }
            }
        }
    }
}