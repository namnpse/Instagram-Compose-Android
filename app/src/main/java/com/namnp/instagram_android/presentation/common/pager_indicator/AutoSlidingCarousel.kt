package com.namnp.instagram_android.presentation.common.pager_indicator

import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.namnp.instagram_android.presentation.home.component.NewFeedActions
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

    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        HorizontalPager(count = itemsCount, state = pagerState) { page ->
            itemContent(page)
        }
        NewFeedActions(
            itemsCount = itemsCount,
            currentPage = currentPage,
        )
    }
}