package com.example.kotlin_proyect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.w3c.dom.Text

class DB_Activity : AppCompatActivity() {
    var dbHandler: BaseDatos? = null
    var listTasks: List<Lugares> = ArrayList<Lugares>()
    override fun onCreate(savedInstanceState: Bundle?) {

        val ButtonCear = findViewById<Button>(R.id.buttonCrear)
        val ButtonMostrar_todo = findViewById<Button>(R.id.buttonMostrar)
        val ButtonMostrar_unico = findViewById<Button>(R.id.buttonMostrar_unico)
        val nombre_ = findViewById<EditText>(R.id.editTextNombre)
        val descripcion_ = findViewById<EditText>(R.id.editTextDescrip)
        val latitud_ = findViewById<EditText>(R.id.editTextLatid)
        val longitud_ = findViewById<EditText>(R.id.editTextLongi)
        val text_id = findViewById<EditText>(R.id.editTextID)
        val ButtonDelete_lugar = findViewById<Button>(R.id.buttonDelete_lugar)


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db)

        dbHandler = BaseDatos(this)
        var success: Boolean = false
        val lugares: Lugares = Lugares()


        ButtonCear.setOnClickListener(){
            var nombre = nombre_.text.toString()
            var descripcion = descripcion_.text.toString()
            var latitud = latitud_.text.toString()
            var longitud = longitud_.text.toString()

            lugares.nombre = nombre
            lugares.descripcion = descripcion
            lugares.latitud = latitud.toFloat()
            lugares.longitud = longitud.toFloat()
            success = dbHandler?.addLugar(lugares) as Boolean

        }

        ButtonCear.setOnClickListener(){
            var nombre = nombre_.text.toString()
            var descripcion = descripcion_.text.toString()
            var latitud = latitud_.text.toString()
            var longitud = longitud_.text.toString()

            lugares.nombre = nombre
            lugares.descripcion = descripcion
            lugares.latitud = latitud.toFloat()
            lugares.longitud = longitud.toFloat()
            success = dbHandler?.addLugar(lugares) as Boolean

        }

        ButtonMostrar_todo.setOnClickListener(){
            var nombre = nombre_.text.toString()
            var descripcion = descripcion_.text.toString()
            var latitud = latitud_.text.toString()
            var longitud = longitud_.text.toString()

            lugares.nombre = nombre
            lugares.descripcion = descripcion
            lugares.latitud = latitud.toFloat()
            lugares.longitud = longitud.toFloat()
            success = dbHandler?.addLugar(lugares) as Boolean

        }


        ButtonMostrar_unico.setOnClickListener(){
            var id = text_id.text.toString()
            var id_ = Integer.parseInt(id)
            val success = dbHandler?.getLugar(id_)
            if (success != null) {
                Toast.makeText(this@DB_Activity, "Nombre: ${success.nombre}\nDescripción: ${success.descripcion}\nLatitud: ${success.latitud}\nLongitud: ${success.longitud}", Toast.LENGTH_SHORT).show()
            }

        }

        ButtonDelete_lugar.setOnClickListener(){
            var id = text_id.text.toString()
            var id_ = Integer.parseInt(id)
            success = dbHandler?.deleteLugar(id_) as Boolean
        }

    }
}