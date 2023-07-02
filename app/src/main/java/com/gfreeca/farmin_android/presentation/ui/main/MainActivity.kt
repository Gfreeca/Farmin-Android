package com.gfreeca.farmin_android.presentation.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gfreeca.farmin_android.design_system.theme.FarminTheme
import com.gfreeca.farmin_android.presentation.ui.main.component.Screen
import com.gfreeca.farmin_android.presentation.ui.main.screen.MainScreen
import com.gfreeca.farmin_android.presentation.ui.main.screen.RecruitScreen
import com.gfreeca.farmin_android.presentation.viewmodel.MainViewModel
import com.gfreeca.farmin_android.presentation.viewmodel.util.Event
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel.getRecruitList()

        observeGetRecruitListResponse()
    }

    private fun observeGetRecruitListResponse() {
        mainViewModel.getRecruitListResponse.observe(this) {
            setContent {
                when (it) {
                    is Event.Success -> {
                        val navController = rememberNavController()
                        val navItems =
                            listOf(
                                Screen.Home,
                                Screen.Recruit,
                                Screen.Festival,
                                Screen.Policy,
                                Screen.Profile
                            )

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
                                    MainScreen(
                                        navController = navController,
                                        viewModel = viewModel(LocalContext.current as MainActivity)
                                    )
                                }

                                composable(route = "recruit") {
                                    RecruitScreen(
                                        navController = navController,
                                        viewModel = viewModel(LocalContext.current as MainActivity)
                                    )
                                }
                            }
                        }
                    }
                    is Event.Loading -> {
                        CircularProgressIndicator()
                    }
                    else -> {
                        Text(text = it.toString())
                    }
                }
            }
        }
    }
}