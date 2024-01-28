package com.namnp.instagram_android.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.namnp.instagram_android.R
import com.namnp.instagram_android.presentation.MainViewModel
import com.namnp.instagram_android.presentation.common.AppBar
import com.namnp.instagram_android.presentation.login.composables.InputAccount
import com.namnp.instagram_android.presentation.login.composables.SignupSuggestion
import com.namnp.instagram_android.presentation.navigation.Screen
import com.namnp.instagram_android.presentation.ui.spacing
import com.namnp.instagram_android.presentation.ui.theme.Blue200
import com.namnp.instagram_android.presentation.ui.theme.Grey200
import com.namnp.instagram_android.presentation.ui.theme.InstagramComposeAndroidTheme
import com.namnp.instagram_android.presentation.ui.theme.colorPrimary
import com.namnp.instagram_android.presentation.ui.theme.text600_14
import com.namnp.instagram_android.presentation.ui.theme.textNormal_12
import com.namnp.instagram_android.presentation.ui.theme.textSecondary
import com.namnp.instagram_android.utils.Theme

@Composable
fun LoginScreen(
    navController: NavHostController? = null,
) {
    var showPassword by remember { mutableStateOf(false) }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loginEnabled by remember { mutableStateOf(false) }
    LaunchedEffect(key1 = username, key2 = password) {
        loginEnabled = username.isNotEmpty() && password.isNotEmpty()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        /*Icon(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .clickable {
                    navController?.navigateUp()
                },
            imageVector = Icons.Filled.ArrowBackIos,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.colorPrimary
        )*/
        AppBar(
            onClick = {
                navController?.navigateUp()
            }
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_instagram_logo),
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.colorPrimary)
            )
            Spacer(modifier = Modifier.height(40.dp))
            InputAccount(
                username = username,
                onUsernameChanged = {
                    username = it
                },
                password = password,
                onPasswordChanged = {
                    password = it
                },
                showPassword = showPassword,
                onToggleShowPassword = {
                    showPassword = !showPassword
                }
            )
            Text(
                modifier = Modifier
                    .padding(top = 12.dp, end = 16.dp, bottom = 30.dp)
                    .fillMaxWidth(),
                text = "Forgot password?",
                style = textNormal_12.copy(
                    color = Blue200,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.End,
                    letterSpacing = 0.15.sp
                ),
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MaterialTheme.spacing.medium),
                shape = RoundedCornerShape(10),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue200,
//                    disabledContainerColor = Blue200.copy(alpha = 0.5f)
                ),
                enabled = loginEnabled,
                onClick = {
                    navController?.navigate(Screen.MainApp.route) {
     /*                   popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                            saveState = true
                        }
                        launchSingleTop = true*/
                    }
                }
            ) {
                Text(
                    modifier = Modifier.padding(6.dp),
                    text = stringResource(id = R.string.log_in),
                    style = text600_14.copy(
                        color = if (loginEnabled) Color.White
                        else Color.White.copy(alpha = 0.5f),
                    )
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(17.dp),
                    painter = painterResource(id = R.drawable.ic_facebook),
                    contentDescription = null
                )
                Text(
                    text = stringResource(id = R.string.login_with_facebook),
                    style = text600_14.copy(color = Blue200)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Divider(
                    modifier = Modifier.weight(1f),
                    color = Grey200,
                    thickness = 1.dp,
                )
                Text(
                    modifier = Modifier.padding(horizontal = 30.dp, vertical = 30.dp),
                    text = stringResource(id = R.string.or).uppercase(),
                    style = text600_14.copy(
                        color = MaterialTheme.colorScheme.textSecondary
                    )
                )
                Divider(
                    modifier = Modifier.weight(1f),
                    color = Grey200,
                    thickness = 1.dp,
                )
            }
            SignupSuggestion(
                onSignupClick = {

                }
            )
        }
        Column {
            Divider(color = Grey200, thickness = 1.dp)
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                text = stringResource(id = R.string.instagram_vs_facebook),
                style = textNormal_12
                    .copy(
                        color = MaterialTheme.colorScheme.textSecondary,
                        fontWeight = FontWeight(400),
                    )
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun LoginScreenCompose() {
    InstagramComposeAndroidTheme {
        LoginScreen()
    }
}