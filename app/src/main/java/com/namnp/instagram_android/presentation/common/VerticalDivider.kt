package com.namnp.instagram_android.presentation.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.presentation.ui.theme.*

@Composable
fun VerticalDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.0.dp,
    color: Color = LightGrey,
) {
    Divider(
        modifier = modifier
            .fillMaxWidth(),
        color = color,
        thickness = thickness,
    )
}