package com.namnp.instagram_android.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.namnp.instagram_android.domain.repository.bottomNavItems
import com.namnp.instagram_android.presentation.MainViewModel
import com.namnp.instagram_android.presentation.bottom_nav.BottomNavigationBar
import com.namnp.instagram_android.presentation.navigation.MainNavigation
import com.namnp.instagram_android.presentation.navigation.Screen

@Composable
fun MainScreen(
    mainViewModel: MainViewModel = hiltViewModel(),
) {
    val navController = rememberNavController()
//    // Subscribe to navBackStackEntry, required to get current route
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var selectedItem by rememberSaveable { // handle config changes
        mutableStateOf(bottomNavItems.first())
    }
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    when (navBackStackEntry?.destination?.route) {
        Screen.StoryScreen.route -> {
            bottomBarState.value = false // hide bottom nav to view full StoryScreen
        }
        else -> bottomBarState.value = true
    }
    Scaffold(
        bottomBar = {
            if (bottomBarState.value)
                BottomNavigationBar(
                    items = bottomNavItems,
                    navController = navController,
                    selectedItem = selectedItem,
                    onItemClick = { navItem ->
                        selectedItem = navItem
                        navController.navigate(navItem.route) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                )
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            MainNavigation(
                navController = navController,
                mainViewModel = mainViewModel,
            )
        }
    }
}