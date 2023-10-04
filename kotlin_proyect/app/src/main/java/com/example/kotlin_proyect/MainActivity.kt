package com.example.kotlin_proyect

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ButtonCalculadora = findViewById<Button>(R.id.buttonCalculadora)
        val ButtonGraficos = findViewById<Button>(R.id.buttonGraficos)
        val ButtonDB =findViewById<Button>(R.id.buttonDB)
        val ButtonFinalizar = findViewById<Button>(R.id.buttonFinalizar)

        ButtonCalculadora.setOnClickListener(){
            val intent = Intent(this@MainActivity, CalculadoraActivity::class.java)
            startActivity(intent)
        }

//        ButtonGraficos.setOnClickListener(){
//            fun onClick(v: View?) {
//                setContentView(Graficos(this@MainActivity))
//            }
//        }

        ButtonDB.setOnClickListener(){
            val intent = Intent(this@MainActivity, DB_Activity::class.java)
            startActivity(intent)

        }

        ButtonFinalizar.setOnClickListener(){
            fun onClick(v: View?) { finish() }
        }
    }




}