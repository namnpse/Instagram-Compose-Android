package com.namnp.instagram_android.domain.model

data class Post(
    val id: Int,
    val image: String,
    val user: PostUser,
    val isLiked: Boolean = false,
    val likesCount: Int,
    val commentsCount: Int,
    val timeStamp: Long
)