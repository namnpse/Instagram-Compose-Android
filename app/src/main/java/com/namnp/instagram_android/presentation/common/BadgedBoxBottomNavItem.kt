package com.namnp.instagram_android.presentation.common

import androidx.annotation.DrawableRes
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import com.namnp.instagram_android.jetinstagram.ui.components.icon
import com.namnp.instagram_android.presentation.bottom_nav.BottomNavItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BadgedBoxBottomNavItem(
    modifier: Modifier = Modifier,
    item: BottomNavItem,
    isSelected: Boolean = false,
) {
    BadgedBox(
        modifier = modifier,
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
            ImageBitmap.imageResource(
                id = if (isSelected)
                    item.selectedIcon
                else item.icon
            ),
//            imageVector = item.icon,
            modifier = Modifier.icon(),
            contentDescription = item.title
        )
    }
}