package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Examen_Final extends AppCompatActivity {

    Button Ejercicio_1, Ejercicio_2, Ejercicio_3;
//    TextView TextViewResultado;
//    EditText editTextA, editTextB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen_final);

//        editTextA = findViewById(R.id.editTextA);
        Ejercicio_1 = findViewById(R.id.button_eje1);
        Ejercicio_2 = findViewById(R.id.button_eje2);
//        Ejercicio_3 = findViewById(R.id.ButtonOperaciones);
//        Ejercicio_4 = findViewById(R.id.ButtonOperaciones);


//        ButtonGraficos2DTarea.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setContentView(new Graficos2DTarea(Examen_Final.this));
//            }
//        });


        Ejercicio_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Examen_Final.this, eje_1_div.class);
                startActivity(intent);
            }
        });
//
//
        Ejercicio_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Examen_Final.this, WebService4Activity.class);
                startActivity(intent);
            }
        });
//
//
//        Ejercicio_3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Examen_Final.this, Ecuaciones.class);
//                startActivity(intent);
//            }
//        });
//
//
//        Ejercicio_4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Examen_Final.this, Ecuaciones.class);
//                startActivity(intent);
//            }
//        });


    }
}