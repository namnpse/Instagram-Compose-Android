package com.namnp.instagram_android.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.luminance

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Blue200 = Color(0xFF3797EF)
val Black200 = Color(0xFF262626)
val Black400 = Color(0x66000000)
val Black500 = Color(0xFF262626)
val Grey400 = Color(0x99FFFFFF)
val Grey300 = Color(0x4A3C3C43)
val Grey200 = Color(0x33000000)
val Grey100 = Color(0xFFFAFAFA)

@Composable
fun ColorScheme.statusBarColor(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
): Color {
    return if (!isDarkTheme) Color.White else Color.Black
}

val ColorScheme.backgroundColor: Color
    @Composable
    get() = White

val ColorScheme.isLight
    @Composable
    get() = this.background.luminance() > 0.5

val ColorScheme.backIcon
    @Composable
    get() = if (isLight) Black500 else White

val ColorScheme.textFieldBorder
    @Composable
    get() = if (isLight) Color(0x1A000000) else Color(0x33FFFFFF)

val ColorScheme.textFieldHint
    @Composable
    get() = if (isLight) Grey200 else Color(0x99FFFFFF)

val ColorScheme.textSecondary
    @Composable
    get() = if (isLight) Black400 else Grey400

val ColorScheme.textFieldColor: TextFieldColors
    @Composable
    get() = TextFieldDefaults.colors(
        focusedTextColor = if (isLight) Black200 else White,
        unfocusedTextColor = if (isLight) Black200 else White,
        disabledTextColor = Color.Transparent,
        focusedContainerColor = if (isLight) Grey100 else Color(0xFF121212),
        unfocusedContainerColor = if (isLight) Grey100 else Color(0xFF121212),
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        focusedLabelColor = Blue200,
        unfocusedLabelColor = if (isLight) Color(0x33000000) else Grey100,
    )