package com.namnp.instagram_android.presentation.favorite_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.namnp.instagram_android.presentation.favorite_screen.composable.TabBar
import com.namnp.instagram_android.presentation.ui.theme.InstagramComposeAndroidTheme

@Composable
fun FavoriteScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TabBar()
    }
}


@Preview(
    showBackground = true,
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun FavoriteScreenPreview() {
    InstagramComposeAndroidTheme {
        FavoriteScreen()
    }
}