package com.namnp.instagram_android.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.namnp.instagram_android.presentation.navigation.InstagramNavGraph
import com.namnp.instagram_android.presentation.ui.theme.InstagramComposeAndroidTheme
import com.namnp.instagram_android.utils.Theme
import dagger.hilt.android.AndroidEntryPoint

//
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val themeState by mainViewModel.themeState.collectAsState()
            navController = rememberNavController()

            InstagramComposeAndroidTheme(
                darkTheme = themeState.theme == Theme.Dark,
            ) {
                InstagramNavGraph(
                    navController = navController,
                    mainViewModel = mainViewModel,
                )
            }
        }
    }
}