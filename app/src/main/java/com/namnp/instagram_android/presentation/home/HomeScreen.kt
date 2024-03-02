package com.namnp.instagram_android.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.namnp.instagram_android.R
import com.namnp.instagram_android.domain.repository.userStories
import com.namnp.instagram_android.presentation.MainViewModel
import com.namnp.instagram_android.presentation.common.HorizontalDivider
import com.namnp.instagram_android.presentation.home.component.HomeScreenHeader
import com.namnp.instagram_android.presentation.home.component.NewFeedBody
import com.namnp.instagram_android.presentation.home.component.NewFeedComments
import com.namnp.instagram_android.presentation.home.component.NewFeedHeader
import com.namnp.instagram_android.presentation.home.component.Story
import com.namnp.instagram_android.presentation.navigation.Screen
import com.namnp.instagram_android.presentation.ui.theme.InstagramComposeAndroidTheme

@Composable
fun HomeScreen(
    navController: NavHostController? = null,
) {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HomeScreenHeader()
        HorizontalDivider(
            modifier = Modifier
                .padding(vertical = 8.dp),
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            items(userStories) { userStory ->
                Story(
                    userStory = userStory,
                    onViewStory = {
                        navController?.navigate(Screen.StoryScreen.route)
                    }
                )
            }
        }
        HorizontalDivider(
            modifier = Modifier
                .padding(top = 8.dp),
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
        ) {
            items(10) {
                NewFeed(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                )
            }
        }
    }
}

@Composable
fun NewFeed(
    modifier: Modifier = Modifier,
) {
    val images = remember {
        listOf(
            R.drawable.img_tokyo1,
            R.drawable.img_tokyo2,
            R.drawable.img_tokyo3,
        )
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        NewFeedHeader()
        NewFeedBody(images = images)
        NewFeedComments()
    }
}

@Preview(
    showBackground = true,
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun HomeScreenPreview() {
    InstagramComposeAndroidTheme {
        HomeScreen()
    }
}