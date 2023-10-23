package com.example.kotlin_proyect

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WSCompras {
    @SerializedName("id")
    @Expose
    private var id: Int? = null

    @SerializedName("cantidad")
    @Expose
    private var cantidad: Int? = null

    @SerializedName("precio")
    @Expose
    private var precio: Int? = null

    @SerializedName("descripcion")
    @Expose
    private var descripcion: String? = null

}