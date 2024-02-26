package com.example.feature_mypage.presentation

import com.example.core.model.MyPageUserInfoUiModel

sealed class UserInfoState {
    data class Success(val data: MyPageUserInfoUiModel) : UserInfoState()
    data object Loading : UserInfoState()
}
