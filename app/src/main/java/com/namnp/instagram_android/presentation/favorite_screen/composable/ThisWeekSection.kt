package com.namnp.instagram_android.presentation.favorite_screen.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.domain.repository.followers
import com.namnp.instagram_android.presentation.common.VerticalDivider
import com.namnp.instagram_android.presentation.ui.theme.textNormal15_20

@Composable
fun ThisWeekSection(
    modifier: Modifier = Modifier
) {
    VerticalDivider()
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 13.dp, horizontal = 16.dp),
        text = "This week",
        style = textNormal15_20.copy(
            fontWeight = FontWeight(600),
        )
    )
    MentionItem()
    followers.map { follower ->
        StartFollowingItem(
            follower = follower,
        )
    }
}