package com.namnp.instagram_android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.namnp.instagram_android.presentation.MainViewModel
import com.namnp.instagram_android.presentation.bottom_nav.MainApp
import com.namnp.instagram_android.presentation.login.LoginScreen
import com.namnp.instagram_android.presentation.login.WelcomeScreen

@Composable
fun InstagramNavGraph(
    mainViewModel: MainViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.MainApp.route,
    ) {
        composable(route = Screen.WelcomeScreen.route) {
            WelcomeScreen(
                navController = navController,
                mainViewModel = mainViewModel,
            )
        }
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(
                navController = navController,
            )
        }
        composable(route = Screen.MainApp.route) {
            MainApp(
                mainViewModel = mainViewModel,
            )
        }
    }

}