package com.namnp.instagram_android.presentation.profile.user_profile.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.R
import com.namnp.instagram_android.domain.repository.statistic
import com.namnp.instagram_android.presentation.ui.theme.borderColor
import com.namnp.instagram_android.presentation.ui.theme.profileBorder
import com.namnp.instagram_android.presentation.ui.theme.text600_14
import com.namnp.instagram_android.presentation.ui.theme.textPrimary

@Composable
fun ProfileInfo(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(horizontal = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp, bottom = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier
                    .clip(CircleShape)
                    .border(
                        width = 1.5.dp,
                        color = MaterialTheme.colorScheme.profileBorder,
                        shape = CircleShape,
                    )
                    .padding(5.dp)
                    .clip(CircleShape)
                    .size(96.dp),
                painter = painterResource(id = R.drawable.img_avatar1),
                contentDescription = null,
            )
            statistic.map {
                StatisticInfo(
                    title = it.type,
                    subtitle = it.number.toString(),
                )
            }
        }
        BioInfo()
        Text(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(6.dp))
                .background(MaterialTheme.colorScheme.borderColor)
                .padding(1.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(MaterialTheme.colorScheme.background)
                .padding(vertical = 6.dp),
            text = "Edit Profile",
            style = text600_14.copy(
                color = MaterialTheme.colorScheme.textPrimary,
            )
        )
    }
}