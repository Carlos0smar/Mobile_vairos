package com.example.kotlin_proyect


import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class BaseDatos1 (context: Context): SQLiteOpenHelper(context,BaseDatos1.NOMBRE_BASE_DATOS,null,BaseDatos1.VERSION_BASE_DATOS){
    override fun onCreate(db: SQLiteDatabase?) {
        val CREAR_TABLA = "CREATE TABLE $NOMBRE_TABLA ($ID INTEGER PRIMARY KEY AUTOINCREMENT,$a_ INTEGER,$b_ INTEGER,$n_ INTEGER,$resultado_ FLOAT);"
        try {
            db?.execSQL(CREAR_TABLA)
            Log.d("Datos","---> correcto")
        } catch (e: Exception) {
            // Ocurrió un error durante la creación de la tabla
            e.printStackTrace()
            Log.d("Datos","---> INCORRECTO")

        }

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val BORRAR_TABLA = "DROP TABLE IF EXISTS $NOMBRE_TABLA"
        db?.execSQL(BORRAR_TABLA)
        onCreate(db)
    }

    fun addLugar(lugares: Lugares):Boolean{
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(a_,lugares.a)
        values.put(b_,lugares.b)
        values.put(n_,lugares.n)
        values.put(resultado_,lugares.resultado)
        val _success = db.insert(NOMBRE_TABLA,null,values)
        db.close()
        return (Integer.parseInt("$_success") != -1)
    }

    @SuppressLint("Range")
    fun getLugar(_id: Int): Lugares{
        val lugares = Lugares()
        val db = this.readableDatabase
        val selectQuery = "SELECT * FROM $NOMBRE_TABLA WHERE $ID = $_id"
        val cursor = db.rawQuery(selectQuery, null)
        if(cursor != null){
            cursor.moveToFirst()
            while(cursor.moveToNext()){
                lugares.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID)))
                lugares.a = cursor.getString(cursor.getColumnIndex(a_)).toInt()
                lugares.b = cursor.getString(cursor.getColumnIndex(b_)).toInt()
                lugares.n = cursor.getString(cursor.getColumnIndex(n_)).toInt()
                lugares.resultado = cursor.getString(cursor.getColumnIndex(resultado_)).toFloat()

            }
        }
        cursor.close()
        return lugares
    }

    val lugar: List<Lugares> @SuppressLint("Range")
    get(){
        val lugaresList = ArrayList<Lugares>()
        val db = this.readableDatabase
        val selectQuery = "SELECT * FROM $NOMBRE_TABLA"
        val cursor = db.rawQuery(selectQuery, null)
        if(cursor != null){
            cursor.moveToFirst()
            while(cursor.moveToNext()){
                val lugares = Lugares()
                lugares.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID)))
                lugares.a = cursor.getString(cursor.getColumnIndex(a_)).toInt()
                lugares.b = cursor.getString(cursor.getColumnIndex(b_)).toInt()
                lugares.n = cursor.getString(cursor.getColumnIndex(n_)).toInt()
                lugares.resultado = cursor.getString(cursor.getColumnIndex(resultado_)).toFloat()
                lugaresList.add(lugares)
            }
        }
        cursor.close()
        return lugaresList
    }

    fun updateLugar(lugares: Lugares): Boolean{
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(a_,lugares.a)
        values.put(b_,lugares.b)
        values.put(n_,lugares.n)
        values.put(resultado_,lugares.resultado)
        val _success = db.update(NOMBRE_TABLA,values,ID+"=?",arrayOf(lugares.id.toString())).toLong()
        db.close()
        return Integer.parseInt("$_success") != -1
    }

    fun deleteLugar(_id: Int): Boolean{
        val db = this.writableDatabase
        val _success = db.delete(NOMBRE_TABLA,ID+"=?",arrayOf(_id.toString())).toLong()
        db.close()
        return Integer.parseInt("$_success") != -1
    }

    fun deleteAllLugares(): Boolean {
        val db = this.writableDatabase
        val _success = db.delete(NOMBRE_TABLA, null, null).toLong()
        db.close()
        return Integer.parseInt("$_success") != -1
    }

    companion object{
        private val VERSION_BASE_DATOS = 1
        private val NOMBRE_BASE_DATOS = "basedatosmovil"
        private val NOMBRE_TABLA = "resta_sucesiva"
        private val ID = "id"
        private val a_ = "a"
        private val b_ = "b"
        private val n_ = "n"
        private val resultado_ = "resultado"
    }
}