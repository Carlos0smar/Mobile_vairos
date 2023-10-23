package com.example.kotlin_proyect

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var listDataPersons: List<WSPersons> = ArrayList()
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
        val ButtonWSA_1_GET = findViewById<Button>(R.id.buttonWSA_1_GET)




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

        ButtonWSA_1_GET.setOnClickListener(){
            getDataPersons()
        }


    }
    fun getDataPersons() {
        val URL_WS = "http://192.168.1.18:80/mobile/"
        val retrofit = Retrofit.Builder()
            .baseUrl(URL_WS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val webServiceApi: WebServicesAPI = retrofit.create(WebServicesAPI::class.java)
        val call: Call<List<WSPersons>> = webServiceApi.getPersons()
        call.enqueue(object : Callback<List<WSPersons>> {
            override fun onResponse(
                call: Call<List<WSPersons>>,
                response: Response<List<WSPersons>>
            ) {
                if (response.isSuccessful) {
                    listDataPersons = response.body() as List<WSPersons>
                    Toast.makeText(
                        this@MainActivity,
                        listDataPersons[0].paterno,
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "REVISE SU SERVICIO DE INTERNET",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<WSPersons>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: " + t.message, Toast.LENGTH_SHORT).show()
            }


        })
    }



}