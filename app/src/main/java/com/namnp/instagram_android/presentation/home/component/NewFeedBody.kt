package com.namnp.instagram_android.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.namnp.instagram_android.presentation.common.pager_indicator.AutoSlidingCarousel
import com.namnp.instagram_android.presentation.ui.theme.Black300
import com.namnp.instagram_android.presentation.ui.theme.White400
import com.namnp.instagram_android.presentation.ui.theme.textNormal_12

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NewFeedBody(
    modifier: Modifier = Modifier,
    images: List<Int>,
) {
    var currentPage by remember {
        mutableIntStateOf(1)
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        AutoSlidingCarousel(
            itemsCount = images.size,
            itemContent = { index ->
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    painter = painterResource(id = images[index]),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
                /*AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(images[index])
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(200.dp)
                )*/
            },
            onPagerIndexChanged = { page ->
                currentPage = page + 1
            },
        )
        if (images.isNotEmpty())
            Text(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(14.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Black300)
                    .padding(horizontal = 7.dp, vertical = 5.dp),
                text = "$currentPage/${images.size}",
                style = textNormal_12.copy(
                    color = White400,
                )
            )
    }
}