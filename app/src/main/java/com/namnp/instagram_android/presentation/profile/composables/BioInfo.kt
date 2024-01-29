package com.namnp.instagram_android.presentation.profile.composables

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import com.namnp.instagram_android.presentation.ui.theme.Blue200
import com.namnp.instagram_android.presentation.ui.theme.textNormal_12
import com.namnp.instagram_android.presentation.ui.theme.textPrimary

@Composable
fun BioInfo() {
    val bioAnnotatedString = buildAnnotatedString {
        append("Digital goodies designer")
        withStyle(style = SpanStyle(color = Blue200)) {
            append(" @pixsellz")
//            append(" @pixsellz\n")
        }
//        append("Everything is designed.")
    }
    Text(
        text = "Nam Phuong Nguyen",
        style = textNormal_12
            .copy(
                fontWeight = FontWeight(600),
                color = MaterialTheme.colorScheme.textPrimary,
            )
    )
    Text(
        text = bioAnnotatedString,
        style = textNormal_12
            .copy(
                color = MaterialTheme.colorScheme.textPrimary,
            ),
        textAlign = TextAlign.Start,
    )
    Text(
        text = "Everything is designed.",
        style = textNormal_12
            .copy(
                color = MaterialTheme.colorScheme.textPrimary,
            ),
        textAlign = TextAlign.Start,
    )
}