package com.namnp.instagram_android.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.namnp.instagram_android.R
import com.namnp.instagram_android.presentation.MainViewModel
import com.namnp.instagram_android.presentation.login.composables.SignupSuggestion
import com.namnp.instagram_android.presentation.navigation.Screen
import com.namnp.instagram_android.presentation.ui.spacing
import com.namnp.instagram_android.presentation.ui.theme.Black200
import com.namnp.instagram_android.presentation.ui.theme.Blue200
import com.namnp.instagram_android.presentation.ui.theme.Grey300
import com.namnp.instagram_android.presentation.ui.theme.InstagramComposeAndroidTheme
import com.namnp.instagram_android.presentation.ui.theme.backIcon
import com.namnp.instagram_android.presentation.ui.theme.text600_14
import com.namnp.instagram_android.presentation.ui.theme.textPrimary
import com.namnp.instagram_android.utils.Theme

@Composable
fun WelcomeScreen(
    mainViewModel: MainViewModel = hiltViewModel(),
    navController: NavHostController? = null,
) {
    val themeState by mainViewModel.themeState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
//        Box {}
        Switch(
            checked = themeState.theme == Theme.Dark,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Blue200,
            ),
            onCheckedChange = { _ ->
                mainViewModel.toggleDarkMode()
            }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MaterialTheme.spacing.large),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_instagram_logo),
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.backIcon)
            )
            Spacer(modifier = Modifier.height(52.dp))
            Image(
                painter = painterResource(id = R.drawable.img_rounded_avatar),
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(MaterialTheme.spacing.medium),
                text = "namjr_bryan",
                style = text600_14.copy(
                    color = MaterialTheme.colorScheme.textPrimary,
                    fontSize = 18.sp,
                )
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
                onClick = {
                    navController?.navigate(Screen.LoginScreen.route)
                }
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