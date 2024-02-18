package com.example.auto_complete

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AutoCompleteViewModel @Inject constructor(
): ViewModel(){
    private val _searchValue = MutableStateFlow("")
    val searchValue: StateFlow<String> = _searchValue

    private val _expanded = MutableStateFlow(false)
    val expanded: StateFlow<Boolean> = _expanded

    fun updateExpandedValue(boolean: Boolean) {
        _expanded.value = boolean
    }

    fun updateSearchValue(value: String) {
        _searchValue.value = value
    }
}