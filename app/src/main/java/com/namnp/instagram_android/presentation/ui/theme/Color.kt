package com.namnp.instagram_android.presentation.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
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
val Blue300 = Color(0xFF3897F0)
val Black100 = Color(0x66000000)
val Black200 = Color(0xFF262626)
val Black300 = Color(0xB2121212)
val Black400 = Color(0x66000000)
val Black500 = Color(0xFF48484A)
val Black600 = Color(0xFF121212)
val Grey900 = Color(0x26FFFFFF)
val Grey800 = Color(0xFF8E8E93)
val Grey700 = Color(0x2E3C3C43)
val Grey600 = Color(0x1F767680)
val Grey500 = Color(0x993C3C43)
val Grey400 = Color(0x99FFFFFF)
val Grey300 = Color(0x4A3C3C43)
val Grey200 = Color(0x33000000)
val Grey100 = Color(0xFFFAFAFA)
val LightGrey = Color(0xFFEDEDED)
val White400 = Color(0xFFF9F9F9)
val White300 = Color(0xFFC7C7CC)


@Composable
fun ColorScheme.statusBarColor(darkTheme: Boolean): Color =
    if (!darkTheme) Color.White else Color.Black

val ColorScheme.backgroundColor: Color
    @Composable
    get() = White

val ColorScheme.isLight
    @Composable
    get() = this.background.luminance() > 0.5

val ColorScheme.colorPrimary
    @Composable
    get() = if (isLight) Black200 else White

val ColorScheme.textFieldBorder
    @Composable
    get() = if (isLight) Color(0x1A000000) else Color(0x33FFFFFF)

val ColorScheme.textFieldHint
    @Composable
    get() = if (isLight) Grey200 else Color(0x99FFFFFF)

val ColorScheme.textPrimary
    @Composable
    get() = if (isLight) Black200 else White

val ColorScheme.textSecondary
    @Composable
    get() = if (isLight) Black400 else Grey400

val ColorScheme.bottomBarSelectedIconColor
    @Composable
    get() = if (isLight) Black200 else Grey100

val ColorScheme.bottomBarUnselectedIconColor
    @Composable
    get() = if (isLight) Color.Gray else Grey100.copy(alpha = 0.5f)

val ColorScheme.bottomBarIndicatorColor
    @Composable
//    get() = if (isLight) Color(0x00FAFAFA) else Color(0xFF121212)
    get() = if (isLight) Color(0x00FAFAFA) else Color.Black.copy(alpha = 0.1f)

val ColorScheme.unselectedDotIndicatorColor
    @Composable
    get() = if (isLight) Grey300.copy(alpha = 0.2f) else Grey300.copy(alpha = 1f)

val ColorScheme.primarySearchColor
    @Composable
    get() = if (isLight) Grey500 else Grey800

val ColorScheme.borderColor
    @Composable
    get() = if (isLight) Grey700 else Grey900

val ColorScheme.selectedTabBar
    @Composable
    get() = if (isLight) Black200 else White400

val ColorScheme.unselectedTabBar
    @Composable
    get() = if (isLight) Black400 else Grey400

val ColorScheme.profileBorder
    @Composable
    get() = if (isLight) White300 else Black500

val ColorScheme.backgroundSecondary
    @Composable
    get() = if (isLight) Grey100 else Black600

val ColorScheme.dividerColor
    @Composable
    get() = if (isLight) LightGrey else Grey700

val ColorScheme.textFieldColor: TextFieldColors
    @Composable
    get() = TextFieldDefaults.colors(
        focusedTextColor = MaterialTheme.colorScheme.textPrimary,
        unfocusedTextColor = MaterialTheme.colorScheme.textPrimary,
        disabledTextColor = Color.Transparent,
        focusedContainerColor = backgroundSecondary,
        unfocusedContainerColor = backgroundSecondary,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        focusedLabelColor = Blue200,
        unfocusedLabelColor = if (isLight) Color(0x33000000) else Grey100,
    )