package com.example.feature_joinclub.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClubSearchViewModel @Inject constructor(

): ViewModel(){
    private val _searchValue = MutableStateFlow("")
    val searchValue: StateFlow<String> =_searchValue

    fun searchClub(clubName: String) {
        _searchValue.value = clubName
        viewModelScope.launch {

        }
    }

}