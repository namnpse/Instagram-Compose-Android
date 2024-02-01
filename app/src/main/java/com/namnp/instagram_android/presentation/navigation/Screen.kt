package com.namnp.instagram_android.presentation.navigation

sealed class Screen(val route: String) {
    data object SplashScreen: Screen("splash_screen")
    data object WelcomeScreen: Screen("welcome_screen")
    data object LoginScreen: Screen("login_screen")

    data object MainApp: Screen("main")
    data object HomeScreen: Screen("home_screen")
    data object SearchScreen: Screen("search_screen")
    data object SearchPicksScreen: Screen("search_picks_screen")
    data object AddScreen: Screen("add_screen")
    data object FavoriteScreen: Screen("favorite_screen")
    data object ProfileScreen: Screen("profile_screen")
}