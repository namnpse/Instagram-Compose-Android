package com.namnp.instagram_android.presentation.profile.edit_profile

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.namnp.instagram_android.R
import com.namnp.instagram_android.domain.repository.privateUserInfo
import com.namnp.instagram_android.domain.repository.publicUserInfo
import com.namnp.instagram_android.presentation.common.HorizontalDivider
import com.namnp.instagram_android.presentation.profile.edit_profile.composables.EditProfileAppBar
import com.namnp.instagram_android.presentation.profile.edit_profile.composables.UserInfoItem
import com.namnp.instagram_android.presentation.ui.theme.Blue300
import com.namnp.instagram_android.presentation.ui.theme.InstagramComposeAndroidTheme
import com.namnp.instagram_android.presentation.ui.theme.profileBorder
import com.namnp.instagram_android.presentation.ui.theme.textNormal15_20
import com.namnp.instagram_android.presentation.ui.theme.textNormal_13
import com.namnp.instagram_android.presentation.ui.theme.textPrimary

@Composable
fun EditProfileScreen(
    navController: NavHostController? = null,
) {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        EditProfileAppBar(
            title = "Edit Profile",
            onClickDone = {
                navController?.popBackStack()
            },
            onClickCancel = {
                navController?.popBackStack()
            }
        )
        Image(
            modifier = Modifier
                .padding(top = 16.dp)
                .clip(CircleShape)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.profileBorder,
                    shape = CircleShape,
                )
                .clip(CircleShape)
                .size(95.dp),
            painter = painterResource(id = R.drawable.img_avatar1),
            contentDescription = null,
        )
        Text(
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                },
            text = "Change Profile Photo",
            style = textNormal_13.copy(
                color = Blue300,
                fontWeight = FontWeight(600),
            ),
        )
        HorizontalDivider()
        publicUserInfo.map {
            UserInfoItem(
                title = it.key,
                value = it.value,
                showDivider = it.key != "Bio",
            )
        }
        HorizontalDivider()
        Text(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(16.dp)
                .clickable {
                },
            text = "Switch to Professional Account",
            style = textNormal15_20.copy(
                color = Blue300,
            ),
        )
        Text(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = 16.dp, vertical = 8.dp)
            ,
            text = "Private Information",
            style = textNormal15_20.copy(
                color = MaterialTheme.colorScheme.textPrimary,
                fontWeight = FontWeight(600),
            ),
        )
        privateUserInfo.map {
            UserInfoItem(
                title = it.key,
                value = it.value,
            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun AllSearchPickScreenPreview() {
    InstagramComposeAndroidTheme {
        EditProfileScreen()
    }
}