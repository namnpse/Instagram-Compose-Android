package com.namnp.instagram_android.presentation.favorite_screen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.namnp.instagram_android.R
import com.namnp.instagram_android.domain.model.Follower
import com.namnp.instagram_android.domain.repository.getRamdomImage
import com.namnp.instagram_android.presentation.ui.theme.Blue200
import com.namnp.instagram_android.presentation.ui.theme.White400
import com.namnp.instagram_android.presentation.ui.theme.borderColor
import com.namnp.instagram_android.presentation.ui.theme.text600_14
import com.namnp.instagram_android.presentation.ui.theme.textNormal_13
import com.namnp.instagram_android.presentation.ui.theme.textPrimary
import com.namnp.instagram_android.presentation.ui.theme.textSecondary
import com.namnp.instagram_android.utils.previewPlaceholder

@Composable
fun StartFollowingItem(
    modifier: Modifier = Modifier,
    follower: Follower,
) {
    val annotatedStringContent = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append(follower.name)
        }
        append(" started following you.")
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.textSecondary
            )
        ) {
            append(" \uD83D\uDCAB 4d")
        }
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .clip(CircleShape)
                    .size(44.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(getRamdomImage())
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = previewPlaceholder(debugPreview = R.drawable.img_avatar7)
            )
            Text(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .weight(1f),
                text = annotatedStringContent,
                style = textNormal_13,
                textAlign = TextAlign.Start,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
            if (follower.isFollowing) Text(
                modifier = Modifier
                    .width(90.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Blue200)
                    .padding(vertical = 6.dp),
                text = "Follow",
                style = text600_14.copy(
                    color = White400,
                )
            ) else Text(
                modifier = Modifier
                    .width(90.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(MaterialTheme.colorScheme.borderColor)
                    .padding(1.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(MaterialTheme.colorScheme.background)
                    .padding(vertical = 6.dp),
                text = "Message",
                style = text600_14.copy(
                    color = MaterialTheme.colorScheme.textPrimary,
                )
            )
        }
    }
}