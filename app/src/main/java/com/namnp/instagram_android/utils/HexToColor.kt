package com.namnp.instagram_android.utils

import androidx.compose.ui.graphics.Color

fun Color.getColor(colorString: String): Color {
    return Color(android.graphics.Color.parseColor("#$colorString"))
}