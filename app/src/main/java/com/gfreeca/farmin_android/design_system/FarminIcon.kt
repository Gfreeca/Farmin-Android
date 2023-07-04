package com.gfreeca.farmin_android.design_system

import androidx.compose.foundation.Image
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

@Composable
fun GrayLogoIcon(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.ic_gray_logo),
        contentDescription = "Gray Logo Icon",
        modifier = modifier
    )
}

@Composable
fun GrayMapPointerIcon(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.ic_gray_map_pointer),
        contentDescription = "Gray Map Pointer Icon",
        modifier = modifier
    )
}

@Composable
fun GraySearchIcon(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.ic_gray_search),
        contentDescription = "Gray Search Icon",
        modifier = modifier
    )
}

@Composable
fun ArrowBackIcon(
    modifier: Modifier = Modifier,
    color: Color = Color.Black
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_arrow_back),
        contentDescription = "Arrow Back Icon",
        modifier = modifier,
        tint = color
    )
}

@Composable
fun MapPointerIcon(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.ic_map_pointer),
        contentDescription = "Map Pointer Icon",
        modifier = modifier
    )
}

@Composable
fun EmptyContentLogo(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.ic_empty_content_view),
        contentDescription = "Empty Content View Logo Image",
        modifier = modifier
    )
}

@Composable
fun WorkingDateIcon(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.ic_working_date),
        contentDescription = "Working Data Icon",
        modifier = modifier
    )
}

@Composable
fun BenefitsAndWelfareIcon(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.ic_benefits_and_welfare),
        contentDescription = "Working Data Icon",
        modifier = modifier
    )
}

@Composable
fun HourlyWageIcon(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.ic_hourly_wage),
        contentDescription = "Working Data Icon",
        modifier = modifier
    )
}

@Composable
fun MajorTaskIcon(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.ic_major_task),
        contentDescription = "Working Data Icon",
        modifier = modifier
    )
}

@Composable
fun WorkingHoursIcon(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.ic_working_hours),
        contentDescription = "Working Data Icon",
        modifier = modifier
    )
}