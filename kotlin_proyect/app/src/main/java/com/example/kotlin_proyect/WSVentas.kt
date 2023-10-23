package com.example.kotlin_proyect

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WSVentas {
    @SerializedName("id")
    @Expose
    private var id: Int? = null

    @SerializedName("codigo")
    @Expose
    private var codigo: String? = null

    @SerializedName("lugar")
    @Expose
    private var lugar: String? = null

    @SerializedName("cantidad")
    @Expose
    private var cantidad: Int? = null

}