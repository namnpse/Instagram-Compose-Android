package com.namnp.instagram_android.presentation.favorite_screen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.ColorFilter
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
import com.namnp.instagram_android.domain.repository.getRamdomImage
import com.namnp.instagram_android.presentation.ui.theme.Black100
import com.namnp.instagram_android.presentation.ui.theme.Blue200
import com.namnp.instagram_android.presentation.ui.theme.textNormal11
import com.namnp.instagram_android.presentation.ui.theme.textNormal_13
import com.namnp.instagram_android.presentation.ui.theme.textSecondary
import com.namnp.instagram_android.utils.previewPlaceholder

@Composable
fun MentionItem(
    modifier: Modifier = Modifier
) {
    val annotatedStringContent = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append("craig_love")
        }
        append(" mentioned you in a comment:")
        withStyle(style = SpanStyle(color = Blue200)) {
            append("@namnpse_jr")
        }
        append(" long time no see")
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
            Box {
                AsyncImage(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(32.dp),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(getRamdomImage())
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    placeholder = previewPlaceholder(debugPreview = R.drawable.img_avatar7)
                )
                AsyncImage(
                    modifier = Modifier
                        .padding(start = 12.dp, end = 8.dp, top = 12.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.background)
                        .padding(2.dp)
                        .clip(CircleShape)
                        .size(32.dp),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(getRamdomImage())
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    placeholder = previewPlaceholder(debugPreview = R.drawable.img_avatar7)
                )
            }
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
            AsyncImage(
                modifier = Modifier
                    .size(44.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(getRamdomImage())
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = previewPlaceholder(debugPreview = R.drawable.img_avatar6)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 6.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .padding(start = 72.dp, end = 10.dp)
                    .width(14.dp)
                    .height(12.dp)
                ,
                model = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.ic_like)
                    .build(),
                contentDescription = null,
                placeholder = previewPlaceholder(debugPreview = R.drawable.ic_like),
                colorFilter = ColorFilter.tint(Black100)
            )
            Text(
                text = "Reply",
                style = textNormal11.copy(
                    color = Black100,
                    fontWeight = FontWeight(600)
                )
            )
        }
    }
}