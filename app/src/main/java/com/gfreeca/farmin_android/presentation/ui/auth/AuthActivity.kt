package com.gfreeca.farmin_android.presentation.ui.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gfreeca.farmin_android.presentation.ui.auth.screen.IntroScreen
import com.gfreeca.farmin_android.presentation.ui.auth.screen.SignInScreen
import com.gfreeca.farmin_android.presentation.ui.auth.screen.SplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "splash"
            ) {
                composable(route = "splash") {
                    SplashScreen(
                        navController = navController,
                        viewModel = viewModel(LocalContext.current as AuthActivity)
                    )
                }

                composable(route = "intro") {
                    IntroScreen(navController = navController)
                }

                composable(route = "signin") {
                    SignInScreen(
                        navController = navController,
                        viewModel = viewModel(LocalContext.current as AuthActivity)
                    )
                }
            }
        }
    }
}
