package com.namnp.instagram_android.presentation.profile.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.presentation.common.GridUserGallery
import com.namnp.instagram_android.presentation.common.HorizontalDivider
import com.namnp.instagram_android.presentation.ui.theme.selectedTabBar
import com.namnp.instagram_android.presentation.ui.theme.textNormal16_24
import com.namnp.instagram_android.presentation.ui.theme.unselectedTabBar

@Composable
fun UserProfileTabBar() {
    var tabIndex by remember { mutableIntStateOf(0) }

    val tabs = listOf("Album", "Memories")

    Column(modifier = Modifier.fillMaxWidth()) {
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
                        .background(color = MaterialTheme.colorScheme.selectedTabBar)
                )
            },
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = {
                        Text(
                            text = title,
                            style = textNormal16_24.copy(
                                fontWeight = FontWeight(600),
                            )
                        )
                    },
                    selectedContentColor = MaterialTheme.colorScheme.selectedTabBar,
                    unselectedContentColor = MaterialTheme.colorScheme.unselectedTabBar,
                    selected = tabIndex == index,
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
        }
    }
}