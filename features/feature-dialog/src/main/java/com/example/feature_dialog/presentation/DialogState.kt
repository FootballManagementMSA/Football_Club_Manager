package com.example.feature_dialog.presentation

import com.example.core.model.UserInfo

sealed class DialogState {
    data object Loading : DialogState()
    data class Success(val data: List<UserInfo>) : DialogState()
}
