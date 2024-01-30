package com.namnp.instagram_android.presentation.direct_messages.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.R
import com.namnp.instagram_android.domain.model.DirectMessage
import com.namnp.instagram_android.domain.model.StoryStatus
import com.namnp.instagram_android.presentation.ui.theme.profileBorder
import com.namnp.instagram_android.presentation.ui.theme.textNormal_13
import com.namnp.instagram_android.presentation.ui.theme.textPrimary
import com.namnp.instagram_android.presentation.ui.theme.textSecondary

@Composable
fun DirectMessageCompose(
    modifier: Modifier = Modifier,
    directMessage: DirectMessage,
) {
    val isRead = directMessage.isRead
    Row(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .padding(top = 8.dp, bottom = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val avatarModifier = getAvatarModifier(directMessage.storyStatus)
        Box(
            modifier = avatarModifier
                .padding(2.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = directMessage.user.avatar),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(51.dp)
                    .clip(CircleShape)
                    .border(
                        0.1.dp,
                        MaterialTheme.colorScheme.onBackground,
                        CircleShape
                    ),
            )

        }
        Column(
            modifier = Modifier
                .padding(start = 12.dp)
                .weight(1f),
        ) {
            Text(
                text = directMessage.user.name,
                style = textNormal_13.copy(
                    color = MaterialTheme.colorScheme.textPrimary,
                    fontWeight = if (isRead) FontWeight(600) else FontWeight.Normal,
                )
            )
            Text(
                text = directMessage.lastMessage,
                style = textNormal_13.copy(
                    color = if (isRead)
                        MaterialTheme.colorScheme.textPrimary
                    else MaterialTheme.colorScheme.textSecondary,
                    fontWeight = if (isRead) FontWeight(600) else FontWeight.Normal,
                ),
                textAlign = TextAlign.Left,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
        Text(
            modifier = Modifier
                .padding(start = 8.dp, end = 22.dp)
                .width(40.dp),
            text = "· ${directMessage.time}",
            style = textNormal_13.copy(
                color = if (isRead)
                    MaterialTheme.colorScheme.textPrimary
                else MaterialTheme.colorScheme.textSecondary,
                fontWeight = if (isRead) FontWeight(600) else FontWeight.Normal,
            ),
        )
        Image(
            modifier = Modifier
                .size(24.dp),
            painter = painterResource(id = R.drawable.ic_camera),
            contentDescription = null,
            colorFilter = ColorFilter.tint(
                color = MaterialTheme.colorScheme.textSecondary,
            )
        )
    }
}

@Composable
private fun getAvatarModifier(storyStatus: StoryStatus): Modifier {
    val modifier = Modifier
        .size(60.dp)
        .clip(CircleShape)

    return when (storyStatus) {
        StoryStatus.SEEN -> modifier.background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFFD91A46),
                    Color(0xFFA60F93),
                    Color(0xFFFBAA47),
                )
            )
        )
        StoryStatus.NOT_SEEN -> modifier.background(MaterialTheme.colorScheme.profileBorder)
        else -> modifier
    }
}