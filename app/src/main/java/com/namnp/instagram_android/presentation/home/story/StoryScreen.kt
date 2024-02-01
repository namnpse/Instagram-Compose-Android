package com.namnp.instagram_android.presentation.home.story

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.namnp.instagram_android.domain.repository.images
import com.namnp.instagram_android.presentation.common.story_pager.InstagramStory
import com.namnp.instagram_android.presentation.ui.theme.InstagramComposeAndroidTheme

@OptIn(ExperimentalPagerApi::class)
@Composable
fun StoryScreen(
    navController: NavHostController? = null,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        InstagramStory(
            listImages = images,
            onComplete = {
                navController?.popBackStack()
            },
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = images[it]),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
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
        StoryScreen()
    }
}