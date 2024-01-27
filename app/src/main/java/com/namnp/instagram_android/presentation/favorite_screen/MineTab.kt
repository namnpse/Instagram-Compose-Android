package com.namnp.instagram_android.presentation.favorite_screen


import android.content.res.Configuration
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.namnp.instagram_android.presentation.ui.theme.InstagramComposeAndroidTheme

@Preview
@Composable
fun MineTab() {
    Text(text = "")
}

@Preview(
    showBackground = true,
    // uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun MineTabPreview() {
    InstagramComposeAndroidTheme {
        MineTab()
    }
}