package com.namnp.instagram_android.domain.model

import androidx.annotation.DrawableRes

data class User(
    val name: String,
    @DrawableRes val avatar: Int,
    val isLive: Boolean = false,
    val isMine: Boolean = false,
)
