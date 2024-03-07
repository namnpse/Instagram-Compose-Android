package com.namnp.instagram_android.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntSize
import coil.compose.rememberAsyncImagePainter
import com.namnp.instagram_android.R

@Composable
fun ZoomImage(
    modifier: Modifier = Modifier,
) {
    var zoom by remember { mutableStateOf(false) }
    var offset by remember { mutableStateOf(Offset.Zero) }

    Image(painter = rememberAsyncImagePainter(model = R.drawable.img_tokyo1),
        contentDescription = null,
        modifier = modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onDoubleTap = { tapOffset ->
                        offset = if (zoom) Offset.Zero else calculateOffset(tapOffset, size)
                        zoom = !zoom
                    }
                ) {

                }
            }
            .graphicsLayer {

            }
    )
}

fun calculateOffset(tapOffset: Offset, size: IntSize): Offset {
    return Offset.Unspecified
}