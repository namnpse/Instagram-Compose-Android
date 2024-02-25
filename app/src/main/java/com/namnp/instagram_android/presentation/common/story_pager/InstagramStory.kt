package com.namnp.instagram_android.presentation.common.story_pager

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class, ExperimentalComposeUiApi::class)
@Composable
fun InstagramStory(
    indicatorModifier: Modifier = Modifier
        .padding(top = 12.dp, bottom = 12.dp)
        .clip(RoundedCornerShape(12.dp)),
    listImages: List<Int>,
    pagerState: PagerState = remember { PagerState() },
    spaceBetweenIndicator: Dp = 2.dp,
    indicatorBackgroundColor: Color = Color.LightGray,
    indicatorProgressColor: Color = Color.White,
    indicatorBackgroundGradientColors: List<Color> = emptyList(),
    slideDurationInSeconds: Long = 5,
    touchToPause: Boolean = true,
    hideIndicators: Boolean = false,
    onEveryStoryChange: ((Int) -> Unit)? = null,
    onComplete: () -> Unit,
    content: @Composable (Int) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()

    var pauseTimer by remember {
        mutableStateOf(false)
    }

    var isCancelCurrentStory by remember {
        mutableStateOf(false)
    }

    var numberOfPages by remember {
        mutableIntStateOf(listImages.size)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        //Full screen content behind the indicator
        InstagramStoryImage(
            count = numberOfPages,
            pagerState = pagerState,
            onTap = {
                if (touchToPause)
                    pauseTimer = it
            },
            onNext = {
                if (pagerState.currentPage == numberOfPages - 1) {
                    onComplete()
                } else {
                    coroutineScope.launch {
                        pagerState.scrollToPage(pagerState.currentPage + 1)
                    }
                    if (touchToPause)
                        pauseTimer = it
                }
                isCancelCurrentStory = true
            },
            content = content,
        )

        //Indicator based on the number of items
        val modifier =
            if (hideIndicators) {
                Modifier.fillMaxWidth()
            } else {
                Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            if (indicatorBackgroundGradientColors.isEmpty()) listOf(
                                Color.Black,
                                Color.Transparent
                            ) else indicatorBackgroundGradientColors
                        )
                    )
            }

        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.padding(spaceBetweenIndicator))

            ListOfIndicators(
                indicatorModifier,
                initialIndex = pagerState.currentPage,
                isCancelCurrentStory = isCancelCurrentStory,
                numberOfPages,
                indicatorBackgroundColor,
                indicatorProgressColor,
                slideDurationInSeconds,
                pauseTimer,
                hideIndicators,
                coroutineScope,
                pagerState,
                spaceBetweenIndicator,
                onEveryStoryChange = onEveryStoryChange,
                onComplete = onComplete,
            )
        }
    }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun RowScope.ListOfIndicators(
    indicatorModifier: Modifier,
    initialIndex: Int = 0,
    isCancelCurrentStory: Boolean = false,
    numberOfPages: Int,
    indicatorBackgroundColor: Color,
    indicatorProgressColor: Color,
    slideDurationInSeconds: Long,
    pauseTimer: Boolean,
    hideIndicators: Boolean,
    coroutineScope: CoroutineScope,
    pagerState: PagerState,
    spaceBetweenIndicator: Dp,
    onEveryStoryChange: ((Int) -> Unit)? = null,
    onComplete: () -> Unit,
) {
    println("initialIndex $initialIndex")
    var currentPage by remember {
        mutableIntStateOf(initialIndex)
    }

    for (index in 0 until numberOfPages) {
        LinearIndicator(
            modifier = indicatorModifier.weight(1f),
            initialProgress = if(isCancelCurrentStory) 1f else 0.00f,
            index == currentPage,
            indicatorBackgroundColor,
            indicatorProgressColor,
            slideDurationInSeconds,
            pauseTimer,
            hideIndicators
        ) {
            coroutineScope.launch {

                currentPage++

                if (currentPage < numberOfPages) {
                    onEveryStoryChange?.invoke(currentPage)
                    pagerState.animateScrollToPage(currentPage)
                }

                if (currentPage == numberOfPages) {
                    onComplete()
                }
            }
        }

        Spacer(modifier = Modifier.padding(spaceBetweenIndicator))
    }
}