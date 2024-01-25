package com.example.feature_dialog.presentation

sealed class DialogHeader {
    data class Default(val title: String, val dismiss: () -> Unit) : DialogHeader()
}