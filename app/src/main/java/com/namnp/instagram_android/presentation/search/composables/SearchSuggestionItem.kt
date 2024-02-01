package com.namnp.instagram_android.presentation.search.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.domain.model.SearchSuggestion
import com.namnp.instagram_android.presentation.ui.theme.borderColor
import com.namnp.instagram_android.presentation.ui.theme.text600_14
import com.namnp.instagram_android.presentation.ui.theme.textPrimary

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
                color = MaterialTheme.colorScheme.borderColor,
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
                colorFilter = ColorFilter.tint(
                    color = MaterialTheme.colorScheme.textPrimary,
                )
            )
        }
        Text(
            text = searchSuggestion.title,
            style = text600_14.copy(
                color = MaterialTheme.colorScheme.textPrimary,
            )
        )
    }
}