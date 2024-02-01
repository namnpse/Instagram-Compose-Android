package com.namnp.instagram_android.presentation.profile.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.namnp.instagram_android.presentation.ui.theme.textNormal16_24
import com.namnp.instagram_android.presentation.ui.theme.textNormal_13
import com.namnp.instagram_android.presentation.ui.theme.textPrimary

@Composable
fun StatisticInfo(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = subtitle,
            style = textNormal16_24.copy(
                fontWeight = FontWeight(600),
                color = MaterialTheme.colorScheme.textPrimary,
            ),
        )
        Text(
            text = title,
            style = textNormal_13,
        )
    }
}