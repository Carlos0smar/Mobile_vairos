package com.example.kotlin_proyect

import com.google.gson.annotations.SerializedName

class ResponseLugar {
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("nombre")
    var nombre: String = ""
    @SerializedName("descripcion")
    var descripcion: String = ""
    @SerializedName("latitud")
    var latitud: Float = 0.0f
    @SerializedName("longitud")
    var longitud: Float = 0.0f
}