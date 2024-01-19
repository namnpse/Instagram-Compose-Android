package com.namnp.instagram_android.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.namnp.instagram_android.presentation.login.LoginScreen
import com.namnp.instagram_android.presentation.ui.theme.InstagramComposeAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramComposeAndroidTheme {
                LoginScreen()
            }
        }
    }
}