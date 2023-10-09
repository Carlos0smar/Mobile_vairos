package com.example.kotlin_proyect

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CalculadoraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val ButtonSuma = findViewById<Button>(R.id.buttonSuma);
        val ButtonResta = findViewById<Button>(R.id.buttonResta);
        val ButtonDivision = findViewById<Button>(R.id.buttonDivision);
        val ButtonMultiplicacion = findViewById<Button>(R.id.buttonMultiplicacion);
        val textA = findViewById<EditText>(R.id.editTextA);
        val textB = findViewById<EditText>(R.id.editTextB);
        val resultado = findViewById<TextView>(R.id.textViewOperacion);

        ButtonSuma.setOnClickListener{
            val oper = Operaciones()

            oper.a = Integer.parseInt(textA.text.toString())
            oper.b = Integer.parseInt(textB.text.toString())
            val resul = oper.suma()
            resultado.setText(resul.toString())
        }

        ButtonResta.setOnClickListener{
            val oper = Operaciones()
            oper.a = Integer.parseInt(textA.text.toString())
            oper.b = Integer.parseInt(textB.text.toString())
            val resul = oper.resta()
            resultado.setText(resul.toString())
        }

        ButtonMultiplicacion.setOnClickListener{
            val oper = Operaciones()
            oper.a = Integer.parseInt(textA.text.toString())
            oper.b = Integer.parseInt(textB.text.toString())
            val resul = oper.multiplicacion()
            resultado.setText(resul.toString())
        }

        ButtonDivision.setOnClickListener{
            val oper = Operaciones()
            val n_a = Integer.parseInt(textA.text.toString())
            val n_b = Integer.parseInt(textB.text.toString())

            if(n_b == 0){
                Toast.makeText(this@CalculadoraActivity, "Introduzca un número válido para la división", Toast.LENGTH_SHORT).show()
            }else{
                oper.a = n_a
                oper.b = n_b
                val resul = oper.division()
                resultado.setText(resul.toString())

            }
        }
    }
}