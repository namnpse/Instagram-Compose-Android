package com.namnp.instagram_android.presentation.home.component

import androidx.compose.ui.tooling.preview.Preview
import com.namnp.instagram_android.R
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.domain.model.Post
import com.namnp.instagram_android.domain.model.PostUser
import com.namnp.instagram_android.domain.repository.names
import com.namnp.instagram_android.presentation.ui.MainEvent

enum class LikeAnimationState {
    Idle,
    Start,
    End
}

private const val springRatio = Spring.DampingRatioHighBouncy

@Composable
fun AnimLikeButton(
    modifier: Modifier = Modifier,
    post: Post,
    onEvent: ((MainEvent) -> Unit)?
) {

    var transitionState by remember {
        mutableStateOf(MutableTransitionState(LikeAnimationState.Idle))
    }

    var isLiked by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = modifier
            .clickable(
                indication = null, // disable click effect
                interactionSource = remember { MutableInteractionSource() }, // This is mandatory
                onClick = {
                    transitionState = MutableTransitionState(LikeAnimationState.Start)
                    onEvent?.invoke(MainEvent.OnToggleLikeButton(post))
                    isLiked = !isLiked
                }
            )
            .indication(
                indication = rememberRipple(bounded = false, radius = 24.dp),
                interactionSource = remember { MutableInteractionSource() }
            )
            .padding(vertical = 10.dp)
            .then(Modifier.size(30.dp)),
        contentAlignment = Alignment.Center
    ) {

        var likeIconRes by remember { mutableIntStateOf(R.drawable.ic_outlined_favorite) }
        val startColor = contentColorFor(MaterialTheme.colorScheme.background)
        val endColor = Color(0xFFDF0707)

        if (transitionState.currentState == LikeAnimationState.Start) {
            transitionState.targetState = LikeAnimationState.End
        }

        val transition = updateTransition(transitionState, label = "")

        val animatedColor by transition.animateColor(
            transitionSpec = {
                when {
                    LikeAnimationState.Idle isTransitioningTo LikeAnimationState.Start ->
                        spring(dampingRatio = springRatio)

                    LikeAnimationState.Start isTransitioningTo LikeAnimationState.End ->
                        tween(200)

                    else -> snap()
                }
            }, label = ""
        ) { state ->
            when (state) {
                LikeAnimationState.Idle -> if (isLiked) endColor else startColor
                else -> if (isLiked.not()) startColor else endColor
            }
        }

        val size by transition.animateDp(
            transitionSpec = {
                when {
                    LikeAnimationState.Idle isTransitioningTo LikeAnimationState.Start ->
                        spring(dampingRatio = springRatio)

                    LikeAnimationState.Start isTransitioningTo LikeAnimationState.End ->
                        tween(200)

                    else -> snap()
                }
            }, label = ""
        ) { state ->
            when (state) {
                LikeAnimationState.Idle -> 24.dp
                LikeAnimationState.Start -> 12.dp
                LikeAnimationState.End -> 24.dp
            }
        }

        likeIconRes = if (isLiked) {
            R.drawable.ic_filled_favorite
        } else {
            R.drawable.ic_outlined_favorite
        }

        Icon(
            ImageBitmap.imageResource(id = likeIconRes), tint = animatedColor,
            modifier = Modifier.size(size),
            contentDescription = ""
        )
    }
}

@Preview
@Composable
private fun LikeButtonPreview() {
    AnimLikeButton(
        post = Post(
            id = 1,
            image = "https://source.unsplash.com/random/400x300",
            user = PostUser(
                name = names.first(),
                username = names.last(),
                image = "https://randomuser.me/api/portraits/men/1.jpg"
            ),
            likesCount = 100,
            commentsCount = 20,
            timeStamp = System.currentTimeMillis() - (60000)
        ),
        onEvent = {},
    )
}