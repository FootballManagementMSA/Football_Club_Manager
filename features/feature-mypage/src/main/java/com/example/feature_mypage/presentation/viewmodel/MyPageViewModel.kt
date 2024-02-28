package com.example.feature_mypage.presentation.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_mypage.domain.usecase.ClearDataStoreUseCase
import com.example.feature_mypage.domain.usecase.GetUserInfoUseCase
import com.example.feature_mypage.presentation.UserInfoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val clearDataStoreUseCase: ClearDataStoreUseCase
): ViewModel() {
    private  val _selectedImageUri = MutableStateFlow<Uri?>(null)
    val selectedImageUri: StateFlow<Uri?> = _selectedImageUri

    private val _uiState = MutableStateFlow<UserInfoState>(UserInfoState.Loading)
    val uiState get() = _uiState
    init {
        loadUserInfo()
    }
    fun updateSelectedImageUri(uri: Uri?) {
        _selectedImageUri.value = uri
    }

    private fun loadUserInfo() {
        viewModelScope.launch {
            _uiState.value = UserInfoState.Success(getUserInfoUseCase())
        }
    }

    fun clearDataStore() {
        viewModelScope.launch {
            clearDataStoreUseCase()
        }
    }
}