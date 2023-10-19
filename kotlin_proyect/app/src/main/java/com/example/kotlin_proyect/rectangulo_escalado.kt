package com.example.kotlin_proyect

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class rectangulo_escalado(context: Context?) : View(context) {
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawColor(Color.WHITE)
        var paint = Paint()

        val width: Int = context.resources.displayMetrics.widthPixels
        val height: Int = context.resources.displayMetrics.heightPixels
        paint.color = Color.BLACK
        paint.strokeWidth = 5f
        println("ancho: "+width)

        var FigAlto = 1000
        var FigAncho = 7000

        val ancho = width.toFloat()
        val alto = height.toFloat()

        val scaleWidth = ancho / FigAncho
        val scaleHeight = alto / FigAlto
        val scaleFactor = Math.min(scaleWidth, scaleHeight)

        if (FigAlto > alto  || FigAncho > ancho ) {
            FigAlto = (FigAlto * scaleFactor * 0.5).toInt()
            FigAncho = (FigAncho * scaleFactor * 0.5).toInt()
        }


//        // Triángulo
//        val path = Path()
//        path.moveTo(ancho * 0.05f, alto * 0.05f)
//        path.lineTo(ancho * 0.05f, alto * 0.05f + FigAlto)
//        path.lineTo(ancho * 0.05f + FigAncho, alto * 0.05f + FigAlto)
//        path.close()
//        canvas.drawPath(path, paint)

        // Rectángulo
        val left = (ancho /2) * 0.05f
        val top = (alto/2) * 0.6f
        val right = left + FigAncho
        val bottom = top + FigAlto
        if (canvas != null) {
            canvas.drawRect(left, top, right, bottom, paint)
        }

    }
}