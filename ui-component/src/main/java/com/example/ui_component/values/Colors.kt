package com.example.ui_component.values

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val mainTheme = Color(0xFF232A39)

val horizontalGradation = Brush.horizontalGradient(
    colors = listOf(
        Color(0xFFEE6DE7),
        Color(0xFF857FEB)
    )
)

val verticalGradation = Brush.verticalGradient(
    colors = listOf(
        Color(0xFFEE6DE7),
        Color(0xFF857FEB)
    )
)
val transparentBrush = Brush.linearGradient(
    colors = listOf(Color.Transparent, Color.Transparent)
)

val profileInfoButton = Color(0xFFDFDFDF)
val grayText = Color(0xFFB6BFCD)
val subTheme = Color(0xFF2E3D53)
val darkGray = Color(0xFF535353)
val semiRed = Color(0xFFDA7373)
val semiBlue = Color(0xFF6CACDF)
val darkButton = Color(0xFF212A3A)
val lastGradientColor = Color(0xFF857FEB)
val firstGradientColor = Color(0xFFEE6DE7)
val gradientColorsList = listOf(Color(0xFFEE6DE7), Color(0xFF857FEB))