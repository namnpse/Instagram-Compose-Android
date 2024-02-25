package com.namnp.instagram_android.domain.model

data class Story(
    val image: String,
    val name: String,
    val isSeen: Boolean = false
)