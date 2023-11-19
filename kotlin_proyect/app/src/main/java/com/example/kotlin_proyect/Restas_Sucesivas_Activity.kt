package com.example.kotlin_proyect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Restas_Sucesivas_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restas_sucesivas)

        val Calcular = findViewById<Button>(R.id.button_CALCULAR)
        val val_a = findViewById<EditText>(R.id.editTextText_A)
        val val_b = findViewById<EditText>(R.id.editTextText_B)




        Calcular.setOnClickListener(){
            val dividendo = val_a.text.toString()
            val divisor = val_b.text.toString()

            val dividendo_ : Int = dividendo.toInt()
            val divisor_ : Int = divisor.toInt()


            restas_sucesivas(dividendo_, divisor_)
//            val resultado = restas_sucesivas.obtenerResultado()


        }



    }
}