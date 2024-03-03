package com.namnp.instagram_android.presentation.bottom_nav

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.namnp.instagram_android.jetinstagram.model.currentUser
import com.namnp.instagram_android.jetinstagram.ui.components.icon

@Composable
fun BottomNavItemProfile(isSelected: Boolean) {
    val shape = CircleShape

    val borderModifier = if (isSelected) {
        Modifier
            .border(
                color = Color.LightGray,
                width = 1.dp,
                shape = shape
            )
    } else Modifier

    val padding = if (isSelected) 3.dp else 0.dp

    Box(
        modifier = borderModifier
    ) {
        Box(
            modifier = Modifier
                .icon()
                .padding(padding)
                .background(color = Color.LightGray, shape = shape)
                .clip(shape)
        ) {
            Image(
                painter = rememberAsyncImagePainter(currentUser.image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}