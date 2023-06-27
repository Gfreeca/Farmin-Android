package com.gfreeca.farmin_android.presentation.ui.auth.screen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gfreeca.farmin_android.design_system.FarminLogoIcon
import com.gfreeca.farmin_android.design_system.LogoTextIcon
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect("Delay") {
        delay(2000)
        navController.navigate("intro") {
            popUpTo("intro")
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            FarminLogoIcon(
                modifier = Modifier
                    .width(84.dp)
                    .height(45.dp)
            )
            Spacer(modifier = Modifier.width(14.dp))
            LogoTextIcon(
                modifier = Modifier
                    .width(133.dp)
                    .height(31.dp)
            )
        }
    }
}