package com.namnp.instagram_android.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.presentation.ui.theme.colorPrimary
import com.namnp.instagram_android.presentation.ui.theme.textNormal16_24
import com.namnp.instagram_android.presentation.ui.theme.textPrimary

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    onClick: (() -> Unit)? = null,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 12.dp)
    ) {
        Icon(
            modifier = Modifier
                .clickable {
                    onClick?.invoke()
                },
            imageVector = Icons.Filled.ArrowBackIos,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.colorPrimary
        )
        title?.let {
            Text(
                modifier = Modifier
                    .align(Alignment.Center),
                text = title,
                style = textNormal16_24.copy(
                    color = MaterialTheme.colorScheme.textPrimary,
                    fontWeight = FontWeight(600),
                ),
            )
        }

    }
}