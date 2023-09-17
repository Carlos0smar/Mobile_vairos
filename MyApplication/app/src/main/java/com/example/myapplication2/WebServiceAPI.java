package com.example.myapplication2;

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
    @POST("segundo.php")
    Call<WSPersona>postPersona(@Body WSPersona modelPersona);
    @GET("segundo.php")
    Call<List<WSCompras>>getCompras();
}
