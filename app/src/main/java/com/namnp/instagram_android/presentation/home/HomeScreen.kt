package com.namnp.instagram_android.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.namnp.instagram_android.presentation.MainViewModel
import com.namnp.instagram_android.presentation.ui.theme.Blue200
import com.namnp.instagram_android.utils.Theme

@Composable
fun HomeScreen(
    mainViewModel: MainViewModel = hiltViewModel(),
) {
    val themeState by mainViewModel.themeState.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home")
        Switch(
            checked = themeState.theme == Theme.Dark,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Blue200,
            ),
            onCheckedChange = { _ ->
                mainViewModel.toggleDarkMode()
            }
        )
    }
}