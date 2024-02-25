package com.namnp.instagram_android.presentation.profile.edit_profile.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.presentation.common.HorizontalDivider
import com.namnp.instagram_android.presentation.ui.theme.textNormal15_20
import com.namnp.instagram_android.presentation.ui.theme.textNormal16_24
import com.namnp.instagram_android.presentation.ui.theme.textPrimary


@Composable
fun UserInfoItem(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    showDivider: Boolean = true,
) {
    Row(
        modifier = modifier,
    ) {
        Text(
            modifier = Modifier
                .weight((375 - 279) / 375f)
                .padding(start = 16.dp, top = 16.dp),
            text = title,
            style = textNormal15_20.copy(
                color = MaterialTheme.colorScheme.textPrimary,
            ),
        )
        Column(
            modifier = Modifier
                .weight(279 / 375f),
        ) {
            Text(
                modifier = Modifier
                    .padding(16.dp),
                text = value,
                style = textNormal16_24.copy(
                    color = MaterialTheme.colorScheme.textPrimary,
                    fontWeight = FontWeight(500),
                ),
            )
            if (showDivider) HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}