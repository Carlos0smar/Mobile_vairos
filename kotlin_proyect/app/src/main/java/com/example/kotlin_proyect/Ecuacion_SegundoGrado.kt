package com.example.kotlin_proyect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Ecuacion_SegundoGrado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecuacion_segundo_grado)

        val Button_Solucion = findViewById<Button>(R.id.button_solucion)
        val text_a = findViewById<EditText>(R.id.editText_a)
        val text_b = findViewById<EditText>(R.id.editText_b)
        val text_c = findViewById<EditText>(R.id.editText_c)
        val sol = findViewById<TextView>(R.id.textViewS)



        Button_Solucion.setOnClickListener(){
            val val_a = (text_a.getText().toString()).toFloat()
            val val_b = (text_b.getText().toString()).toFloat()
            val val_c = (text_c.getText().toString()).toFloat()
            val resul = Ecuacion(val_a , val_b, val_c)

            sol.text=resul.solucion()


        }
    }
}