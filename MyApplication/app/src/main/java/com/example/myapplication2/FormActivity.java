package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    DataBase dataBase;
    SQLiteDatabase db;
    Button ButtonGuardar, ButtonMostrar;
    EditText editnombre, editci, editpaterno, editmaterno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        ButtonGuardar = findViewById(R.id.buttonGUARDAR);
        ButtonMostrar = findViewById(R.id.buttonMOSTRAR);
        editci = findViewById(R.id.editCI);
        editmaterno = findViewById(R.id.editMATERNO);
        editnombre = findViewById(R.id.editNOMBRE);
        editpaterno = findViewById(R.id.editPATERNO);

        dataBase = new DataBase(FormActivity.this, "DB_Persona", null, 1);

        ButtonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ci = editci.getText().toString();
                String paterno = editpaterno.getText().toString();
                String materno = editmaterno.getText().toString();
                String nombre = editnombre.getText().toString();
                editci.setText("");
                editmaterno.setText("");
                editpaterno.setText("");
                editnombre.setText("");

                db = dataBase.getWritableDatabase();
                db.execSQL("INSERT INTO personas(ci,paterno,materno,nombre) VALUES('"+ ci + "', '" + paterno + "', '"+ materno + "', '" + nombre + "');");
            }
        });

        ButtonMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String SQL = "select * from personas;";
                db = dataBase.getReadableDatabase();
                Cursor cursor = db.rawQuery(SQL, null);
                if(cursor.moveToFirst()){
                    do{
                        String paterno = cursor.getString(2);
                        String materno = cursor.getString(3);
                        String nombre = cursor.getString(4);
                        String ci = cursor.getString(1);

                        String Linea = ci + " " + nombre +  " " + paterno +  " " + materno ;
                        Toast.makeText(FormActivity.this, Linea, Toast.LENGTH_SHORT).show();
                    }while(cursor.moveToNext());
                }
            }
        });
        return 0;
    }
}