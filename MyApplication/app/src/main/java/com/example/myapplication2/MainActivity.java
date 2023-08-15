package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button ButtonOperaciones, ButtonSalir, ButtonSegundoGrado, ButtonImaginarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonOperaciones = findViewById(R.id.ButtonOperaciones);
        ButtonSegundoGrado = findViewById(R.id.buttonSegundoGrado);
        ButtonImaginarios = findViewById(R.id.buttonImaginario);


        ButtonSalir = findViewById(R.id.ButtonSalir);

        ButtonOperaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OperacionesActivity.class);
                startActivity(intent);
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
        ButtonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}