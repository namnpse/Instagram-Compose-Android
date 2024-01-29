package com.namnp.instagram_android.presentation.favorite_screen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.namnp.instagram_android.R
import com.namnp.instagram_android.domain.repository.getRamdomImage
import com.namnp.instagram_android.presentation.common.HorizontalDivider
import com.namnp.instagram_android.presentation.ui.theme.textNormal15_20
import com.namnp.instagram_android.presentation.ui.theme.textNormal_13
import com.namnp.instagram_android.presentation.ui.theme.textSecondary
import com.namnp.instagram_android.utils.previewPlaceholder

@Composable
fun TodaySection(
    modifier: Modifier = Modifier
) {
    val annotatedStringContent = buildAnnotatedString {
        val boldTextStyle = SpanStyle(fontWeight = FontWeight.Bold)
        withStyle(style = boldTextStyle) {
            append("kiero_d, zackjohn")
        }
        append(" and")
        withStyle(style = boldTextStyle) {
            append("26 others")
        }
        append(" liked your photo.")
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.textSecondary
            )
        ) {
            append(" 3h")
        }
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        HorizontalDivider()
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 13.dp, horizontal = 16.dp),
            text = "Today",
            style = textNormal15_20.copy(
                fontWeight = FontWeight(600),
            )
        )
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
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
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
    }
}