package com.namnp.instagram_android.presentation.direct_messages.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.R
import com.namnp.instagram_android.presentation.ui.theme.Blue300
import com.namnp.instagram_android.presentation.ui.theme.backgroundSecondary
import com.namnp.instagram_android.presentation.ui.theme.textNormal_13

@Composable
fun DirectMessagesFooter(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(MaterialTheme.colorScheme.backgroundSecondary),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Image(
            modifier = Modifier
                .padding(end = 8.dp)
                .size(24.dp),
            painter = painterResource(id = R.drawable.ic_camera_blue),
            contentDescription = null,
        )
        Text(
            text = "Camera",
            style = textNormal_13.copy(
                color = Blue300,
            )
        )
    }
}