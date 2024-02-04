package com.namnp.instagram_android.presentation.profile.edit_profile.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.presentation.ui.theme.Blue300
import com.namnp.instagram_android.presentation.ui.theme.textNormal16_24
import com.namnp.instagram_android.presentation.ui.theme.textPrimary

@Composable
fun EditProfileAppBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    onClickCancel: (() -> Unit)? = null,
    onClickDone: (() -> Unit)? = null,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 14.dp, bottom = 12.dp)
    ) {
        Text(
            modifier = Modifier
                .clickable {
                    onClickCancel?.invoke()
                },
            text = "Cancel",
            style = textNormal16_24.copy(
                color = MaterialTheme.colorScheme.textPrimary,
            ),
        )
        Text(
            modifier = Modifier
                .align(Alignment.Center),
            text = title ?: "",
            style = textNormal16_24.copy(
                color = MaterialTheme.colorScheme.textPrimary,
                fontWeight = FontWeight(600),
            ),
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .clickable {
                    onClickDone?.invoke()
                },
            text = "Done",
            style = textNormal16_24.copy(
                color = Blue300,
                fontWeight = FontWeight(600),
            ),
        )
    }
}