package com.namnp.instagram_android.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.R
import com.namnp.instagram_android.presentation.ui.theme.colorPrimary
import com.namnp.instagram_android.presentation.ui.theme.isLight

@Composable
fun HomeScreenHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier.width(64.dp),
        ) {
            Image(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(24.dp),
                painter = painterResource(id = R.drawable.ic_camera),
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.colorPrimary)
            )
        }
        Image(
            modifier = Modifier
                .width(120.dp)
                .aspectRatio(105f / 28f),
            painter = painterResource(id = R.drawable.ic_instagram_logo),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.colorPrimary)
        )
        Row {
            val iconId = if (MaterialTheme.colorScheme.isLight)
                R.drawable.ic_tv_dark else R.drawable.ic_tv_light
            Image(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(24.dp),
                painter = painterResource(id = iconId),
                contentDescription = null,
            )
            Image(
                modifier = Modifier
                    .size(24.dp),
                painter = painterResource(id = R.drawable.ic_send),
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.colorPrimary)
            )
        }
    }
}