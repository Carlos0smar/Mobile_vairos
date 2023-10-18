package com.example.kotlin_proyect


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Color.*
import android.graphics.Paint
import android.graphics.Path
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager

class triangulo_color(context: Context?) : View(context) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawColor(WHITE)
        var paint = Paint()

        val width = canvas?.width ?: 0
        val triangleHeight = (Math.sqrt(3.0) * width / 2).toFloat()

            for (i in 1..10) {
                val scaleFactor = 1.0f - i * 0.08f
                val scaledWidth = width * scaleFactor
                val scaledTriangleHeight = triangleHeight * scaleFactor

                val paintColor = Color.rgb(255-(2*i), 0+ (18*(2*i)),  0+(2*i))
                paint.color = paintColor

                val path = android.graphics.Path()
                path.moveTo((width - scaledWidth) / 2, (triangleHeight - scaledTriangleHeight) / 2)
                path.lineTo((width + scaledWidth) / 2, (triangleHeight - scaledTriangleHeight) / 2)
                path.lineTo(width / 2.0f, (triangleHeight + scaledTriangleHeight) / 2)
                path.close()

                canvas?.drawPath(path, paint)
            }
    }
}