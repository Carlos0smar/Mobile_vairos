package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

//import android.database.Observable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



import io.reactivex.Observable;
import io.reactivex.functions.Function;

//import java.util.function.Function;


public class WebService4Activity extends AppCompatActivity {

    Button ButtonImprimir;
    private List<WSPersons> listDataPersons = new ArrayList<>();
    private List<WSCompras> listDataCompras = new ArrayList<>();
    private List<WSVentas> listDataVentas = new ArrayList<>();
    private List<WSServicios> listDataServicios = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service4);

        ButtonImprimir = findViewById(R.id.buttonImprimir);


        ButtonImprimir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recoveryData();
            }
        });
    }

    public void getAllData(){
        String URL_WS = "http://192.168.1.6:80/movil/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_WS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebServiceAPI webServiceApi = retrofit.create(WebServiceAPI.class);

        final Call<List<WSCompras>> call = webServiceApi.getCompras();
        final Call<List<WSPersons>> call2 = webServiceApi.getPersons();
        final Call<List<WSVentas>> call3 = webServiceApi.getVentas();
        final Call<List<WSServicios>> call4 = webServiceApi.getServicios();
        call.enqueue(new Callback<List<WSCompras>>() {
            @Override
            public void onResponse(Call<List<WSCompras>> call, Response<List<WSCompras>> response) {
                if(response.isSuccessful()){
                    listDataCompras = response.body();
                    Toast.makeText(WebService4Activity.this, listDataCompras.get(0).getDescripcion(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(WebService4Activity.this, "REVISE SU SERVICIO DE INTERNETsd", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<WSCompras>> call, Throwable t) {

                Log.e("RetrofitError", t.getMessage());
                Toast.makeText(WebService4Activity.this, "REVISE EL SERVICIO WEB DE INTERNET compras", Toast.LENGTH_SHORT).show();
            }
        });

        call2.enqueue(new Callback<List<WSPersons>>() {
            @Override
            public void onResponse(Call<List<WSPersons>> call2, Response<List<WSPersons>> response) {
                if(response.isSuccessful()){
                    listDataPersons = response.body();
                    Toast.makeText(WebService4Activity.this, listDataPersons.get(0).getPaterno(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(WebService4Activity.this, "REVISE SU SERVICIO DE INTERNET s", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<WSPersons>> call, Throwable t) {
                Log.e("RetrofitError", t.getMessage());
                Toast.makeText(WebService4Activity.this, "REVISE EL SERVICIO WEB DE INTERNET persons", Toast.LENGTH_SHORT).show();
            }
        });

        call3.enqueue(new Callback<List<WSVentas>>() {
            @Override
            public void onResponse(Call<List<WSVentas>> call, Response<List<WSVentas>> response) {
                if(response.isSuccessful()){
                    listDataVentas = response.body();
                    Toast.makeText(WebService4Activity.this, listDataVentas.get(0).getLugar(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(WebService4Activity.this, "REVISE SU SERVICIO DE INTERNETd", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<WSVentas>> call, Throwable t) {
                Log.e("RetrofitError", t.getMessage());
                Toast.makeText(WebService4Activity.this, "REVISE EL SERVICIO WEB DE INTERNET ventas", Toast.LENGTH_SHORT).show();
            }
        });

        call4.enqueue(new Callback<List<WSServicios>>() {
            @Override
            public void onResponse(Call<List<WSServicios>> call, Response<List<WSServicios>> response) {
                if(response.isSuccessful()){
                    listDataServicios = response.body();
                    Toast.makeText(WebService4Activity.this, listDataServicios.get(0).getDescripcion(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(WebService4Activity.this, "REVISE SU SERVICIO DE INTERNETf", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<WSServicios>> call, Throwable t) {
                Log.e("RetrofitError", t.getMessage());
                Toast.makeText(WebService4Activity.this, "REVISE EL SERVICIO WEB DE INTERNET reserva", Toast.LENGTH_SHORT).show();
            }
        });
    }

//    public void getAllData(){
//        String URL_WS = "http://192.168.189.117/movil/";
//        long startTime = System.currentTimeMillis();
//        final Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(URL_WS)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        WebServiceAPI webServiceApi = retrofit.create(WebServiceAPI.class);
//
//        final Call<List<WSCompras>> call = webServiceApi.getCompras();
//        final Call<List<WSPersons>> call2 = webServiceApi.getPersons();
//        final Call<List<WSVentas>> call3 = webServiceApi.getVentas();
//        final Call<List<WSReserva>> call4 = webServiceApi.getReserva();
//        call.enqueue(new Callback<List<WSCompras>>() {
//            @Override
//            public void onResponse(Call<List<WSCompras>> call, Response<List<WSCompras>> response) {
//                if(response.isSuccessful()){
//                    listDataCompras = response.body();
//                    Toast.makeText(OmegaActivity.this, listDataCompras.get(0).getDescripcion(), Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(OmegaActivity.this, "REVISE SU SERVICIO DE INTERNET", Toast.LENGTH_SHORT).show();
//                }
//            }
//            @Override
//            public void onFailure(Call<List<WSCompras>> call, Throwable t) {
//                Log.e("RetrofitError", t.getMessage());
//                Toast.makeText(OmegaActivity.this, "REVISE EL SERVICIO WEB DE INTERNET compras", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        call2.enqueue(new Callback<List<WSPersons>>() {
//            @Override
//            public void onResponse(Call<List<WSPersons>> call2, Response<List<WSPersons>> response) {
//                if(response.isSuccessful()){
//                    listDataPersons = response.body();
//                    Toast.makeText(OmegaActivity.this, listDataPersons.get(0).getPaterno(), Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(OmegaActivity.this, "REVISE SU SERVICIO DE INTERNET ", Toast.LENGTH_SHORT).show();
//                }
//            }
//            @Override
//            public void onFailure(Call<List<WSPersons>> call, Throwable t) {
//                Log.e("RetrofitError", t.getMessage());
//                Toast.makeText(OmegaActivity.this, "REVISE EL SERVICIO WEB DE INTERNET persons", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        call3.enqueue(new Callback<List<WSVentas>>() {
//            @Override
//            public void onResponse(Call<List<WSVentas>> call, Response<List<WSVentas>> response) {
//                if(response.isSuccessful()){
//                    listDataVentas = response.body();
//                    Toast.makeText(OmegaActivity.this, listDataVentas.get(0).getDescripcion(), Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(OmegaActivity.this, "REVISE SU SERVICIO DE INTERNET", Toast.LENGTH_SHORT).show();
//                }
//            }
//            @Override
//            public void onFailure(Call<List<WSVentas>> call, Throwable t) {
//                Log.e("RetrofitError", t.getMessage());
//                Toast.makeText(OmegaActivity.this, "REVISE EL SERVICIO WEB DE INTERNET ventas", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        call4.enqueue(new Callback<List<WSReserva>>() {
//            @Override
//            public void onResponse(Call<List<WSReserva>> call, Response<List<WSReserva>> response) {
//                if(response.isSuccessful()){
//                    listDataReserva = response.body();
//                    // Obtén el tiempo actual después de recibir la respuesta
//                    long endTime = System.currentTimeMillis();
//                    long elapsedTime = endTime - startTime;
//
//                    // Convierte el tiempo a segundos
//                    double seconds = elapsedTime / 1000.0;
//
//                    // Muestra el tiempo en un Toast
//
//
//                    Toast.makeText(OmegaActivity.this, listDataReserva.get(0).getItem(), Toast.LENGTH_SHORT).show();
//
//                    String message = "Tiempo de ejecución: " + seconds + " segundos";
//                    Toast.makeText(OmegaActivity.this, message, Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(OmegaActivity.this, "REVISE SU SERVICIO DE INTERNET", Toast.LENGTH_SHORT).show();
//                }
//            }
//            @Override
//            public void onFailure(Call<List<WSReserva>> call, Throwable t) {
//                Log.e("RetrofitError", t.getMessage());
//                Toast.makeText(OmegaActivity.this, "REVISE EL SERVICIO WEB DE INTERNET reserva", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    private void recoveryData() {
        String URL_WS = "http://192.168.173.115/mobile/";
        Gson gson = new GsonBuilder().setLenient().create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(URL_WS);
        builder.client(client);
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        builder.addConverterFactory(GsonConverterFactory.create(gson));
        Retrofit retrofit2 = builder.build();
        WebServiceAPI webServiceApi2 = retrofit2.create(WebServiceAPI.class);
        List<Observable<?>> requests = new ArrayList<>();

        requests.add(webServiceApi2.getPersonsObs());
        requests.add(webServiceApi2.getComprasObs());
        requests.add(webServiceApi2.getVentasObs());
        requests.add(webServiceApi2.getServiciosObs());

        Disposable obs = Observable.zip(requests, new Function<Object[], Object>() {
                    @Override
                    public Object apply(Object[] objects) throws Exception {
                        listDataCompras = (List<WSCompras>)objects[0];
                        listDataPersons = (List<WSPersons>)objects[1];
                        listDataServicios = (List<WSServicios>)objects[2];
                        listDataVentas = (List<WSVentas>)objects[3];
                        return new Object();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(
                        new DisposableObserver<Object>() {
                            @Override
                            public void onNext(Object o) {
                                if (listDataPersons != null && !listDataPersons.isEmpty()) {
                                    String paterno = listDataPersons.get(0).getPaterno();
                                    Toast.makeText(WebService4Activity.this, "Paterno: " + paterno, Toast.LENGTH_SHORT).show();
                                }

                                if (listDataCompras != null && !listDataCompras.isEmpty()) {
                                    String descripcion = listDataCompras.get(0).getDescripcion();
                                    Toast.makeText(WebService4Activity.this, "Descripción de compras: " + descripcion, Toast.LENGTH_SHORT).show();
                                }

                                if (listDataVentas != null && !listDataVentas.isEmpty()) {
                                    String venta = listDataVentas.get(0).getLugar();
                                    Toast.makeText(WebService4Activity.this, "Lugar de venta: " + venta, Toast.LENGTH_SHORT).show();
                                }

                                if (listDataServicios != null && !listDataServicios.isEmpty()) {
                                    String reserva = listDataServicios.get(0).getDescripcion();
                                    Toast.makeText(WebService4Activity.this, "Descripción de reserva: " + reserva, Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.d("Datos", "OnError ");
                            }
                            @Override
                            public void onComplete() {
                                Log.d("Datos", "Finalizado con exito onComplete ");
                            }
                 });
    }
}