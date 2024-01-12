package com.example.core.model

data class Position(
    val x : Float,
    val y : Float
){
    companion object{
        fun Position.mapToDataModel() =
            com.example.network_api.model.Position(this.x, this.y)
    }
}
