package com.example.kotlin_proyect

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ButtonCalculadora = findViewById<Button>(R.id.buttonCalculadora)
        val ButtonGraficos = findViewById<Button>(R.id.buttonGraficos)
        val ButtonDB =findViewById<Button>(R.id.buttonDB)
        val ButtonFinalizar = findViewById<Button>(R.id.buttonFinalizar)
        val ButtonCalculadora_Pro = findViewById<Button>(R.id.buttonCalculadora_Pro)
        val ButtonEcuaciones_2do_grado = findViewById<Button>(R.id.buttonEcuaciones_segundo_grado)
        val ButtonTriangulo_color = findViewById<Button>(R.id.buttonTriangulo_color)
        val ButtonTriangulo_escalado = findViewById<Button>(R.id.buttonTriangulo_escalado)
        val ButtonRectangulo_escalado = findViewById<Button>(R.id.buttonRectangulo_escalado)
        val ButtonGraficador = findViewById<Button>(R.id.buttonGraficador)



        ButtonEcuaciones_2do_grado.setOnClickListener(){
            val intent = Intent(this@MainActivity, Ecuacion_SegundoGrado::class.java)
            startActivity(intent)
        }



        ButtonCalculadora.setOnClickListener(){
            val intent = Intent(this@MainActivity, CalculadoraActivity::class.java)
            startActivity(intent)
        }

        ButtonCalculadora_Pro.setOnClickListener(){
            val intent = Intent(this@MainActivity, Calculadora_Pro_Activity::class.java)
            startActivity(intent)
        }


        ButtonGraficos.setOnClickListener(View.OnClickListener { setContentView(Graficos(this@MainActivity)) })

        ButtonTriangulo_color.setOnClickListener(View.OnClickListener { setContentView(triangulo_color(this@MainActivity)) })

        ButtonTriangulo_escalado.setOnClickListener(View.OnClickListener { setContentView(triangulo_scalado(this@MainActivity)) })

        ButtonRectangulo_escalado.setOnClickListener(View.OnClickListener { setContentView(rectangulo_escalado(this@MainActivity)) })

        ButtonGraficador.setOnClickListener(View.OnClickListener { setContentView(Graficador(this@MainActivity)) })



        ButtonDB.setOnClickListener(){
            val intent = Intent(this@MainActivity, DB_Activity::class.java)
            startActivity(intent)

        }


        ButtonFinalizar.setOnClickListener(){
            fun onClick(v: View?) { finish() }
        }
    }




}