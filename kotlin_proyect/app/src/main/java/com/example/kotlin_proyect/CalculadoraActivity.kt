package com.example.kotlin_proyect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val ButtonSuma = findViewById<Button>(R.id.buttonSuma)
        val ButtonResta = findViewById<Button>(R.id.buttonResta)
        val ButtonDivision = findViewById<Button>(R.id.buttonDivision)
        val ButtonMultiplicacion = findViewById<Button>(R.id.buttonMultiplicacion)
        val textA = findViewById<EditText>(R.id.editTextA)
        val textB = findViewById<EditText>(R.id.editTextB)
        val resultado = findViewById<TextView>(R.id.textViewOperacion)
        val oper = Operaciones()

        ButtonSuma.setOnClickListener{
            oper.a = Integer.parseInt(textA.text.toString())
            oper.b = Integer.parseInt(textB.text.toString())
            val resul = oper.suma()
            resultado.setText(resul.toString())
        }

        ButtonResta.setOnClickListener{
//            val oper = Operaciones()
            oper.a = Integer.parseInt(textA.text.toString())
            oper.b = Integer.parseInt(textB.text.toString())
            val resul = oper.resta()
            resultado.setText(resul.toString())
        }

        ButtonMultiplicacion.setOnClickListener{
//            val oper = Operaciones()
            oper.a = Integer.parseInt(textA.text.toString())
            oper.b = Integer.parseInt(textB.text.toString())
            val resul = oper.division()
            resultado.setText(resul.toString())
        }

        ButtonDivision.setOnClickListener{
//            val oper = Operaciones()
            oper.a = Integer.parseInt(textA.text.toString())
            oper.b = Integer.parseInt(textB.text.toString())
            val resul = oper.multiplicacion()
            resultado.setText(resul.toString())
        }
    }
}