package com.example.kotlin_proyect
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class cubo(context: Context) : View(context) {
    private val paint = Paint()
    var cubeSize = 100000

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width = canvas.width
        val height = canvas.height


        val maxSize = width
        val sideLength = if (cubeSize > maxSize) maxSize/2 else cubeSize

        val left = (width - sideLength) / 2
        val top = (height - sideLength) / 2
        val right = left + sideLength
        val bottom = top + sideLength
        val depth = sideLength / 2

        paint.color = Color.BLUE
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 5f


        canvas.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), paint)
        canvas.drawLine(left.toFloat(), top.toFloat(), (left - depth).toFloat(), (top - depth).toFloat(), paint)
        canvas.drawLine(right.toFloat(), top.toFloat(), (right - depth).toFloat(), (top - depth).toFloat(), paint)
        canvas.drawLine(left.toFloat(), bottom.toFloat(), (left - depth).toFloat(), (bottom - depth).toFloat(), paint)
        canvas.drawLine(right.toFloat(), bottom.toFloat(), (right - depth).toFloat(), (bottom - depth).toFloat(), paint)


        canvas.drawLine((left - depth).toFloat(), (top - depth).toFloat(), (right - depth).toFloat(), (top - depth).toFloat(), paint)
        canvas.drawLine((left - depth).toFloat(), (top - depth).toFloat(), (left - depth).toFloat(), (bottom - depth).toFloat(), paint)
        canvas.drawLine((right - depth).toFloat(), (top - depth).toFloat(), (right - depth).toFloat(), (bottom - depth).toFloat(), paint)
        canvas.drawLine((left - depth).toFloat(), (bottom - depth).toFloat(), (right - depth).toFloat(), (bottom - depth).toFloat(), paint)
    }
}
