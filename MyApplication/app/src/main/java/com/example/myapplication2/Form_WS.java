package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Form_WS extends AppCompatActivity {
    Button ButtonGet, ButtonPost;
    EditText TextCi, TextPaterno, TextMaterno, TextNombre;
    List<WSPersons> listDataPersons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_ws);
        ButtonGet = findViewById(R.id.buttonGet);
        ButtonPost = findViewById(R.id.buttonPost);
        TextCi = findViewById(R.id.editTextCI);
        TextPaterno = findViewById(R.id.editTextPATERNO);
        TextMaterno = findViewById(R.id.editTextMATERNO);
        TextNombre = findViewById(R.id.editTextNOMBRE);

        ButtonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ci = TextCi.getText().toString();
                String materno = TextMaterno.getText().toString();
                String paterno = TextPaterno.getText().toString();
                String nombre = TextNombre.getText().toString();

                postPersona(ci, materno, paterno, nombre);

            }
        });

        ButtonGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataPersons();
            }
        });
    }

    public void getDataPersons(){
        String URL_WS = "http://192.168.1.16/mobile/primer.php";
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
                    Toast.makeText(Form_WS.this, listDataPersons.get(0).getPaterno(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Form_WS.this, "REVISE SU SERVICIO DE INTERNET", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WSPersons>> call, Throwable t) {
                Toast.makeText(Form_WS.this, "Error: "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void postPersona(String ci, String materno, String paterno, String nombre){
//        String URL_WS = "http://192.168.1.8/mobile/";
        String URL_WS = "http://192.168.1.16/mobile/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_WS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebServiceAPI webServiceApi = retrofit.create(WebServiceAPI.class);
        Call<WSPersona> personaCall = webServiceApi.postPersona(new WSPersona( ci , paterno,materno,nombre));
//        Call<WSPersona> personaCall = webServiceApi.postPersona(new WSPersona( "asd" , "paterno","materno","nombre"));

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
}