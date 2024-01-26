package com.namnp.instagram_android.presentation.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.R
import com.namnp.instagram_android.presentation.home.component.HomeScreenHeader
import com.namnp.instagram_android.presentation.home.component.NewFeedBody
import com.namnp.instagram_android.presentation.home.component.NewFeedComments
import com.namnp.instagram_android.presentation.home.component.NewFeedHeader
import com.namnp.instagram_android.presentation.home.component.Story
import com.namnp.instagram_android.presentation.ui.theme.Blue200
import com.namnp.instagram_android.presentation.ui.theme.Grey200
import com.namnp.instagram_android.presentation.ui.theme.InstagramComposeAndroidTheme

@Composable
fun HomeScreen(
//    mainViewModel: MainViewModel = hiltViewModel(),
) {
//    val themeState by mainViewModel.themeState.collectAsState()
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HomeScreenHeader()
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            color = Grey200,
            thickness = 0.6.dp,
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            items(10) { index ->
                Story(index = index)
            }
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            color = Grey200,
            thickness = 0.6.dp,
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

        Switch(
//            checked = themeState.theme == Theme.Dark,
            checked = true,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Blue200,
            ),
            onCheckedChange = { _ ->
//                mainViewModel.toggleDarkMode()
            }
        )
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
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun HomeScreenPreview() {
    InstagramComposeAndroidTheme {
        HomeScreen()
    }
}