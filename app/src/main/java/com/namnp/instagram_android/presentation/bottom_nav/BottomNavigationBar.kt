package com.namnp.instagram_android.presentation.bottom_nav

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.namnp.instagram_android.presentation.MainViewModel
import com.namnp.instagram_android.presentation.add.AddScreen
import com.namnp.instagram_android.presentation.favorite_screen.FavoriteScreen
import com.namnp.instagram_android.presentation.home.HomeScreen
import com.namnp.instagram_android.presentation.navigation.Screen
import com.namnp.instagram_android.presentation.profile.ProfileScreen
import com.namnp.instagram_android.presentation.search.SearchScreen
import com.namnp.instagram_android.presentation.ui.theme.Grey200
import com.namnp.instagram_android.presentation.ui.theme.bottomBarIndicatorColor
import com.namnp.instagram_android.presentation.ui.theme.bottomBarSelectedIconColor
import com.namnp.instagram_android.presentation.ui.theme.bottomBarUnselectedIconColor
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp(
    mainViewModel: MainViewModel = hiltViewModel(),
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        title = "Home",
                        route = Screen.HomeScreen.route,
                        icon = Icons.Default.Home
                    ),
                    BottomNavItem(
                        title = "Search",
                        route = Screen.SearchScreen.route,
                        icon = Icons.Default.Search,
//                        showDot = true,
//                        badgeCount = 23
                    ),
                    BottomNavItem(
                        title = "Add",
                        route = Screen.AddScreen.route,
                        icon = Icons.Default.AddBox,
//                        badgeCount = 214,
                    ),
                    BottomNavItem(
                        title = "Favorite",
                        route = Screen.FavoriteScreen.route,
                        icon = Icons.Default.FavoriteBorder,
//                        badgeCount = 23
                    ),
                    BottomNavItem(
                        title = "Profile",
                        route = Screen.ProfileScreen.route,
                        icon = Icons.Default.AccountCircle,
                    ),
                ),
                navController = navController,
                onItemClick = { item ->
//                    navController.navigate(item.route)
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            Navigation(
                navController = navController,
                mainViewModel = mainViewModel,
            )
        }
    }
}

@Composable
fun Navigation(
    navController: NavHostController,
    mainViewModel: MainViewModel = hiltViewModel(),
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route,
    ) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(
//                navController = navController,
//                mainViewModel = mainViewModel,
            )
        }
        composable(route = Screen.SearchScreen.route) {
            SearchScreen(
//                navController = navController,
//                mainViewModel = mainViewModel,
            )
        }
        composable(route = Screen.AddScreen.route) {
            AddScreen(
//                navController = navController,
//                mainViewModel = mainViewModel,
            )
        }
        composable(route = Screen.FavoriteScreen.route) {
            FavoriteScreen(
//                navController = navController,
//                mainViewModel = mainViewModel,
            )
        }
        composable(route = Screen.ProfileScreen.route) {
            ProfileScreen(
//                navController = navController,
//                mainViewModel = mainViewModel,
            )
        }
    }
}

private object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(0.0f, 0.0f, 0.0f, 0.0f)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    initialIndex: Int = 0,
    items: List<BottomNavItem>,
    navController: NavController,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry =
        navController.currentBackStackEntryAsState() // state, changes when navigate screens
    /*    NavigationRail {
            // for tablets, foldable devices, landscape mode
        }*/
    var selectedItemIndex by rememberSaveable { // handle config changes
        mutableIntStateOf(initialIndex)
    }
    val color = MaterialTheme.colorScheme.bottomBarIndicatorColor.copy(alpha = 0.1f)
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        Column {
            Divider(color = Grey200.copy(alpha = 0.3f), thickness = 0.5.dp)
            NavigationBar(
                modifier = modifier
                    .height(60.dp)
//                    .background(color = color)
                ,
                containerColor = color,
                tonalElevation = 5.dp
            ) {
                items.forEachIndexed { index, item ->
//            val selected = item.route == backStackEntry.value?.destination?.route
                    val selected = selectedItemIndex == index
                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            selectedItemIndex = index
                            onItemClick(item)
                        },
                        alwaysShowLabel = false,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.bottomBarSelectedIconColor,
                            unselectedIconColor = MaterialTheme.colorScheme.bottomBarUnselectedIconColor,
                            indicatorColor = color,
                        ),
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (item.badgeCount > 0) {
                                        Badge {
                                            val displayBadgeCount =
                                                if (item.badgeCount > 9) "9+"
                                                else item.badgeCount.toString()
                                            Text(text = displayBadgeCount)
                                        }
                                    } else if (item.showDot) {
                                        Badge()
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.title
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}