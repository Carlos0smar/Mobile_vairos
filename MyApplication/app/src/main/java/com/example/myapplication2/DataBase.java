package com.example.myapplication2;

import static android.content.Intent.getIntent;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {

    String SQL_CREATE = "CREATE TABLE personas(id INTEGER PRIMARY KEY AUTOINCREMENT, ci VARCHAR(20), paterno VARCHAR(40), materno VARCHAR(40), nombre VARCHAR(60));";

    String SQL_Drop = "DROP TABLE IF EXISTS personas;";

//    Intent intent = getIntent();
//    String ci = intent.getStringExtra("CI");
//    String nombre = intent.getStringExtra("NOMBRE");
//    String paterno = intent.getStringExtra("PATERNO");
//    String materno = intent.getStringExtra("MATERNO");


    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_Drop);
        db.execSQL(SQL_CREATE);
    }

}
