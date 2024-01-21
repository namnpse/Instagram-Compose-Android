package com.namnp.instagram_android.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.namnp.instagram_android.R
import com.namnp.instagram_android.presentation.login.composables.SignupSuggestion
import com.namnp.instagram_android.presentation.ui.spacing
import com.namnp.instagram_android.presentation.ui.theme.*
import com.namnp.instagram_android.presentation.ui.theme.InstagramComposeAndroidTheme

@Composable
fun WelcomeScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Box {}
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MaterialTheme.spacing.large),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                /*            painter = rememberAsyncImagePainter(
                            ImageRequest.Builder(LocalContext.current)
                                .data(data = R.drawable.ic_instagram_logo)
                                .build()
                        ),*/
                painter = painterResource(id = R.drawable.ic_instagram_logo),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(52.dp))
            Image(
                painter = painterResource(id = R.drawable.img_rounded_avatar),
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(MaterialTheme.spacing.medium),
                text = "namjr_bryan",
                style = text600_14.copy(color = Black200, fontSize = 18.sp)
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MaterialTheme.spacing.large),
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue200,
                    disabledContainerColor = Blue200.copy(alpha = 0.5f)
                ),
                enabled = true,
                onClick = {}
            ) {
                Text(
                    modifier = Modifier.padding(6.dp),
                    text = stringResource(id = R.string.log_in),
                    style = text600_14
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = stringResource(id = R.string.switch_accounts),
                style = text600_14.copy(color = Blue200)
            )
        }
        Column {
            Divider(color = Grey300, thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                SignupSuggestion(
                    onSignupClick = {

                    }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun WelcomeScreenCompose() {
    InstagramComposeAndroidTheme {
        WelcomeScreen()
    }
}