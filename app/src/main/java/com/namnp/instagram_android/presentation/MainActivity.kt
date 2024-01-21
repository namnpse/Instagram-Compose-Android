package com.namnp.instagram_android.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.namnp.instagram_android.presentation.login.LoginScreen
import com.namnp.instagram_android.presentation.ui.theme.InstagramComposeAndroidTheme
import com.namnp.instagram_android.utils.Theme
import dagger.hilt.android.AndroidEntryPoint
//
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val themeState by mainViewModel.themeState.collectAsState()

            InstagramComposeAndroidTheme(
                darkTheme = themeState.theme == Theme.Dark,
            ) {
                LoginScreen()
            }
        }
    }
}