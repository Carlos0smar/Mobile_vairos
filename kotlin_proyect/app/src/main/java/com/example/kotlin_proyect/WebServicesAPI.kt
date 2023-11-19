package com.example.kotlin_proyect
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
//import io.reactivex.Observable
import okhttp3.ResponseBody

interface WebServicesAPI {

    @GET("primer.php")
    fun getPersons(): Call<List<WSPersons>>

    @POST("multiplciacion.php")
    fun postPersona(@Body multiplicacion: WSMultiplicacion): Call<WSMultiplicacion>


    @GET("primer1.php")
    fun getServicios(): Call<List<WSServicios>>

    @GET("primer2.php")
    fun getVentas(): Call<List<WSVentas>>

    @GET("primer3.php")
    fun getCompras(): Call<List<WSCompras>>

    @GET("primer_lugares.php")
    fun getLugares(): Call<List<ResponseLugar>>

//    @POST("segundo.php")
//    fun addLugar(@Body placeData: PostLugar): Call<ResponseBody>
//
//    @GET("primer.php")
//    fun getResponseOne(): Observable<List<ResponseLugar>>
//
//    @GET("primer.php")
//    fun getResponseTwo(): Observable<List<ResponseLugar>>
//
//    @GET("primer.php")
//    fun getResponseThree(): Observable<List<ResponseLugar>>
//
//    @GET("primer.php")
//    fun getResponseFour(): Observable<List<ResponseLugar>>

}