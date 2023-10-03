package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ConexionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conexion);

//        Intent intent = getIntent();
//        String dato1 = intent.getStringExtra("MiCadena");
//        int dato2 = intent.getIntExtra("MiEntero", 0);
//        Toast.makeText(ConexionActivity.this, dato1+ " " + dato2, Toast.LENGTH_SHORT).show();

        Intent intent = getIntent();
        Oper oper2 = (Oper)intent.getSerializableExtra("MiObjeto");
        Toast.makeText(ConexionActivity.this, "Resultado: " + oper2.suma(),Toast.LENGTH_SHORT).show();

        return 0;
    }
}