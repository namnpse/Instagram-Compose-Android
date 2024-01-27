package com.namnp.instagram_android.domain.model

import androidx.annotation.DrawableRes

data class Follower(
    val id: Int,
    val name: String,
    @DrawableRes val avatar: Int,
    val isFollowing: Boolean = false,
)
