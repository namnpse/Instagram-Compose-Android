package com.namnp.instagram_android.presentation.navigation

sealed class Screen(val route: String) {
    data object SplashScreen: Screen("splash_screen")
    data object WelcomeScreen: Screen("welcome_screen")
    data object LoginScreen: Screen("login_screen")
}