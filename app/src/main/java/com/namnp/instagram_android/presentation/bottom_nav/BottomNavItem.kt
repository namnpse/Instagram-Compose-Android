package com.namnp.instagram_android.presentation.bottom_nav

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val title: String,
    val route: String,
    val icon: ImageVector,
    val badgeCount: Int = 0,
    val showDot: Boolean = false,
)