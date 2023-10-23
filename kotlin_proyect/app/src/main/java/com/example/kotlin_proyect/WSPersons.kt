package com.example.kotlin_proyect

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WSPersons {

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("ci")
    @Expose
    var ci: String? = null

    @SerializedName("paterno")
    @Expose
    var paterno: String? = null

    @SerializedName("materno")
    @Expose
    var materno: String? = null

    @SerializedName("nombre")
    @Expose
    var nombre: String? = null


}