package com.namnp.instagram_android.presentation.favorite_screen.composable

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
import com.namnp.instagram_android.presentation.common.VerticalDivider
import com.namnp.instagram_android.presentation.ui.theme.textNormal15_20
import com.namnp.instagram_android.presentation.ui.theme.textNormal_13
import com.namnp.instagram_android.presentation.ui.theme.textSecondary
import com.namnp.instagram_android.utils.previewPlaceholder

@Composable
fun NewSection(
    modifier: Modifier = Modifier
) {
    val annotatedStringContent = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append("namnpse_jr")
        }
        append(" liked your photo.")
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.textSecondary
            )
        ) {
            append(" 1h")
        }
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        VerticalDivider()
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 13.dp, horizontal = 16.dp),
            text = "New",
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