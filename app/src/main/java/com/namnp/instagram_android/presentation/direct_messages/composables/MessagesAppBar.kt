package com.namnp.instagram_android.presentation.direct_messages.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.R
import com.namnp.instagram_android.presentation.ui.theme.colorPrimary
import com.namnp.instagram_android.presentation.ui.theme.textNormal16_24
import com.namnp.instagram_android.presentation.ui.theme.textPrimary

@Composable
fun MessagesAppBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    onClick: (() -> Unit)? = null,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 14.dp, bottom = 12.dp)
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
            Row(
                modifier = Modifier
                    .align(Alignment.Center),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier,
                    text = title,
                    style = textNormal16_24.copy(
                        color = MaterialTheme.colorScheme.textPrimary,
                        fontWeight = FontWeight(600),
                    ),
                )
                Icon(
                    modifier = Modifier
                        .padding(start = 4.dp, top = 4.dp)
                        .width(10.dp)
                        .height(12.dp),
                    painter = painterResource(id = R.drawable.ic_dropdown),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.textPrimary,
                )
            }
        }
        Icon(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .clickable {

                },
            imageVector = Icons.Filled.Add,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.colorPrimary
        )
    }
}