package com.namnp.instagram_android.presentation.bottom_nav

import androidx.annotation.DrawableRes

data class BottomNavItem(
    val title: String,
    val route: String,
    @DrawableRes val icon: Int,
    @DrawableRes val selectedIcon: Int,
    val badgeCount: Int = 0,
    val showDot: Boolean = false,
)