package com.example.auto_complete

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun <T> AutoComplete(
    modifier: Modifier = Modifier,
    placeholder: String,
    items: List<T>,
    itemFilter: (T) -> String,
    viewModel: AutoCompleteViewModel = hiltViewModel(),
    content: @Composable (T) -> Unit
) {
    val expanded = viewModel.expanded.collectAsState()
    val searchValue = viewModel.searchValue.collectAsState()
    Column(
        modifier = modifier
            .padding(30.dp)
            .fillMaxWidth()
            .clickable(
                onClick = {
                    viewModel.updateExpandedValue(false)
                }
            )
    ) {
        AutoCompleteTextField(
            searchValue = searchValue,
            expanded = { viewModel.updateExpandedValue(!expanded.value)},
            placeholder = placeholder
        ) {
            viewModel.updateSearchValue(it)
            viewModel.updateExpandedValue(true)
        }

        SearchDropdown(
            expanded = expanded,
            items = items,
            itemFilter = itemFilter,
            searchValue = searchValue,
            onSearchValueSelect = {
                viewModel.updateSearchValue(itemFilter(it))
                viewModel.updateExpandedValue(false)
            },
        ) {
            content(it)
        }
    }
}

@Composable
fun AutoCompleteTextField(
    searchValue: State<String>,
    expanded: () -> Unit,
    placeholder: String,
    onValueChange: (String) -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(10.dp)
                ),
            value = searchValue.value,
            onValueChange = onValueChange,
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 16.sp
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            placeholder = { Text(text = placeholder) },
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = { expanded() }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                }

            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                cursorColor = Color.Black
            )
        )
    }
}

@Composable
fun <T> SearchDropdown(
    expanded: State<Boolean>,
    items: List<T>,
    itemFilter: (T) -> String,
    searchValue: State<String>,
    onSearchValueSelect: (T) -> Unit,
    content: @Composable (T) -> Unit
) {
    AnimatedVisibility(visible = expanded.value) {
        Card(
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
        ) {
            LazyColumn(
                modifier = Modifier.heightIn(max = 450.dp),
            ) {
                if (searchValue.value.isNotEmpty()) {
                    items(
                        items.filter {
                            itemFilter(it).lowercase().contains(searchValue.value.lowercase())
                        }
                            .sortedBy { itemFilter(it) }
                    ) {
                        SearchItems(item = it, onSearchValueSelect = onSearchValueSelect) {
                            content(it)
                        }
                    }
                } else {
                    items(
                        items.sortedBy { itemFilter(it) }
                    ) {
                        SearchItems(item = it, onSearchValueSelect = onSearchValueSelect) {
                            content(it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun <T> SearchItems(item: T, onSearchValueSelect: (T) -> Unit, content: @Composable () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onSearchValueSelect(item)
            }
            .padding(10.dp)
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun AutoCompletePreview() {

}