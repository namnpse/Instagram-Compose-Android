package com.namnp.instagram_android.presentation.search

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.R
import com.namnp.instagram_android.domain.model.SearchSuggestion
import com.namnp.instagram_android.domain.repository.searchGallery
import com.namnp.instagram_android.domain.repository.searchSuggestions
import com.namnp.instagram_android.presentation.ui.theme.Black200
import com.namnp.instagram_android.presentation.ui.theme.Grey500
import com.namnp.instagram_android.presentation.ui.theme.Grey600
import com.namnp.instagram_android.presentation.ui.theme.Grey700
import com.namnp.instagram_android.presentation.ui.theme.InstagramComposeAndroidTheme
import com.namnp.instagram_android.presentation.ui.theme.text600_14
import com.namnp.instagram_android.presentation.ui.theme.textNormal16_24
import kotlin.random.Random

@Composable
fun SearchScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Grey600)
                    .padding(11.dp)
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Grey500),
                )
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = "Search",
                    style = textNormal16_24.copy(color = Grey500)
                )
            }
            Image(
                modifier = Modifier
                    .padding(start = 10.dp, end = 2.dp)
                    .size(20.dp),
                painter = painterResource(id = R.drawable.ic_scan),
                contentDescription = null,
//                colorFilter = ColorFilter.tint(Grey500),
            )
        }
        LazyRow(
            modifier = Modifier.padding(top = 2.dp)
        ) {
            itemsIndexed(searchSuggestions) { index, suggestion ->
                SearchSuggestionItem(
                    modifier = if (index == 0)
                        Modifier.padding(start = 8.dp)
                    else Modifier,
                    searchSuggestion = suggestion,
                )
            }
        }
        StaggeredGridSearchImage()
    }
}

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
            Image(
                modifier = Modifier
                    .height(height)
                    .padding(bottom = 2.dp),
                painter = painterResource(id = item.url),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@Composable
fun SearchSuggestionItem(
    modifier: Modifier = Modifier,
    searchSuggestion: SearchSuggestion,
) {
    Row(
        modifier = modifier
            .padding(end = 6.dp)
            .border(
                width = 1.dp,
                color = Grey700,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(horizontal = 10.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        searchSuggestion.icon?.let {
            Image(
                modifier = Modifier
                    .padding(end = 6.dp)
                    .width(13.dp)
                    .height(15.dp),
                painter = painterResource(id = it),
                contentDescription = null,
            )
        }
        Text(
            text = searchSuggestion.title,
            style = text600_14.copy(
                color = Black200
            )
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun SearchScreenPreview() {
    InstagramComposeAndroidTheme {
        SearchScreen()
    }
}

data class ListItem(
    val height: Dp,
    val color: Color
)

@Composable
fun RandomColorBox(item: ListItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(item.height)
            .clip(RoundedCornerShape(10.dp))
            .background(item.color)
    )
}