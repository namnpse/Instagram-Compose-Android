package com.namnp.instagram_android.presentation.favorite_screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.presentation.favorite_screen.composable.NewSection
import com.namnp.instagram_android.presentation.favorite_screen.composable.ThisMonthSection
import com.namnp.instagram_android.presentation.favorite_screen.composable.ThisWeekSection
import com.namnp.instagram_android.presentation.favorite_screen.composable.TodaySection
import com.namnp.instagram_android.presentation.ui.theme.InstagramComposeAndroidTheme
import com.namnp.instagram_android.presentation.ui.theme.textNormal15_20

@Composable
fun FollowingTab(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp, horizontal = 16.dp),
            text = "Follow requests",
            style = textNormal15_20
        )
        NewSection()
        TodaySection()
        ThisWeekSection()
        ThisMonthSection()
    }
}

@Preview(
    showBackground = true,
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun FollowingTabPreview() {
    InstagramComposeAndroidTheme {
        FollowingTab()
    }
}