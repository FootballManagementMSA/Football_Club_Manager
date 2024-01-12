package com.example.core.model

data class Screen(
    val width: Double,
    val height: Double
) {
    companion object {
        fun Screen.mapToDataModel() =
            com.example.network_api.model.Screen(this.width, this.height)
    }
}