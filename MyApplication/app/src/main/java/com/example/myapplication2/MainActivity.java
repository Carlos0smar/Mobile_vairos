package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
    Button ButtonOperaciones, ButtonSalir, ButtonSegundoGrado, ButtonImaginarios, ButtonCalculadora,
            ButtonGraficos2D, ButtonGraficos2DTarea, ButtonEscalado, ButtonEnviar, ButtonBD, ButtonBDTarea,
            ButtonWebService;
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



        ButtonEscalado = findViewById(R.id.buttonEscalado);


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

        ButtonEscalado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(new Escalado(MainActivity.this));
            }
        });

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