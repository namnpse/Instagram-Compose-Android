package com.namnp.instagram_android.domain.repository

import androidx.annotation.DrawableRes
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.R
import com.namnp.instagram_android.domain.model.DirectMessage
import com.namnp.instagram_android.domain.model.Follower
import com.namnp.instagram_android.domain.model.SearchGallery
import com.namnp.instagram_android.domain.model.SearchSuggestion
import com.namnp.instagram_android.domain.model.Statistic
import com.namnp.instagram_android.domain.model.StoryStatus
import com.namnp.instagram_android.domain.model.User
import com.namnp.instagram_android.presentation.bottom_nav.BottomNavItem
import com.namnp.instagram_android.presentation.navigation.Screen
import kotlin.random.Random


val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route = Screen.HomeScreen.route,
        icon = R.drawable.ic_outlined_home,
        selectedIcon = R.drawable.ic_filled_home
    ),
    BottomNavItem(
        title = "Search",
        route = Screen.SearchScreen.route,
        icon = R.drawable.ic_outlined_search,
        selectedIcon = R.drawable.ic_filled_search
//                        showDot = true,
//                        badgeCount = 23
    ),
    BottomNavItem(
        title = "Add",
        route = Screen.AddScreen.route,
        icon = R.drawable.ic_outlined_add,
        selectedIcon = R.drawable.ic_outlined_add
//                        badgeCount = 214,
    ),
    BottomNavItem(
        title = "Favorite",
        route = Screen.FavoriteScreen.route,
        icon = R.drawable.ic_outlined_favorite,
        selectedIcon = R.drawable.ic_filled_favorite
//                        badgeCount = 23
    ),
    BottomNavItem(
        title = "Profile",
        route = Screen.ProfileScreen.route,
        icon = R.drawable.ic_outlined_add,
        selectedIcon = R.drawable.ic_outlined_add
    ),
)

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

val statistic = listOf(
    Statistic(
        type = "Posts",
        number = 34,
    ),
    Statistic(
        type = "Followers",
        number = 1234,
    ),
    Statistic(
        type = "Following",
        number = 121,
    ),
)

val myStories = listOf(
    User(
        name = "New",
        avatar = R.drawable.img_avatar1,
        isMine = true,
    ),
    User(
        name = "Memories",
        avatar = R.drawable.img_avatar2,
        isLive = true,
    ),
    User(
        name = "Family",
        avatar = R.drawable.img_avatar3,
        isLive = true,
    ),
    User(
        name = "Friends",
        avatar = R.drawable.img_avatar4,
    ),
    User(
        name = "Trip",
        avatar = R.drawable.img_avatar5,
    ),
    User(
        name = "Sport",
        avatar = R.drawable.img_avatar6,
    ),
)

val messages = listOf(
    "Have a nice day, bro!",
    "I heard this is a good movie, what do you think?",
    "See you on the next meeting!",
    "Sounds good \uD83D\uDE02\uD83D\uDE02\uD83D\uDE02",
    "The new design looks cool, by the way",
    "Thanks, bro",
    "Yep, I'm going travel to Tokyo",
    "Instagram is pretty good!"
)

val times = listOf(
    "now",
    "now",
    "15m",
    "20m",
    "2h",
    "4h",
    "5h",
    "1d"
)

val directMessages = (0..20).map {
    val index = Random.nextInt(8)
    DirectMessage(
        id = it,
        user = userStories[it % 7 + 1],
        lastMessage = messages[index],
        time = times[it % 8],
        isRead = index % 3 == 0,
        storyStatus = StoryStatus.entries[index % 3]
    )
}

val publicUserInfo = mapOf(
    "Name" to "Nguyen Bryan",
    "Username" to "namnpse_jr",
    "Website" to "https://namnpse.dev",
    "Bio" to "I'm an enthusiastic mobile developer who loves building great apps.",
)
val privateUserInfo = mapOf(
    "Email" to "namnpse@gmail.com",
    "Phone" to "+84372293847",
    "Gender" to "Male",
)

@DrawableRes
fun getRamdomImage(): Int {
    val index = Random.nextInt(8)
    return userStories[index].avatar
}

fun getRandomUser(): User {
    val index = Random.nextInt(userStories.size)
    return userStories[index]
}

val names = arrayOf(
    "storee",
    "nianyc",
    "opioke",
    "ashoke",
    "dark_emarlds",
    "bedtan",
    "shrish",
    "matdo",
    "phillsohn",
    "deitch"
)