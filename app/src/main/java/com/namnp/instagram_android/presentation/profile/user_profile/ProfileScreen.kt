package com.namnp.instagram_android.presentation.profile.user_profile

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.namnp.instagram_android.presentation.common.HorizontalDivider
import com.namnp.instagram_android.presentation.profile.user_profile.composables.ProfileHeader
import com.namnp.instagram_android.presentation.profile.user_profile.composables.ProfileInfo
import com.namnp.instagram_android.presentation.profile.user_profile.composables.UserProfileStory
import com.namnp.instagram_android.presentation.profile.user_profile.composables.UserProfileTabBar
import com.namnp.instagram_android.presentation.ui.theme.InstagramComposeAndroidTheme

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
        UserProfileStory()
        HorizontalDivider()
        UserProfileTabBar()
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