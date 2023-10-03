package com.example.myapplication2;

import android.database.Observable;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;


public interface WebServiceAPI {
    @GET("albums")
    Call<List<WSAlbums>>getAlbums();

    @GET("primer.php")
    Call<List<WSPersons>>getPersons();
    @GET("primer1.php")
    Call<List<WSServicios>>getServicios();
    @GET("primer2.php")
    Call<List<WSVentas>>getVentas();
    @GET("primer3.php")
    Call<List<WSCompras>>getCompras();


    @POST("segundo.php")
    Call<WSPersona>postPersona(@Body WSPersona modelPersona);
//    @GET("segundo.php")
//    Call<List<WSCompras>>getCompras();

    @GET("primer.php")
    io.reactivex.Observable<?> getPersonsObs();
    @GET("primer1.php")
    io.reactivex.Observable<?> getServiciosObs();
    @GET("primer2.php")
    io.reactivex.Observable<List<WSVentas>>getVentasObs();
    @GET("primer3.php")
    io.reactivex.Observable<?> getComprasObs();
}
