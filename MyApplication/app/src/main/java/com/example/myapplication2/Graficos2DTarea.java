package com.example.myapplication2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
public class Graficos2DTarea extends View{

    private static final String TAG = " DATOS";

    public Graficos2DTarea(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint paint = new Paint();
        canvas.drawPaint(paint);
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.STROKE);


        int xCent = canvas.getWidth()/2;
        int yCent = canvas.getHeight()/2;
        double radio = 270;

        for(int i=0; i<120; i+=5){
            double angulo = Math.toRadians(i);
            double x1 = (Math.sin(angulo) * radio);
            double y1 = (Math.cos(angulo) * radio);
            paint.setColor(Color.argb(255,255,250,0));
            canvas.drawCircle((int)x1+xCent, (int)y1+yCent,(int)radio,paint);

        }

        for(int i=120; i<240; i+=5){
            double angulo = Math.toRadians(i);
            double x1 = (Math.sin(angulo) * radio);
            double y1 = (Math.cos(angulo) * radio);
            paint.setColor(Color.argb(255,255,0,0));
//            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle((int)x1+xCent, (int)y1+yCent,(int)radio,paint);

        }

        for(int i=240; i<360; i+=5){
            double angulo = Math.toRadians(i);
            double x1 = (Math.sin(angulo) * radio);
            double y1 = (Math.cos(angulo) * radio);
            paint.setColor(Color.argb(255,0,255,0));
//            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle((int)x1+xCent, (int)y1+yCent,(int)radio,paint);

        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.argb(255,0,0,255));
        canvas.drawCircle((int)xCent, (int)yCent,(int)200,paint);


    }
}
