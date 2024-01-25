package com.namnp.instagram_android.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.namnp.instagram_android.R
import com.namnp.instagram_android.presentation.common.pager_indicator.AutoSlidingCarousel
import com.namnp.instagram_android.presentation.ui.theme.Black200
import com.namnp.instagram_android.presentation.ui.theme.Black300
import com.namnp.instagram_android.presentation.ui.theme.Blue200
import com.namnp.instagram_android.presentation.ui.theme.Grey200
import com.namnp.instagram_android.presentation.ui.theme.InstagramComposeAndroidTheme
import com.namnp.instagram_android.presentation.ui.theme.White400
import com.namnp.instagram_android.presentation.ui.theme.backIcon
import com.namnp.instagram_android.presentation.ui.theme.isLight
import com.namnp.instagram_android.presentation.ui.theme.textNormal_12
import com.namnp.instagram_android.presentation.ui.theme.textNormal_13
import com.namnp.instagram_android.presentation.ui.theme.textPrimary

@Composable
fun HomeScreen(
//    mainViewModel: MainViewModel = hiltViewModel(),
) {
//    val themeState by mainViewModel.themeState.collectAsState()
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
            thickness = 0.6.dp,
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            items(10) { index ->
                Column(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Box {
                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape)
                                .background(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(
//                                        Color(0xfff9ce34),
//                                        Color(0xffee2a7b),
//                                        Color(0xff6228d7),
                                            /*Color(0xFFFF1B90),
                                            Color(0xFFF80261),
                                            Color(0xFFED00C0),
                                            Color(0xFFC500E9),
                                            Color(0xFF7017FF)*/
                                            Color(0xFFD91A46),
                                            Color(0xFFA60F93),
                                            Color(0xFFFBAA47),
                                        )
                                    )
                                )
                                .padding(2.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.background),
                            contentAlignment = Alignment.Center,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.img_rounded_avatar),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(51.dp)
                                    .clip(CircleShape)
                                    .border(
                                        0.1.dp,
                                        MaterialTheme.colorScheme.onBackground,
                                        CircleShape
                                    ),
                            )

                        }
                        if (index == 1) Box(
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(top = 46.dp)
                                .clip(RoundedCornerShape(3.dp))
                                .background(Color.White)
                                .padding(2.dp)
                                .clip(RoundedCornerShape(3.dp)),
                        ) {
                            Text(
                                text = "LIVE",
                                modifier = Modifier
                                    .background(
                                        brush = Brush.verticalGradient(
                                            colors = listOf(
                                                Color(0xFFC90083),
                                                Color(0xFFD22463),
                                                Color(0xFFE10038),
                                            )
                                        )
                                    )
                                    .padding(vertical = 1.dp, horizontal = 2.dp),
                                style = textNormal_12.copy(
                                    color = Color.White,
                                    fontSize = 8.sp,
                                )
                            )
                        }
                    }
                    if (index != 1) Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = if (index == 0) "Your Story" else "namnpse",
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
                .padding(top = 8.dp),
            color = Grey200,
            thickness = 0.6.dp,
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(10) {
                NewFeed()
            }
        }

        Switch(
//            checked = themeState.theme == Theme.Dark,
            checked = true,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Blue200,
            ),
            onCheckedChange = { _ ->
//                mainViewModel.toggleDarkMode()
            }
        )
    }
}

@Composable
fun NewFeed(
    modifier: Modifier = Modifier,
) {
    val images = remember {
        listOf(
            R.drawable.img_tokyo1,
            R.drawable.img_tokyo2,
            R.drawable.img_tokyo3,
        )
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        NewFeedHeader()
        NewFeedBody(images = images)
        NewFeedComments()
    }
}

@Composable
fun NewFeedHeader(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier
                .padding(10.dp)
                .size(32.dp),
            painter = painterResource(id = R.drawable.img_rounded_avatar),
            contentDescription = null,
        )
        Column {
            Text(
                text = "joshua_l",
                style = TextStyle(
                    fontSize = 13.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight(600),
                    color = Black200
                )
            )
            Text(
                text = "Tokyo, Japan",
                style = TextStyle(
                    fontSize = 11.sp,
                    fontWeight = FontWeight(400),
                    color = Black200,
                    letterSpacing = 0.07.sp,
                )
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier
                .padding(end = 10.dp)
                .width(14.dp),
            painter = painterResource(id = R.drawable.ic_more),
            contentDescription = null,
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NewFeedBody(
    modifier: Modifier = Modifier,
    images: List<Int>,
) {
    var currentPage by remember {
        mutableIntStateOf(1)
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        AutoSlidingCarousel(
            itemsCount = images.size,
            itemContent = { index ->
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    painter = painterResource(id = images[index]),
                    contentDescription = null,
                )
                /*AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(images[index])
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(200.dp)
                )*/
            },
            onPagerIndexChanged = { page ->
                currentPage = page + 1
            },
        )
        if (images.isNotEmpty())
            Text(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(14.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Black300)
                    .padding(horizontal = 7.dp, vertical = 5.dp),
                text = "$currentPage/${images.size}",
                style = textNormal_12.copy(
                    color = White400,
                )
            )
    }
}

@Composable
fun NewFeedComments(
    modifier: Modifier = Modifier,
) {
    val annotatedStringLikes = buildAnnotatedString {
        val boldTextStyle = SpanStyle(fontWeight = FontWeight.Bold)
        append("Liked by")
        withStyle(style = boldTextStyle) {
            append(" namnpse_jr")
        }
        append(" and")
        withStyle(style = boldTextStyle) {
            append(" 44,686 others")
        }
    }

    val annotatedStringContent = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append("joshua_l")
        }
        append(" The game in Japan was amazing and I want to share some photos")
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Row {
            Image(
                modifier = Modifier
                    .padding(end = 4.dp)
                    .clip(CircleShape)
                    .size(17.dp)
                ,
                painter = painterResource(id = R.drawable.img_rounded_avatar),
                contentDescription = null,
            )
            Text(
                text = annotatedStringLikes,
                style = textNormal_13
            )
        }
        Text(
            modifier = Modifier
                .padding(top = 4.dp),
            textAlign = TextAlign.Start,
            text = annotatedStringContent,
            style = textNormal_13
        )
    }
}

@Preview(
    showBackground = true,
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun HomeScreenPreview() {
    InstagramComposeAndroidTheme {
        HomeScreen()
    }
}