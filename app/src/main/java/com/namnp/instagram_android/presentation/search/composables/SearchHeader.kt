package com.namnp.instagram_android.presentation.search.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.R
import com.namnp.instagram_android.presentation.ui.theme.Grey600
import com.namnp.instagram_android.presentation.ui.theme.primarySearchColor
import com.namnp.instagram_android.presentation.ui.theme.textNormal16_24

@Composable
fun SearchHeader(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(Grey600)
                .padding(11.dp)
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null,
                colorFilter = ColorFilter.tint(
                    color = MaterialTheme.colorScheme.primarySearchColor,
                ),
            )
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = "Search",
                style = textNormal16_24.copy(
                    color = MaterialTheme.colorScheme.primarySearchColor,
                )
            )
        }
        Image(
            modifier = Modifier
                .padding(start = 10.dp, end = 2.dp)
                .size(20.dp),
            painter = painterResource(id = R.drawable.ic_scan),
            contentDescription = null,
            colorFilter = ColorFilter.tint(
                color = MaterialTheme.colorScheme.onBackground,
            ),
        )
    }
}