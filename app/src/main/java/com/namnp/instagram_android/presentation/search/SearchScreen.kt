package com.namnp.instagram_android.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.namnp.instagram_android.presentation.search.composables.SearchHeader
import com.namnp.instagram_android.presentation.search.composables.SearchSuggestionCompose
import com.namnp.instagram_android.presentation.search.composables.StaggeredGridSearchImage
import com.namnp.instagram_android.presentation.ui.theme.InstagramComposeAndroidTheme

@Composable
fun SearchScreen() {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchHeader()
        SearchSuggestionCompose()
        StaggeredGridSearchImage()
    }
}

@Preview(
    showBackground = true,
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun SearchScreenPreview() {
    InstagramComposeAndroidTheme {
        SearchScreen()
    }
}