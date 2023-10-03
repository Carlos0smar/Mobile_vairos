package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    DataBase dataBase;
    SQLiteDatabase db;

    List<WSAlbums> ListData = new ArrayList<>();
    List<WSPersons> listDataPersons = new ArrayList<>();
    List<WSCompras> listDataCompras = new ArrayList<>();
    Button ButtonOperaciones, ButtonSalir, ButtonSegundoGrado, ButtonImaginarios, ButtonCalculadora,
            ButtonGraficos2D, ButtonGraficos2DTarea, ButtonEscalado, ButtonEnviar, ButtonBD, ButtonBDTarea,
            ButtonWebService, ButtonWebServicePersons, ButtonWebServiceCompras,
            ButtonWebServicePersonsPost, PrimerParcial, FormWS, ButtonWebService4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonOperaciones = findViewById(R.id.ButtonOperaciones);
        ButtonSegundoGrado = findViewById(R.id.buttonSegundoGrado);
        ButtonCalculadora = findViewById(R.id.buttonCalculadora);
        ButtonImaginarios = findViewById(R.id.buttonImaginario);
        ButtonGraficos2D = findViewById(R.id.buttonGraficos);
        ButtonGraficos2DTarea = findViewById(R.id.buttonGraficosTarea);
        ButtonEnviar = findViewById(R.id.buttonEnviar);
        ButtonBD = findViewById(R.id.buttonBD);
        ButtonBDTarea = findViewById(R.id.buttonBDTarea);
        ButtonWebService = findViewById(R.id.buttonWebService);
        ButtonWebServiceCompras = findViewById(R.id.buttonWebServiceCompras);
        ButtonWebServicePersons = findViewById(R.id.buttonWebServicePersons);
        ButtonWebServicePersonsPost = findViewById(R.id.buttonWebServicePersonsInsert);
        ButtonWebService4 = findViewById(R.id.buttonWebService4);

        PrimerParcial = findViewById(R.id.PrimerParcial);
        FormWS = findViewById(R.id.formws);


        ButtonSalir = findViewById(R.id.ButtonSalir);

        dataBase = new DataBase(MainActivity.this, "BDPersonas", null, 1);

        ButtonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ConexionActivity.class);
//                intent.putExtra("MiCadena", "Hola a todos");
//                intent.putExtra("MiEntero", 70);
//                startActivity(intent);

                Oper oper = new Oper(5,2);
                Intent intent = new Intent(MainActivity.this, ConexionActivity.class);
                intent.putExtra("MiObjeto", oper);
                startActivity(intent);
            }
        });

        ButtonBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db = dataBase.getWritableDatabase();
                db.execSQL("INSERT INTO personas(ci,paterno,materno,nombre) VALUES('123','Perez', 'Lozano', 'Pedro');");

                String SQL = "select * from personas;";

                db = dataBase.getReadableDatabase();
                Cursor cursor = db.rawQuery(SQL, null);
                if(cursor.moveToFirst()){
                    do{
                        String paterno = cursor.getString(3);
                        Toast.makeText(MainActivity.this, paterno, Toast.LENGTH_SHORT).show();
                    }while(cursor.moveToNext());
                }
            }
        });
        ButtonOperaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OperacionesActivity.class);
                startActivity(intent);
            }
        });

        ButtonWebService4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebService4Activity.class);
                startActivity(intent);
            }
        });

        FormWS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FormActivity.class);
                startActivity(intent);
            }
        });


        PrimerParcial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, _1er_parcial.class);
                startActivity(intent);
            }
        });
        ButtonWebServicePersonsPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postPersona();
            }
        });

        ButtonWebServicePersons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataPersons();
            }
        });


        ButtonWebServiceCompras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataCompras();
            }
        });

        ButtonWebService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });


        ButtonBDTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FormActivity.class);
                startActivity(intent);
            }
        });

//        ButtonEscalado.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setContentView(new Escalado(MainActivity.this));
//            }
//        });

        ButtonGraficos2D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(new Graficos2D(MainActivity.this));
            }
        });

        ButtonGraficos2DTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(new Graficos2DTarea(MainActivity.this));
            }
        });

        ButtonSegundoGrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ecuaciones.class);
                startActivity(intent);
            }
        });

        ButtonImaginarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ComplejosActivity.class);
                startActivity(intent);
            }
        });

        ButtonCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
                startActivity(intent);
            }
        });
        ButtonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void postPersona(){
//        String URL_WS = "http://192.168.1.8/mobile/";
        String URL_WS = "http://192.168.1.16/mobile/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_WS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebServiceAPI webServiceApi = retrofit.create(WebServiceAPI.class);
        Call<WSPersona> personaCall = webServiceApi.postPersona(new WSPersona("a","b","c","123"));
        personaCall.enqueue(new Callback<WSPersona>() {
            @Override
            public void onResponse(Call<WSPersona> call, Response<WSPersona> response) {
                if (!response.isSuccessful()) {
                    String error = "Ha ocurrido un error. Contacte al administrador";
                    if (response.errorBody()
                            .contentType()
                            .subtype()
                            .equals("json")) {
                    } else {
                        try {
                            Log.d("LoginActivity", response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return;
                }
            }

            @Override
            public void onFailure(Call<WSPersona> call, Throwable t) {

            }
        });
    }
    public void getDataCompras(){
        String URL_WS = "http://192.168.1.14/mobile/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_WS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebServiceAPI webServiceApi = retrofit.create(WebServiceAPI.class);
        final Call<List<WSCompras>> call = webServiceApi.getCompras();
        call.enqueue(new Callback<List<WSCompras>>() {
            @Override
            public void onResponse(Call<List<WSCompras>> call, Response<List<WSCompras>> response) {
                if(response.isSuccessful()){
                    listDataCompras = response.body();
                    Toast.makeText(MainActivity.this, listDataCompras.get(0).getCantidad(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "REVISE SU SERVICIO DE INTERNET", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WSCompras>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getDataPersons(){
        String URL_WS = "http://192.168.1.16/mobile/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_WS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebServiceAPI webServiceApi = retrofit.create(WebServiceAPI.class);
        final Call<List<WSPersons>> call = webServiceApi.getPersons();
        call.enqueue(new Callback<List<WSPersons>>() {
            @Override
            public void onResponse(Call<List<WSPersons>> call, Response<List<WSPersons>> response) {
                if(response.isSuccessful()){
                    listDataPersons = response.body();
                    Toast.makeText(MainActivity.this, listDataPersons.get(0).getPaterno(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "REVISE SU SERVICIO DE INTERNET", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WSPersons>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getData(){


        String URL_WS = "https://jsonplaceholder.typicode.com/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_WS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebServiceAPI webServiceApi = retrofit.create(WebServiceAPI.class);
        final Call<List<WSAlbums>> call = webServiceApi.getAlbums();
        call.enqueue(new Callback<List<WSAlbums>>() {
            @Override
            public void onResponse(Call<List<WSAlbums>> call, Response<List<WSAlbums>> response) {
                if(response.isSuccessful()){
                    ListData = response.body();
                    Toast.makeText(MainActivity.this, ListData.get(0).getTitle(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "REVISE SU SERVICIO DE INTERNET", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WSAlbums>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();
            }
        });
    }


}