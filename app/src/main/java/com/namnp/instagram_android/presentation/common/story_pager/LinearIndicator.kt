package com.namnp.instagram_android.presentation.common.story_pager

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

@Composable
fun LinearIndicator(
    modifier: Modifier,
    initialProgress: Float = 0.00f,
    startProgress: Boolean = false,
    indicatorBackgroundColor: Color,
    indicatorProgressColor: Color,
    slideDurationInSeconds: Long,
    onPauseTimer: Boolean = false,
    hideIndicators: Boolean = false,
    onAnimationEnd: () -> Unit
) {

    val delayInMillis = rememberSaveable {
        (slideDurationInSeconds * 1000) / 100
    }

    var progress by remember {
        mutableFloatStateOf(initialProgress)
    }

    val animatedProgress by animateFloatAsState(
        label = "animated_progress_value",
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec,
    )

    if (startProgress) {
        LaunchedEffect(key1 = onPauseTimer) {
            while (progress < 1f && isActive && onPauseTimer.not()) {
                progress += 0.01f
                delay(delayInMillis)
            }

            // If the timer is not paused and animation completes
            // then move to next page.
            if (onPauseTimer.not()) {
                delay(200)
                onAnimationEnd()
            }
        }
    }

    if (hideIndicators.not()) {
        LinearProgressIndicator(
//            backgroundColor = indicatorBackgroundColor,
            trackColor = indicatorBackgroundColor,
            color = indicatorProgressColor,
            modifier = modifier
                .padding(top = 12.dp, bottom = 12.dp)
                .clip(RoundedCornerShape(12.dp)),
            progress = animatedProgress
        )
    }
}