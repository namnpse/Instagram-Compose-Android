package com.namnp.instagram_android.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.namnp.instagram_android.R
import com.namnp.instagram_android.presentation.ui.theme.textNormal_12
import com.namnp.instagram_android.presentation.ui.theme.textPrimary

@Composable
fun Story(
    modifier: Modifier = Modifier,
    index: Int,
) {
    Column(
        modifier = modifier
            .padding(horizontal = 10.dp),
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
                    .background(MaterialTheme.colorScheme.background)
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