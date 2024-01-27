package com.namnp.instagram_android.presentation.search.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.namnp.instagram_android.R
import com.namnp.instagram_android.domain.repository.searchGallery
import com.namnp.instagram_android.utils.previewPlaceholder
import kotlin.random.Random

@Composable
fun StaggeredGridSearchImage() {
    LazyVerticalStaggeredGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        columns = StaggeredGridCells.Fixed(3),
//        columns = StaggeredGridCells.Adaptive(50.dp),
//        contentPadding = PaddingValues(10.dp),
//        verticalItemSpacing = 5.dp,
//        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(searchGallery) { item ->
            val height: Dp = (Random.nextInt(3) * 150).dp
            // use for preview only
            /*Image(
                modifier = Modifier
                    .height(height)
                    .padding(bottom = 2.dp),
                painter = painterResource(id = item.url),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )*/
            // use for real use case (more optimized)
            AsyncImage(
                modifier = Modifier
                    .height(height)
                    .padding(bottom = 2.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.url)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = previewPlaceholder(debugPreview = R.drawable.img_avatar1)
            )
        }
    }
}