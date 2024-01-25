package com.example.feature_dialog.presentation

sealed class DialogButton {

    data class Dark(val text: String) : DialogButton()

    data class Gradient(val text: String) : DialogButton()
}