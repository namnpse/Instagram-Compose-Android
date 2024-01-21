package com.namnp.instagram_android.utils

import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.namnp.instagram_android.presentation.ui.theme.statusBarColor

enum class Theme {
    Light, Dark
}

data class ThemeState(var theme: Theme) {
    fun toggleDarkMode() {
        theme = if (theme == Theme.Light) Theme.Dark else Theme.Light
    }
}

@Composable
fun rememberStatusBar(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = MaterialTheme.colorScheme.statusBarColor(isDarkTheme)
    )
}