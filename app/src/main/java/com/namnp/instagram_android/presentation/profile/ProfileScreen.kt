package com.namnp.instagram_android.presentation.profile

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.R
import com.namnp.instagram_android.domain.repository.myStories
import com.namnp.instagram_android.presentation.common.GridUserGallery
import com.namnp.instagram_android.presentation.common.HorizontalDivider
import com.namnp.instagram_android.presentation.profile.composables.ProfileHeader
import com.namnp.instagram_android.presentation.profile.composables.ProfileInfo
import com.namnp.instagram_android.presentation.ui.theme.InstagramComposeAndroidTheme
import com.namnp.instagram_android.presentation.ui.theme.profileBorder
import com.namnp.instagram_android.presentation.ui.theme.selectedTabBar
import com.namnp.instagram_android.presentation.ui.theme.textNormal16_24
import com.namnp.instagram_android.presentation.ui.theme.textNormal_12
import com.namnp.instagram_android.presentation.ui.theme.textPrimary
import com.namnp.instagram_android.presentation.ui.theme.unselectedTabBar

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ProfileHeader()
        ProfileInfo()
        MyProfileStory()
        HorizontalDivider()
        UserProfileTabBar()
    }
}

@Composable
fun MyProfileStory(
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier
    ) {
        items(myStories) { story ->
            Column(
                modifier = Modifier
                    .padding(start = 12.dp, end = 6.dp, bottom = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                if (story.isMine) Icon(
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.profileBorder,
                            shape = CircleShape,
                        )
                        .clip(CircleShape)
                        .padding(20.dp),
                    imageVector = Icons.Filled.Add,
                    tint = MaterialTheme.colorScheme.selectedTabBar,
                    contentDescription = null,
                ) else Image(
                    modifier = Modifier
                        .clip(CircleShape)
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.profileBorder,
                            shape = CircleShape,
                        )
                        .padding(4.dp)
                        .clip(CircleShape)
                        .size(64.dp),
                    painter = painterResource(id = story.avatar),
                    contentDescription = null,
                )
                Text(
                    modifier = Modifier
                        .padding(top = 4.dp),
                    text = story.name,
                    style = textNormal_12
                        .copy(color = MaterialTheme.colorScheme.textPrimary)
                )
            }
        }
    }
}

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

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun AllSearchPickScreenPreview() {
    InstagramComposeAndroidTheme {
        ProfileScreen()
    }
}