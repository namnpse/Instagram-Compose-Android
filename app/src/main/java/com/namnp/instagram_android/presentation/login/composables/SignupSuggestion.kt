package com.namnp.instagram_android.presentation.login.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.R
import com.namnp.instagram_android.presentation.ui.theme.Black400
import com.namnp.instagram_android.presentation.ui.theme.Blue200
import com.namnp.instagram_android.presentation.ui.theme.textNormal_12
import com.namnp.instagram_android.presentation.ui.theme.textSecondary

@Composable
fun SignupSuggestion(
    modifier: Modifier = Modifier,
    onSignupClick: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.dont_have_an_account),
            style = textNormal_12
                .copy(
                    color = MaterialTheme.colorScheme.textSecondary,
                    fontWeight = FontWeight(400),
                )
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            modifier = Modifier.clickable {
                onSignupClick?.invoke()
            },
            text = stringResource(id = R.string.sign_up),
            style = textNormal_12
                .copy(color = Blue200, fontWeight = FontWeight(600))
        )
    }
}