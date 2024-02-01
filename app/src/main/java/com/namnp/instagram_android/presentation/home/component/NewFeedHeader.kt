package com.namnp.instagram_android.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.namnp.instagram_android.R
import com.namnp.instagram_android.presentation.ui.theme.colorPrimary
import com.namnp.instagram_android.presentation.ui.theme.textNormal_13
import com.namnp.instagram_android.presentation.ui.theme.textPrimary

@Composable
fun NewFeedHeader(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier
                .padding(10.dp)
                .size(32.dp),
            painter = painterResource(id = R.drawable.img_rounded_avatar),
            contentDescription = null,
        )
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "joshua_l",
                    style = textNormal_13.copy(
                        lineHeight = 18.sp,
                        fontWeight = FontWeight(600),
                    )
                )
                Image(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .size(10.dp),
                    painter = painterResource(id = R.drawable.ic_official),
                    contentDescription = null,
                )
            }
            Text(
                text = "Tokyo, Japan",
                style = TextStyle(
                    fontSize = 11.sp,
                    fontWeight = FontWeight(400),
                    color = MaterialTheme.colorScheme.textPrimary,
                    letterSpacing = 0.07.sp,
                )
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier
                .padding(end = 10.dp)
                .width(14.dp),
            painter = painterResource(id = R.drawable.ic_more),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.colorPrimary)
        )
    }
}