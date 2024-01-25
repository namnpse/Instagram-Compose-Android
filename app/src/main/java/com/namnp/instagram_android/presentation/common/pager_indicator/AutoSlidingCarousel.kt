package com.namnp.instagram_android.presentation.common.pager_indicator

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.namnp.instagram_android.R
import kotlinx.coroutines.delay

const val AUTO_SLIDE_DURATION = 3000L

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AutoSlidingCarousel(
    modifier: Modifier = Modifier,
    autoSlideDuration: Long = AUTO_SLIDE_DURATION,
    pagerState: PagerState = remember { PagerState() },
    itemsCount: Int,
    itemContent: @Composable (index: Int) -> Unit,
    onPagerIndexChanged: ((page: Int) -> Unit)?,
) {
    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()
    var currentPage by remember {
        mutableIntStateOf(1)
    }

    LaunchedEffect(pagerState.currentPage) {
        delay(autoSlideDuration)
        val nextPage = (pagerState.currentPage + 1) % itemsCount
        currentPage = nextPage
        onPagerIndexChanged?.invoke(nextPage)
        pagerState.animateScrollToPage(nextPage)
    }
    LaunchedEffect(key1 = isDragged) {
        currentPage = if (isDragged) pagerState.currentPage else pagerState.targetPage
        onPagerIndexChanged?.invoke(currentPage)
    }

//    Box(
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        HorizontalPager(count = itemsCount, state = pagerState) { page ->
            itemContent(page)
        }
        Box(
            modifier = Modifier
                .padding(14.dp)
                .align(Alignment.CenterHorizontally),
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
                    contentDescription = "image description",
                )
                Image(
                    modifier = Modifier
                        .padding(horizontal = 17.dp)
                        .width(22.dp)
                        .height(23.dp),
                    painter = painterResource(id = R.drawable.ic_comment),
                    contentDescription = "image description",
                )
                Image(
                    modifier = Modifier
                        .width(23.dp)
                        .height(20.dp),
                    painter = painterResource(id = R.drawable.ic_send),
                    contentDescription = "image description",
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    modifier = Modifier
                        .width(21.dp)
                        .height(24.dp),
                    painter = painterResource(id = R.drawable.ic_save),
                    contentDescription = "image description",
                )
            }
            DotsIndicator(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                totalDots = itemsCount,
                selectedIndex = currentPage,
                dotSize = 8.dp
            )
        }
    }
}