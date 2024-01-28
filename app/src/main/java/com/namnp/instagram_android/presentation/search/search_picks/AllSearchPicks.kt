package com.namnp.instagram_android.presentation.search.search_picks

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.namnp.instagram_android.R
import com.namnp.instagram_android.domain.repository.searchGallery
import com.namnp.instagram_android.presentation.common.AppBar
import com.namnp.instagram_android.presentation.ui.theme.InstagramComposeAndroidTheme
import com.namnp.instagram_android.utils.previewPlaceholder

@Composable
fun AllSearchPickScreen(
    navController: NavHostController? = null,
) {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxSize(),
    ) {
        AppBar(
            title = "All posts",
            onClick = {
                navController?.navigateUp()
            },
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
        ) {
            val searchResult = searchGallery.shuffled()
            items(searchResult) { item ->
                val isMultipleImages = item.id % 4 == 1
                val isVideo = item.id % 4 == 2
                Box(
                    modifier = Modifier
                        .padding(bottom = 2.dp),
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                        ,
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(item.url)
                            .build(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        placeholder = previewPlaceholder(debugPreview = R.drawable.img_avatar1)
                    )
                    if (isMultipleImages) Image(
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.TopEnd)
                            .size(17.dp),
                        painter = painterResource(id = R.drawable.ic_multiple_images),
                        contentDescription = null,
                    )
                    if (isVideo) Image(
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.TopEnd)
                            .width(20.dp)
                            .height(14.dp),
                        painter = painterResource(id = R.drawable.ic_record),
                        contentDescription = null,
                    )
                }
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
        AllSearchPickScreen()
    }
}