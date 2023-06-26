package com.gfreeca.farmin_android.presentation.ui.main.component

import com.gfreeca.farmin_android.R

enum class Screen(
    val route: String,
    val title: String,
    val icon: Int
) {
    Home(
        "home",
        "홈",
        R.drawable.ic_navigation_home
    ),
    Recruit(
        "recruit",
        "농장 알바",
        R.drawable.ic_navigation_recruit
    ),
    Festival(
        "festival",
        "지역 축제",
        R.drawable.ic_navigation_festival
    ),
    Policy(
        "policy",
        "지원 사업",
        R.drawable.ic_navigation_policy
    ),
    Profile(
        "profile",
        "My 페이지",
        R.drawable.ic_navigation_profile
    )
}