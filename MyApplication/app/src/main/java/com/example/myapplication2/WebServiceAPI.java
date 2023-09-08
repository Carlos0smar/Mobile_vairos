package com.example.myapplication2;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;


public interface WebServiceAPI {
    @GET("albums")
    Call<List<WSAlbums>>getAlbums();

}
