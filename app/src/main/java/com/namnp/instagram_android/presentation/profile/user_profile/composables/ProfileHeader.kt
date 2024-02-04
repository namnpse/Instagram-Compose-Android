package com.namnp.instagram_android.presentation.profile.user_profile.composables

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.R
import com.namnp.instagram_android.presentation.ui.theme.InstagramComposeAndroidTheme
import com.namnp.instagram_android.presentation.ui.theme.textNormal16_24
import com.namnp.instagram_android.presentation.ui.theme.textPrimary

@Composable
fun ProfileHeader() {
    Box(
        modifier = Modifier
            .padding(vertical = 12.dp, horizontal = 18.dp)
            .fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                modifier = Modifier
                    .width(9.dp)
                    .height(12.dp),
                painter = painterResource(id = R.drawable.ic_lock),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.textPrimary,
            )
            Text(
                modifier = Modifier.padding(horizontal = 6.dp),
                text = "namnpse_jr",
                style = textNormal16_24.copy(
                    fontWeight = FontWeight(600),
                    color = MaterialTheme.colorScheme.textPrimary,
                ),
            )
            Icon(
                modifier = Modifier
                    .width(10.dp)
                    .height(12.dp)
                    .padding(top = 4.dp),
                painter = painterResource(id = R.drawable.ic_dropdown),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.textPrimary,
            )
        }
        Icon(
            modifier = Modifier
                .width(21.dp)
                .height(18.dp)
                .align(Alignment.CenterEnd),
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.textPrimary,
        )
    }
}

@Preview(
    showBackground = true,
    // uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun ProfileHeaderPreview() {
    InstagramComposeAndroidTheme {
        ProfileHeader()
    }
}