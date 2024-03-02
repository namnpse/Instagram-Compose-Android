package com.namnp.instagram_android.presentation.bottom_nav

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.namnp.instagram_android.jetinstagram.ui.BottomBarProfile
import com.namnp.instagram_android.jetinstagram.ui.components.icon
import com.namnp.instagram_android.presentation.common.NoRippleTheme
import com.namnp.instagram_android.presentation.navigation.Screen
import com.namnp.instagram_android.presentation.ui.theme.Grey200
import com.namnp.instagram_android.presentation.ui.theme.bottomBarIndicatorColor
import com.namnp.instagram_android.presentation.ui.theme.bottomBarSelectedIconColor
import com.namnp.instagram_android.presentation.ui.theme.bottomBarUnselectedIconColor

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    selectedItem: BottomNavItem,
    items: List<BottomNavItem>,
    navController: NavController,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry =
        navController.currentBackStackEntryAsState() // state, changes when navigate screens
    /*    NavigationRail {
            // for tablets, foldable devices, landscape mode
        }*/
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
                contentColor = contentColorFor(MaterialTheme.colorScheme.background),
                tonalElevation = 5.dp
            ) {
                items.forEach { item ->
//            val selected = item.route == backStackEntry.value?.destination?.route
                    val selected = selectedItem == item
                    val iconRes = if (selected) item.selectedIcon else item.icon
                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            if (item != selectedItem) {
                                onItemClick(item)
                            }
                        },
                        alwaysShowLabel = false,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.bottomBarSelectedIconColor,
                            unselectedIconColor = MaterialTheme.colorScheme.bottomBarUnselectedIconColor,
                            indicatorColor = color,
                        ),
                        icon = {
                            if (item.route == Screen.ProfileScreen.route) {
                                BottomBarProfile(selected)
                            } else {
                                Icon(
                                    ImageBitmap.imageResource(id = iconRes),
                                    modifier = Modifier.icon(),
                                    contentDescription = ""
                                )
                            }
                        },
                    )
                }
            }
        }
    }
}