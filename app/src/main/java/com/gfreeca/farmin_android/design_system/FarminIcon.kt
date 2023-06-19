package com.gfreeca.farmin_android.design_system

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.gfreeca.farmin_android.R

@Composable
fun FarminLogoIcon(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.ic_farmin_logo),
        contentDescription = "Farmin Logo Icon",
        modifier = modifier
    )
}

@Composable
fun LogoTextIcon(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.ic_logo_text),
        contentDescription = "Logo Text Icon",
        modifier = modifier
    )
}

@Composable
fun ProfileIcon(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.ic_profile),
        contentDescription = "Profile Icon",
        modifier = modifier
    )
}