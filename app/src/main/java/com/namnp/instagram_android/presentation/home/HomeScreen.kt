package com.namnp.instagram_android.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.namnp.instagram_android.R
import com.namnp.instagram_android.presentation.MainViewModel
import com.namnp.instagram_android.presentation.ui.theme.Blue200
import com.namnp.instagram_android.presentation.ui.theme.Grey200
import com.namnp.instagram_android.presentation.ui.theme.backIcon
import com.namnp.instagram_android.presentation.ui.theme.isLight
import com.namnp.instagram_android.presentation.ui.theme.textNormal_12
import com.namnp.instagram_android.presentation.ui.theme.textPrimary
import com.namnp.instagram_android.utils.Theme

@Composable
fun HomeScreen(
    mainViewModel: MainViewModel = hiltViewModel(),
) {
    val themeState by mainViewModel.themeState.collectAsState()
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier.width(64.dp),
            ) {
                Image(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.ic_camera),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.backIcon)
                )
            }
            Image(
                modifier = Modifier
                    .width(120.dp)
                    .aspectRatio(105f / 28f),
                painter = painterResource(id = R.drawable.ic_instagram_logo),
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.backIcon)
            )
            Row {
                val iconId = if (MaterialTheme.colorScheme.isLight)
                    R.drawable.ic_tv_dark else R.drawable.ic_tv_light
                Image(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(24.dp),
                    painter = painterResource(id = iconId),
                    contentDescription = null,
                )
                Image(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.ic_send),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.backIcon)
                )
            }
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            color = Grey200,
            thickness = 1.dp,
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            items(10) {
                Column(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        MaterialTheme.colorScheme.primary,
                                        MaterialTheme.colorScheme.error
                                    )
                                )
                            )
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.background)
                        ,
                        contentAlignment = Alignment.Center,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img_rounded_avatar),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(51.dp)
                                .clip(CircleShape)
                                .border(0.5.dp, MaterialTheme.colorScheme.onBackground, CircleShape),
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Your Story",
                        style = textNormal_12.copy(
                            color = MaterialTheme.colorScheme.textPrimary,
                        )
                    )
                }
            }
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            color = Grey200,
            thickness = 1.dp,
        )

        Text(text = "Home")
        Switch(
            checked = themeState.theme == Theme.Dark,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Blue200,
            ),
            onCheckedChange = { _ ->
                mainViewModel.toggleDarkMode()
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}