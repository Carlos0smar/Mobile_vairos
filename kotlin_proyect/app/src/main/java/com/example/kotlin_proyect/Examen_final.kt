package com.example.kotlin_proyect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Examen_final : AppCompatActivity() {
//    Lo de sqlite se encuentra en la siguientes carpetas:
//    Lugares.kt, BaseDatos.kt, DB_activity

//    Lo de webservices esta en:
//    Wscompras,wspersons, wsservicios, wsventas, webservicesApi, mainAcitvity

//    ResponseLugar.kt, webservicesApi, MainActivity
//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_examen_final)

        val Button_Eje1 = findViewById<Button>(R.id.button_Eje1)
//        val Button_Eje2 = findViewById<Button>(R.id.button_Eje2)
//        val Button_Eje3 = findViewById<Button>(R.id.button_Eje3)
//        val Button_Eje4 = findViewById<Button>(R.id.button_Eje4)
//       val editB = findViewById<EditText>(R.id.editB)
//       val textA = findViewById<TextView>(R.id.textA)
//      usar como ejemplo practtica_1_course


        Button_Eje1.setOnClickListener(View.OnClickListener { setContentView(cubo(this@Examen_final)) })
//
//        ButtonTriangulo_color.setOnClickListener(View.OnClickListener { setContentView(triangulo_color(this@Examen_final)) })


//        Button_Eje1.setOnClickListener(){
//            val intent = Intent(this@Examen_final, cubo::class.java)
//            startActivity(intent)
//
//        }
//
//        Button_Eje2.setOnClickListener(){
//            val intent = Intent(this@Examen_final, DB_Activity::class.java)
//            startActivity(intent)
//
//        }
//
//        Button_Eje3.setOnClickListener(){
//            val intent = Intent(this@Examen_final, DB_Activity::class.java)
//            startActivity(intent)
//
//        }
//
//        Button_Eje4.setOnClickListener(){
//            val intent = Intent(this@Examen_final, DB_Activity::class.java)
//            startActivity(intent)
//
//        }
    }
}