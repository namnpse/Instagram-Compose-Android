package com.namnp.instagram_android.presentation.direct_messages

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.namnp.instagram_android.domain.repository.directMessages
import com.namnp.instagram_android.presentation.direct_messages.composables.DirectMessageCompose
import com.namnp.instagram_android.presentation.direct_messages.composables.MessageSearchBar
import com.namnp.instagram_android.presentation.direct_messages.composables.MessagesAppBar
import com.namnp.instagram_android.presentation.ui.theme.InstagramComposeAndroidTheme

@Composable
fun DirectMessagesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MessagesAppBar(
            title = "namnpse_jr"
        )
        MessageSearchBar()
        LazyColumn {
            items(directMessages) { message ->
                DirectMessageCompose(
                    directMessage = message
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun AllSearchPickScreenPreview() {
    InstagramComposeAndroidTheme {
        DirectMessagesScreen()
    }
}