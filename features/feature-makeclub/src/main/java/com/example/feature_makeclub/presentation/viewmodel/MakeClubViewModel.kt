package com.example.feature_makeclub.presentation.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MakeClubViewModel @Inject constructor(
): ViewModel() {
    private val _clubName = MutableStateFlow("")
    val clubName: StateFlow<String> = _clubName

    private  val _selectedImageUri = MutableStateFlow<Uri?>(null)
    val selectedImageUri: StateFlow<Uri?> = _selectedImageUri

    fun updateClubName(clubName: String) {
        viewModelScope.launch {
            _clubName.emit(clubName)
        }
    }

    fun updateSelectedImageUri(uri: Uri?) {
        _selectedImageUri.value = uri
    }
}