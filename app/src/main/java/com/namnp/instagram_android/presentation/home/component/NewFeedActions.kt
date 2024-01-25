package com.namnp.instagram_android.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.R
import com.namnp.instagram_android.presentation.common.pager_indicator.DotsIndicator
import com.namnp.instagram_android.presentation.ui.theme.colorPrimary
import com.namnp.instagram_android.presentation.ui.theme.unselectedDotIndicatorColor

@Composable
fun NewFeedActions(
    itemsCount: Int,
    currentPage: Int,
) {
    Box(
        modifier = Modifier
            .padding(14.dp),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier
                    .width(24.dp)
                    .height(21.dp),
                painter = painterResource(id = R.drawable.ic_like),
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.colorPrimary)
            )
            Image(
                modifier = Modifier
                    .padding(horizontal = 17.dp)
                    .width(22.dp)
                    .height(23.dp),
                painter = painterResource(id = R.drawable.ic_comment),
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.colorPrimary)
            )
            Image(
                modifier = Modifier
                    .width(23.dp)
                    .height(20.dp),
                painter = painterResource(id = R.drawable.ic_send),
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.colorPrimary)
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier
                    .width(21.dp)
                    .height(24.dp),
                painter = painterResource(id = R.drawable.ic_save),
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.colorPrimary)
            )
        }
        DotsIndicator(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
            totalDots = itemsCount,
            selectedIndex = currentPage,
            dotSize = 8.dp,
            unSelectedColor = MaterialTheme.colorScheme.unselectedDotIndicatorColor,
        )
    }
}