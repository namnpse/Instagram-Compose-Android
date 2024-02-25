package com.namnp.instagram_android.presentation.common.story_pager

import android.view.MotionEvent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInteropFilter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

const val THRESH_HOLD = 400L

@ExperimentalComposeUiApi
@OptIn(ExperimentalPagerApi::class)
@Composable
fun InstagramStoryImage(
    count: Int = 0,
    pagerState: PagerState,
    onTap: (pauseTimer: Boolean) -> Unit,
    onNext: (pauseTimer: Boolean) -> Unit,
    content: @Composable (Int) -> Unit,
    key: ((page: Int) -> Any)? = null,
) {

    var previousTime by remember {
        mutableLongStateOf(0L)
    }

    HorizontalPager(
        count = count,
        state = pagerState,
        key = key,
//        dragEnabled = false,
        modifier = Modifier
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        previousTime = System.currentTimeMillis()
                        onTap(true)
                    }

                    MotionEvent.ACTION_UP -> {
                        val currentTime = System.currentTimeMillis()
                        if (currentTime - previousTime > THRESH_HOLD)
                            onTap(false)
                        else onNext(false)
                    }

                    else -> {}
                }
                true
            }
    ) {
        content(it)
    }
}