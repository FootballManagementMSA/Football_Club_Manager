package com.example.feature_makeclub.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MakeClubViewModel @Inject constructor(
): ViewModel() {
    private val _clubName = mutableStateOf("")
    val clubName: State<String> = _clubName

    fun updateClubName(clubName: String) {
        _clubName.value = clubName
    }
}