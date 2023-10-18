package com.example.kotlin_proyect

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View


class triangulo_scalado(context: Context?) : View(context) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawColor(Color.WHITE)
        var paint = Paint()



        val width: Int = context.resources.displayMetrics.widthPixels
        val height: Int = context.resources.displayMetrics.heightPixels


        val xCent = width / 2
        val yCent = height / 2
        var radio = 100.0
        val radioMaximo = Math.min(xCent, yCent)
        if (radio > radioMaximo) {
            radio = radioMaximo.toDouble()
        }
        canvas?.drawRect(5.0f+10.0f,5.0f+20.0f,5.0f+30.0f,10.0f, paint)

    }
}