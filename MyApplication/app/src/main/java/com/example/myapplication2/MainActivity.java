package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DataBase dataBase;
    SQLiteDatabase db;
    Button ButtonOperaciones, ButtonSalir, ButtonSegundoGrado, ButtonImaginarios, ButtonCalculadora,
            ButtonGraficos2D, ButtonGraficos2DTarea, ButtonEscalado, ButtonEnviar, ButtonBD, ButtonBDTarea;
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
}