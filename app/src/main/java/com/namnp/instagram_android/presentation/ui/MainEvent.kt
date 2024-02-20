package com.namnp.instagram_android.presentation.ui

import com.namnp.instagram_android.domain.model.Post

sealed class MainEvent {
    data object OnToggleDarkTheme : MainEvent()
    data class OnToggleLikeButton(val post: Post) : MainEvent()
}