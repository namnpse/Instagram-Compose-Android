package com.namnp.instagram_android.presentation.search.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.domain.repository.searchSuggestions

@Composable
fun SearchSuggestionCompose() {
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
}