package com.example.kotlin_proyect

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
    //Instancia de Retrofit
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.68.115/movil/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
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
        val Button_practica = findViewById<Button>(R.id.buttonPractica_course)
        val Segundo_Parcial = findViewById<Button>(R.id.buttonSegundo_parcial)
        val ButtonWSA_2_GET = findViewById<Button>(R.id.buttonWSA_2_GET)





        Button_practica.setOnClickListener(){
            val intent = Intent(this@MainActivity, practica_1_course::class.java)
            startActivity(intent)
        }
        Segundo_Parcial.setOnClickListener(){
            val intent = Intent(this@MainActivity, Segundo_parcial::class.java)
            startActivity(intent)
        }

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

        ButtonWSA_2_GET.setOnClickListener(){
            getLugaresREST()
        }

    }
    fun getLugaresREST() {

        val webApi = retrofit.create(WebServicesAPI::class.java)
        webApi.getLugares().enqueue(object : Callback<List<ResponseLugar>>{
            override fun onResponse(call: Call<List<ResponseLugar>>,response: Response<List<ResponseLugar>>) {
                if(response.isSuccessful){
                    Log.d("Datos","Exito"+ (response.body()?.get(0)?.nombre ?: "oso"))
                }else{
                    Log.d("Datos","Paso algo")
                }
            }
            override fun onFailure(call: Call<List<ResponseLugar>>, t: Throwable) {
                Log.d("Datos","Error"+t.message.toString())
            }
        })
    }

//    fun getLugaresREST() {
//
//        val webApi = retrofit.create(WebAPI::class.java)
//        webApi.getLugares().enqueue(object : Callback<List<ResponseLugar>>{
//            override fun onResponse(call: Call<List<ResponseLugar>>,response: Response<List<ResponseLugar>>) {
//                if(response.isSuccessful){
//                    Log.d("Datos","Exito"+ (response.body()?.get(0)?.nombre ?: "oso"))
//                }else{
//                    Log.d("Datos","Paso algo")
//                }
//            }
//            override fun onFailure(call: Call<List<ResponseLugar>>, t: Throwable) {
//                Log.d("Datos","Error"+t.message.toString())
//            }
//        })
//    }
//    fun postLugaresREST(){
//        val retrofitP = Retrofit.Builder()
//            .baseUrl("http://192.168.165.241:81/sis104/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val lugar = PostLugar(  id = null,
//            nombre = "Beni",
//            descripcion = "San Borja",
//            latitud = 32.5f,
//            longitud = 45.7f )
//
//        val webApi = retrofitP.create(WebAPI::class.java)
//
//        webApi.addLugar(lugar).enqueue(object: Callback<ResponseBody>{
//
//            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//                if(response.isSuccessful)
//                    Log.d("Datos","Se envio, verificar "+response.body().toString())
//                else
//                    Log.d("Datos","Se envio pero fallo "+ response.body().toString())
//            }
//
//            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                Log.d("Datos","Falla "+t.message.toString())
//            }
//
//        })
//    }
//
//    fun getMultipleRequest(){
//        val logging = HttpLoggingInterceptor()
//        logging.level = HttpLoggingInterceptor.Level.BODY
//
//        val httpClient = OkHttpClient.Builder()
//        httpClient.addInterceptor(logging)
//
//        val gson = GsonBuilder()
//            .setLenient()
//            .create()
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl("http://192.168.165.241:81/sis104/")
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .client(httpClient.build())
//            .build()
//        val service: WebAPI = retrofit.create<WebAPI>(WebAPI::class.java)
//
//        val requests = ArrayList<Observable<*>>()
//
//        requests.add(service.getResponseOne())
//        requests.add(service.getResponseTwo())
//        requests.add(service.getResponseThree())
//        requests.add(service.getResponseFour())
//
//        val obs = Observable.zip(
//            requests
//        ) { objects -> // Objects[] is an array of combined results of completed requests
//            Log.d("Datos","Finalizado")
//            Any()
//        } // After all requests had been performed the next observer will receive the Object, returned from Function
//            .subscribe( // Will be triggered if all requests will end successfully (4xx and 5xx also are successful requests too)
//                { o ->
//                    Log.d("Datos", "Finalizado con exito accept  $o")
//                }
//            )  // Will be triggered if any error during requests will happen
//            { e -> //Do something on error completion of requests
//                Log.d("Datos", "Error ---*> $e")
//            }
//
//    }
    fun getDataPersons() {
        val URL_WS = "http://192.168.1.12/mobile/"
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