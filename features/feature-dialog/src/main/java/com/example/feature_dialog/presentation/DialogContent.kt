package com.example.feature_dialog.presentation

import com.example.core.model.UserInfo

sealed class DialogContent {

    data class Info(val userInfo: UserInfo) : DialogContent()
}