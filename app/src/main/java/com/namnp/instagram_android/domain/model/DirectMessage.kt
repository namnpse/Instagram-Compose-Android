package com.namnp.instagram_android.domain.model

data class DirectMessage(
    val id: Int,
    val user: User,
    val lastMessage: String,
    val time: String,
    val isRead: Boolean = false,
    val storyStatus: StoryStatus = StoryStatus.NO_STORY,
)

enum class StoryStatus {
    NO_STORY,
    SEEN,
    NOT_SEEN
}