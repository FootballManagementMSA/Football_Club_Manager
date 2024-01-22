package com.example.feature_dialog.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.model.UserInfo
import com.example.feature_dialog.domain.GetJoinClubUserInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DialogViewModel @Inject constructor(
    private val getJoinClubUserInfoUseCase: GetJoinClubUserInfoUseCase
) : ViewModel() {
    private val _joinClubUserInfo = MutableStateFlow<List<UserInfo>>(listOf( UserInfo("","","","")))
    val joinClubUserInfo: StateFlow<List<UserInfo>> = _joinClubUserInfo

    init {
        getJoinClubUserInfo()
    }

    fun getJoinClubUserInfo() {
        viewModelScope.launch {
            _joinClubUserInfo.value = getJoinClubUserInfoUseCase()
        }
    }

}