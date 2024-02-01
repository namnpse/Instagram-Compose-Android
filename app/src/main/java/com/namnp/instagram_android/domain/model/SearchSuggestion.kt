package com.namnp.instagram_android.domain.model

import androidx.annotation.DrawableRes

data class SearchSuggestion(
    val id: Int,
    val title: String,
    @DrawableRes val icon: Int? = null,
)