package com.namnp.instagram_android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.namnp.instagram_android.presentation.MainViewModel
import com.namnp.instagram_android.presentation.add.AddScreen
import com.namnp.instagram_android.presentation.favorite_screen.FavoriteScreen
import com.namnp.instagram_android.presentation.home.HomeScreen
import com.namnp.instagram_android.presentation.profile.edit_profile.EditProfileScreen
import com.namnp.instagram_android.presentation.profile.user_profile.ProfileScreen
import com.namnp.instagram_android.presentation.search.SearchScreen
import com.namnp.instagram_android.presentation.search.search_picks.AllSearchPickScreen
import com.namnp.instagram_android.presentation.story.StoryScreen

@Composable
fun MainNavigation(
    navController: NavHostController,
    mainViewModel: MainViewModel = hiltViewModel(),
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route,
    ) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(
                navController = navController,
            )
        }
        composable(route = Screen.SearchScreen.route) {
            SearchScreen(
                navController = navController,
            )
        }
        composable(route = Screen.AddScreen.route) {
            AddScreen()
        }
        composable(route = Screen.FavoriteScreen.route) {
            FavoriteScreen()
        }
        composable(route = Screen.ProfileScreen.route) {
            ProfileScreen(
                navController = navController,
            )
        }
        composable(route = Screen.SearchPicksScreen.route) {
            AllSearchPickScreen(
                navController = navController,
            )
        }
        composable(route = Screen.StoryScreen.route) {
            StoryScreen(
                navController = navController,
            )
        }
        composable(route = Screen.EditProfileScreen.route) {
            EditProfileScreen(
                navController = navController,
            )
        }
    }
}