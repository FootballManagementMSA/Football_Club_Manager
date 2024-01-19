package com.example.feature_mypage.presentation.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
): ViewModel() {
    private  val _selectedImageUri = MutableStateFlow<Uri?>(null)
    val selectedImageUri: StateFlow<Uri?> = _selectedImageUri

    init {
        // 서버에서 이미지 가져오기
    }
    fun updateSelectedImageUri(uri: Uri?) {
        _selectedImageUri.value = uri
    }
}