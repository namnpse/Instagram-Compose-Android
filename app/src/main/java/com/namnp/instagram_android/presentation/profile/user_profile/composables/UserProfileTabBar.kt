package com.namnp.instagram_android.presentation.profile.user_profile.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.R
import com.namnp.instagram_android.presentation.common.GridUserGallery
import com.namnp.instagram_android.presentation.common.HorizontalDivider
import com.namnp.instagram_android.presentation.ui.theme.selectedTabBar
import com.namnp.instagram_android.presentation.ui.theme.unselectedTabBar

@Composable
fun UserProfileTabBar(
    modifier: Modifier = Modifier,
    selectedTabColor: Color = MaterialTheme.colorScheme.selectedTabBar,
    unselectedTabColor: Color = MaterialTheme.colorScheme.unselectedTabBar,
) {
    var tabIndex by remember { mutableIntStateOf(0) }

    val tabs = listOf(
        R.drawable.ic_grid_tab,
        R.drawable.ic_video_tab,
        R.drawable.ic_tags_tab,
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        TabRow(
            selectedTabIndex = tabIndex,
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground,
            divider = {
                HorizontalDivider()
            },
            indicator = { tabPositions ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[tabIndex])
                        .height(2.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(color = selectedTabColor)
                )
            },
        ) {
            tabs.forEachIndexed { index, icon ->
                val isSelected = tabIndex == index
                val iconSize = if(index == 0) 28.dp else 24.dp
                Tab(
                    text = {
                        Image(
                            modifier = Modifier.size(iconSize),
                            painter = painterResource(id = icon),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(
                                if (isSelected) selectedTabColor
                                else unselectedTabColor
                            ),
                            contentScale = ContentScale.Crop,
                        )
                    },
                    selectedContentColor = selectedTabColor,
                    unselectedContentColor = unselectedTabColor,
                    selected = isSelected,
                    onClick = {
                        if (tabIndex != index) {
                            tabIndex = index
                        }
                    },
                )
            }
        }
        when (tabIndex) {
            0 -> GridUserGallery()
            1 -> GridUserGallery()
            2 -> GridUserGallery()
        }
    }
}