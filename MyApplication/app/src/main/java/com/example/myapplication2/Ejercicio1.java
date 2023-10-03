package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ejercicio1 extends AppCompatActivity {
    Button validar;
    TextView salida ;
    EditText entrada ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        TextView ShowResul ;
        validar = findViewById(R.id.buttonV);

        salida = findViewById(R.id.textViewSalida);
        entrada = findViewById(R.id.editTextTextEntrada);
        validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valor = entrada.getText().toString();


                String[] palabras = valor.split(" ");

                boolean todasMayusculas = true;
                for (String palabra : palabras) {
                    if (!Character.isUpperCase(palabra.charAt(0))) {
                        todasMayusculas = false;
                        break;
                    }
                }

                if (todasMayusculas) {
                    salida.setText("Correcto");
                } else {
                    salida.setText("Incorrecto");

                }
            }
        });
        return 0;
    }
}