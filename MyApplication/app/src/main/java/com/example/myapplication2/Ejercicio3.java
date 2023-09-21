package com.example.myapplication2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Ejercicio3 extends View {

    private static final String TAG = " DATOS";

    public Ejercicio3(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint paint = new Paint();
        canvas.drawPaint(paint);
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.STROKE);


        int xCent = canvas.getWidth() / 2;
        int yCent = canvas.getHeight() / 2;
        double radio = 100;
        int radioMaximo = Math.min(xCent, yCent);
        if(radio > radioMaximo){

            radio = radioMaximo;

        }
        paint.setColor(Color.argb(255, 255, 0, 0));
        canvas.drawCircle((int) xCent, (int) yCent, (int) radio, paint);

    }
    }
