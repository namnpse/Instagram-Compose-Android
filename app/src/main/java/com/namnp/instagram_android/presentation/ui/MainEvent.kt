package com.namnp.instagram_android.presentation.ui

sealed class MainEvent {
    data object OnToggleDarkTheme : MainEvent()
}