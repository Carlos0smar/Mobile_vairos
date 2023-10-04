package com.example.kotlin_proyect

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Calculadora_Pro_Activity : AppCompatActivity() {
    private var operator = ""
//    private val current_number = ""
    var last_number = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora_pro)


        val button0 = findViewById<Button>(R.id.button0)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)
        val buttonC = findViewById<Button>(R.id.buttonC)
        val buttonSum = findViewById<Button>(R.id.buttonSum)
        val buttonRes = findViewById<Button>(R.id.buttonRes)
        val buttonDiv = findViewById<Button>(R.id.buttonDiv)
        val buttonMul = findViewById<Button>(R.id.buttonMul)
        val buttonIgual = findViewById<Button>(R.id.buttonIgual)
        val ShowResul = findViewById<TextView>(R.id.ShowResul)
        ShowResul.setText("0")

        val nums = ArrayList<Button>()
        nums.add(button0)
        nums.add(button1)
        nums.add(button2)
        nums.add(button3)
        nums.add(button4)
        nums.add(button5)
        nums.add(button6)
        nums.add(button7)
        nums.add(button8)
        nums.add(button9)

        for (b in nums) {
            b.setOnClickListener { View: View? ->
                if (ShowResul.getText().toString() != "0") {
                    ShowResul.setText(ShowResul.getText().toString() + b.text.toString())
                } else {
                    ShowResul.setText(b.text.toString())
                }
            }
        }

        val opers = ArrayList<Button>()
        opers.add(buttonSum)
        opers.add(buttonRes)
        opers.add(buttonMul)
        opers.add(buttonDiv)
        for (b in opers) {
            b.setOnClickListener { view: View? ->
                last_number = ShowResul.getText().toString().toInt()
                operator = b.text.toString()
                ShowResul.setText("0")
            }
        }

        buttonC.setOnClickListener(View.OnClickListener { view: View? ->
            last_number = 0
            ShowResul.setText("0")
        })

        val view = null
        buttonIgual.setOnClickListener {
            val secondNum: Int = ShowResul.text.toString().toInt()
            if(secondNum == 0 && operator == "/"){

                Toast.makeText(this@Calculadora_Pro_Activity, "Introduzca un número válido para la división", Toast.LENGTH_SHORT).show()
            }else{
                val result: Double = when (operator) {
                    "/" -> (last_number / secondNum).toDouble()
                    "*" -> (last_number * secondNum).toDouble()
                    "+" -> (last_number + secondNum).toDouble()
                    "-" -> (last_number - secondNum).toDouble()
                    else -> (last_number + secondNum).toDouble()
                }
                ShowResul.text = result.toString()
            }
        }

//        return 0
    }

}