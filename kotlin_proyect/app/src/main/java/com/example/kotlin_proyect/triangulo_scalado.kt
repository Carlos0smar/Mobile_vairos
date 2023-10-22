package com.example.kotlin_proyect

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View


class triangulo_scalado(context: Context?) : View(context) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawColor(Color.WHITE)
        var paint = Paint()

        val width: Int = context.resources.displayMetrics.widthPixels
        val height: Int = context.resources.displayMetrics.heightPixels

        val maxDimension = if (width < height) width else height
        val triangleHeight = (Math.sqrt(3.0) * maxDimension / 2).toFloat()

        var scaleFactor = 10000f

        if (scaleFactor > 1.0f) {
            scaleFactor = 1.0f
        }

        val scaledDimension = maxDimension * scaleFactor
        val scaledTriangleHeight = triangleHeight * scaleFactor

        val paintColor = Color.rgb(255, 0, 0) // Color rojo
        paint.color = paintColor

        val path = Path()
        val x = (width - scaledDimension) / 2
        val y = (height - scaledTriangleHeight) / 2
        path.moveTo(x, y)
        path.lineTo(x + scaledDimension, y)
        path.lineTo(width / 2.0f, y + scaledTriangleHeight)
        path.close()

        canvas?.drawPath(path, paint)



    }
}