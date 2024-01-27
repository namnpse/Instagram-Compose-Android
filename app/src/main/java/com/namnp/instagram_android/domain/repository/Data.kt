package com.namnp.instagram_android.domain.repository

import androidx.annotation.DrawableRes
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.R
import com.namnp.instagram_android.domain.model.Follower
import com.namnp.instagram_android.domain.model.SearchGallery
import com.namnp.instagram_android.domain.model.SearchSuggestion
import com.namnp.instagram_android.domain.model.User
import kotlin.random.Random

val userStories = listOf(
    User(
        name = "Your Story",
        avatar = R.drawable.img_avatar1,
        isMine = true,
    ),
    User(
        name = "craig_love",
        avatar = R.drawable.img_avatar2,
        isLive = true,
    ),
    User(
        name = "kieron_d",
        avatar = R.drawable.img_avatar3,
    ),
    User(
        name = "zackjohn",
        avatar = R.drawable.img_avatar4,
    ),
    User(
        name = "karennne",
        avatar = R.drawable.img_avatar5,
    ),
    User(
        name = "karennne",
        avatar = R.drawable.img_avatar6,
    ),
    User(
        name = "karennne",
        avatar = R.drawable.img_avatar7,
    ),
    User(
        name = "karennne",
        avatar = R.drawable.img_avatar8,
    ),
)

val searchSuggestions = listOf(
    SearchSuggestion(
        id = 1,
        title = "IGTV",
        icon = R.drawable.ic_seach_tv,
    ),
    SearchSuggestion(
        id = 2,
        title = "Shop",
        icon = R.drawable.ic_shop,
    ),
    SearchSuggestion(
        id = 3,
        title = "Trending",
    ),
    SearchSuggestion(
        id = 4,
        title = "Sport",
    ),
    SearchSuggestion(
        id = 5,
        title = "Style",
    ),
    SearchSuggestion(
        id = 6,
        title = "Auto",
    ),
)

val images = listOf(
    R.drawable.img_tokyo1,
    R.drawable.img_tokyo2,
    R.drawable.img_tokyo3,
)

val searchGallery = (0..40).map {
    SearchGallery(
        id = it,
        url = images[it % 3]
    )
}

val followers = listOf(
    Follower(
        id = 1,
        name = "martini_rond_ig",
        avatar = getRamdomImage(),
        isFollowing = false,
    ),
    Follower(
        id = 2,
        name = "maxjacobson_ig",
        avatar = getRamdomImage(),
        isFollowing = false,
    ),
    Follower(
        id = 3,
        name = "mis_potter_ig",
        avatar = getRamdomImage(),
        isFollowing = true,
    )
)

@DrawableRes
fun getRamdomImage(): Int {
    val index = Random.nextInt(8)
    return userStories[index].avatar
}

fun getRamdomUser(): User {
    val index = Random.nextInt(8)
    return userStories[index]
}