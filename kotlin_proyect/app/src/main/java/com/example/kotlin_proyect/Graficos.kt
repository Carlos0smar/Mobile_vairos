package com.example.kotlin_proyect


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Color.WHITE
import android.graphics.Paint
import android.view.View

class Graficos(context: Context?) : View(context) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawColor(WHITE)
        var paint = Paint()

        for(i in 1..100){
            paint.setColor(Color.rgb(2+(5*i),5+(7*i),90+(10*i)))
            canvas?.drawCircle(50.0f*i+10.0f,50.0f*i+20.0f,10.0f*i+30.0f, paint)
        }

        for(i in 1..100){
            paint.setColor(Color.rgb(2+(5*i),5+(7*i),90+(10*i)))

            canvas?.drawRect(5.0f*i+10.0f,5.0f*i+20.0f,5.0f*i+30.0f,10.0f, paint)

        }
    }

}