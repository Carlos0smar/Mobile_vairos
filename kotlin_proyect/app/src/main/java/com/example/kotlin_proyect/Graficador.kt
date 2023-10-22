package com.example.kotlin_proyect

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.View

class Graficador(context: Context?) : View(context) {

    override
    protected open fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.BLACK)
        val paint = Paint()

        paint.color = Color.WHITE
        val ancho = width
        val alto = height

        canvas.drawLine(0f, (alto / 2).toFloat(), ancho.toFloat(), (alto / 2).toFloat(), paint)
        canvas.drawLine((ancho / 2).toFloat(), 0f, (ancho / 2).toFloat(), alto.toFloat(), paint)

        val limInfx = -20f
        val limSupx = 20f
        val limInfy = -20f
        val limSupy = 20f
        var x = limInfx
        while(x<= limSupx){
            val y = fx(x)

            val xt = (x - limInfx) / (limSupx - limInfx) * ancho
//            Log.d(TAG, "x = $x xt = $xt")

            val yt = alto - (y - limInfy) / (limSupy - limInfy) * alto
//            Log.d(TAG, "y = $y yt = $yt")

            canvas.drawCircle(xt.toFloat(), yt.toFloat(), 5f, paint)
            x+=0.01.toFloat()
        }

    }
    fun fx( x: Float): Double {
        return x * Math.atan(x.toDouble())
    }
}