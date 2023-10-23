package com.example.kotlin_proyect
import retrofit2.Call
import retrofit2.http.GET

interface WebServicesAPI {

    @GET("primer.php")
    fun getPersons(): Call<List<WSPersons>>

    @GET("primer1.php")
    fun getServicios(): Call<List<WSServicios>>

    @GET("primer2.php")
    fun getVentas(): Call<List<WSVentas>>

    @GET("primer3.php")
    fun getCompras(): Call<List<WSCompras>>
}