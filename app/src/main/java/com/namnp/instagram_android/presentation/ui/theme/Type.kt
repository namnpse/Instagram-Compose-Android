package com.namnp.instagram_android.presentation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val textNormal16_24 = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
)

val text600_14 = TextStyle(
    fontSize = 14.sp,
    fontWeight = FontWeight(600),
    color = Color.White,
    textAlign = TextAlign.Center,
    letterSpacing = 0.5.sp
)

val textNormal_12 = TextStyle(
    fontSize = 12.sp,
    color = Color.White,
    textAlign = TextAlign.Center,
    letterSpacing = 0.5.sp
)

val textNormal_13
    @Composable
    get() = TextStyle(
        fontSize = 13.sp,
        color = MaterialTheme.colorScheme.textPrimary,
        textAlign = TextAlign.Center,
        letterSpacing = 0.5.sp
    )