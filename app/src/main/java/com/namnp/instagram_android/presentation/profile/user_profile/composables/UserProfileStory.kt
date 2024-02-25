package com.namnp.instagram_android.presentation.profile.user_profile.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.domain.repository.myStories
import com.namnp.instagram_android.presentation.ui.theme.profileBorder
import com.namnp.instagram_android.presentation.ui.theme.selectedTabBar
import com.namnp.instagram_android.presentation.ui.theme.textNormal_12
import com.namnp.instagram_android.presentation.ui.theme.textPrimary

@Composable
fun UserProfileStory(
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier
    ) {
        items(myStories) { story ->
            Column(
                modifier = Modifier
                    .padding(start = 12.dp, end = 6.dp, bottom = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                if (story.isMine) Icon(
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.profileBorder,
                            shape = CircleShape,
                        )
                        .clip(CircleShape)
                        .padding(20.dp),
                    imageVector = Icons.Filled.Add,
                    tint = MaterialTheme.colorScheme.selectedTabBar,
                    contentDescription = null,
                ) else Image(
                    modifier = Modifier
                        .clip(CircleShape)
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.profileBorder,
                            shape = CircleShape,
                        )
                        .padding(4.dp)
                        .clip(CircleShape)
                        .size(64.dp),
                    painter = painterResource(id = story.avatar),
                    contentDescription = null,
                )
                Text(
                    modifier = Modifier
                        .padding(top = 4.dp),
                    text = story.name,
                    style = textNormal_12
                        .copy(color = MaterialTheme.colorScheme.textPrimary)
                )
            }
        }
    }
}