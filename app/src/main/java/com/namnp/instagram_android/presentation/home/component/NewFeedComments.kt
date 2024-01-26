package com.namnp.instagram_android.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.R
import com.namnp.instagram_android.presentation.ui.theme.textNormal_13

@Composable
fun NewFeedComments(
    modifier: Modifier = Modifier,
) {
    val annotatedStringLikes = buildAnnotatedString {
        val boldTextStyle = SpanStyle(fontWeight = FontWeight.Bold)
        append("Liked by")
        withStyle(style = boldTextStyle) {
            append(" namnpse_jr")
        }
        append(" and")
        withStyle(style = boldTextStyle) {
            append(" 44,686 others")
        }
    }

    val annotatedStringContent = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append("joshua_l")
        }
        append(" The game in Japan was amazing and I want to share some photos")
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Row {
            Image(
                modifier = Modifier
                    .padding(end = 4.dp)
                    .clip(CircleShape)
                    .size(17.dp)
                ,
                painter = painterResource(id = R.drawable.img_rounded_avatar),
                contentDescription = null,
            )
            Text(
                text = annotatedStringLikes,
                style = textNormal_13
            )
        }
        Text(
            modifier = Modifier
                .padding(top = 4.dp),
            textAlign = TextAlign.Start,
            text = annotatedStringContent,
            style = textNormal_13
        )
    }
}