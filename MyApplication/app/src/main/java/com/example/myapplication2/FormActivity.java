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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        DataBase dataBase;
        SQLiteDatabase db;
        Button ButtonGuardar, ButtonMostrar, ButtonBD;
        EditText editnombre, editci, editpaterno, editmaterno;

        ButtonGuardar = findViewById(R.id.buttonGUARDAR);
        ButtonMostrar = findViewById(R.id.buttonMOSTRAR);
        editci = findViewById(R.id.editCI);
        editmaterno = findViewById(R.id.editMATERNO);
        editnombre = findViewById(R.id.editNOMBRE);
        editpaterno = findViewById(R.id.editPATERNO);



        ButtonBD = findViewById(R.id.buttonBD);

        dataBase = new DataBase(FormActivity.this, "BDEjepersonas", null, 1);


//        ButtonGuardar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(FormActivity.this, DataBase.class);
//                intent.putExtra("CI", editci.getText());
//                intent.putExtra("NOMBRE", editnombre.getText() );
//                intent.putExtra("PATERNO", editpaterno.getText());
//                intent.putExtra("MATERNO", editmaterno.getText());
//
//                startActivity(intent);
//
//            }
//        });
        ButtonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db = dataBase.getWritableDatabase();
                db.execSQL("INSERT INTO personas(ci,paterno,materno,nombre) VALUES('editci.getText()','editpaterno.getText()', 'editmaterno.getText()', 'editnombre.getText()');");

                String SQL = "select * from personas;";

                db = dataBase.getReadableDatabase();
                Cursor cursor = db.rawQuery(SQL, null);
                if(cursor.moveToFirst()){
                    do{
                        String paterno = cursor.getString(3);
                        Toast.makeText(FormActivity.this, paterno, Toast.LENGTH_SHORT).show();
                    }while(cursor.moveToNext());
                }
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
                        String paterno = cursor.getString(3);
                        Toast.makeText(FormActivity.this, paterno, Toast.LENGTH_SHORT).show();
                    }while(cursor.moveToNext());
                }
            }
        });


    }
}