package com.example.kotlin_proyect

import android.os.Bundle
import  android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class practica_1_course : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practica1_course)
        val ButtonCalcular = findViewById<Button>(R.id.buttonCalcular)

        val editA = findViewById<EditText>(R.id.editA)
        val editB = findViewById<EditText>(R.id.editB)
        val textA = findViewById<TextView>(R.id.textA)
        val textB = findViewById<TextView>(R.id.textB)
        val textA_SUM = findViewById<TextView>(R.id.textA_sum)
        val textB_SUM = findViewById<TextView>(R.id.textB_sum)
        val textResultado = findViewById<TextView>(R.id.textResul)


        ButtonCalcular.setOnClickListener(){
           val NumA: Int = editA.text.toString().toInt()
            val NumB_bd: Int = editA.text.toString().toInt()

            val NumA_show: String = editA.text.toString()
            val NumB: String = editB.text.toString()
            val Numb_x = "x "+ NumB

            textA.text=NumA_show
            textB.text=Numb_x


            val listDeElementos = NumB.map{it.toString()}.toList()
            val sum1: Int = NumA * (listDeElementos[1].toInt())
            val sum1_show: String = sum1.toString()

            val sum2: Int = NumA * (listDeElementos[0].toInt())

            val sum2_show: String = (sum2.toString()) + ""

            textA_SUM.text=sum1_show
            textB_SUM.text=sum2_show

            val sum2_sum: String = (sum2.toString())+"0"
            val sum2_int: Int = sum2_sum.toInt()

            val resul_bd: Int = sum1 + sum2_int
            val resul: String = (sum1 + sum2_int).toString()
            textResultado.text = resul
//            postMultiplicacion()


        }
    }
//    fun postMultiplicacion(/*NumA: Int, NumB_bd: Int, resul_bd: Int*/ ) {
//
//        /*val datos = WSMultiplicacion(
//            mull = NumA
//            mull2 = NumB_bd
//            resultado = resul_bd
//        )*/
//        val URL_WS = "http://192.168.1.16/mobile/"
//        val retrofit = Retrofit.Builder()
//            .baseUrl(URL_WS)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        val webServiceApi: WebServicesAPI = retrofit.create(WebServicesAPI::class.java)
//        val personaCall: Call<WSMultiplicacion> =
//            webServiceApi.postPersona(WSMultiplicacion(/*NumA,NumB_bd, resul_bd*/ ))
//        personaCall.enqueue(object : Callback<WSMultiplicacion> {
//            override fun onResponse(call: Call<WSMultiplicacion>, response: Response<WSMultiplicacion>) {
//                if (!response.isSuccessful()) {
//                    val error = "Ha ocurrido un error. Contacte al administrador"
//                    if (response.errorBody()
//                            ?.contentType()
//                        ?.subtype()
//                        == "json"
//                    ) {
//                    } else {
//                        try {
//                            Log.d("LoginActivity", response.errorBody()!!.string())
//                        } catch (e: IOException) {
//                            e.printStackTrace()
//                        }
//                    }
//                    return
//                }
//            }
//
//            override fun onFailure(call: Call<WSMultiplicacion>, t: Throwable) {
////                TODO("Not yet implemented")
//            }
//
//
//        })
//    }


}