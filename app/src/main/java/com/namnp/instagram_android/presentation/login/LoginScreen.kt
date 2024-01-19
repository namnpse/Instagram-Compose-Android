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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.namnp.instagram_android.R
import com.namnp.instagram_android.presentation.ui.theme.Black200
import com.namnp.instagram_android.presentation.ui.theme.Blue200
import com.namnp.instagram_android.presentation.ui.theme.Grey200
import com.namnp.instagram_android.presentation.ui.theme.InstagramComposeAndroidTheme

@Composable
fun LoginScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Box {}
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
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
                modifier = Modifier.padding(12.dp),
                text = "jacob_w",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(600),
                    color = Black200,
                    textAlign = TextAlign.Center,
                )
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                shape = RoundedCornerShape(10),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue200
                ),
                onClick = {}
            ) {
                Text(
                    modifier = Modifier.padding(6.dp),
                    text = "Log in",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(600),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Switch accounts",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(600),
                    color = Blue200,
                    textAlign = TextAlign.Center,
                )
            )
        }
        Column(

        ) {
            Divider(color = Grey200, thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Don’t have an account?",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0x66000000),
                        textAlign = TextAlign.Center,
                    )
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Sign up.",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF262626),
                        textAlign = TextAlign.Center,
                    )
                )
            }
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