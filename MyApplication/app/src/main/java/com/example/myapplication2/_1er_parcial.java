package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class _1er_parcial extends AppCompatActivity {

    Button eje1, eje3, eje2, buttonS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1er_parcial);

        eje1 = findViewById(R.id.buttonP1);
        eje3 = findViewById(R.id.buttonP3);
        eje2 = findViewById(R.id.buttonP2);
        buttonS = findViewById(R.id.buttonS);


        eje1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_1er_parcial.this, Ejercicio1.class);
                startActivity(intent);
            }
        });

        eje2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_1er_parcial.this, Ejercicio1.class);
                startActivity(intent);
            }
        });
        eje3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(new Ejercicio3(_1er_parcial.this));
            }
        });


        buttonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        return 0;
    }
}