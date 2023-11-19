package com.example.kotlin_proyect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Segundo_parcial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segundo_parcial)
        val Cubo = findViewById<Button>(R.id.buttonCubo)


        Cubo.setOnClickListener(View.OnClickListener { setContentView(cubo(this@Segundo_parcial)) })
    }



}