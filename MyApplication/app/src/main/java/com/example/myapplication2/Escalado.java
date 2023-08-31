package com.example.myapplication2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class Escalado extends View {
    private static final String TAG = " DATOS";

    public Escalado(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);

        int ancho = getWidth();
        int alto = getHeight();
        int FigAlto = 7000;
        int FigAncho = 10000;

        float scaleWidth = (float) ancho / FigAncho;
        float scaleHeight = (float) alto / FigAlto;
        float scaleFactor = Math.min(scaleWidth, scaleHeight);

        if(FigAlto > alto/2 || FigAncho> ancho/2){

            FigAlto = (int) ((FigAlto * scaleFactor)*0.5);
            FigAncho = (int) ((FigAncho * scaleFactor)*0.5);
        }

        //Tríángulo
        canvas.drawLine((float) (ancho * 0.05), (float) (alto * 0.05), (float) (ancho * 0.05), (float) (alto * 0.05 + FigAlto), paint);
        canvas.drawLine((float) (ancho * 0.05), (float) (alto * 0.05 + FigAlto), (float) (ancho * 0.05 + FigAncho), (float) (alto * 0.05 + FigAlto), paint);
        canvas.drawLine((float) (ancho * 0.05), (float) (alto * 0.05), (float) (ancho * 0.05 + FigAncho), (float) (alto * 0.05 + FigAlto), paint);

        //Rectángulo
        canvas.drawLine((float)(ancho*0.05) , (float)(alto*0.6), (float)(ancho*0.05), (float)((alto*0.6)+FigAlto), paint);
        canvas.drawLine((float)(ancho*0.05) , (float)(alto*0.6), (float)((ancho*0.05)+FigAncho), (float)(alto*0.6), paint);
        canvas.drawLine((float)(ancho*0.05) , (float)(alto*0.6 + FigAlto), (float)((ancho*0.05)+FigAncho), (float)(alto*0.6+ FigAlto), paint);
        canvas.drawLine((float)(ancho*0.05 +FigAncho) , (float)(alto*0.6 ), (float)((ancho*0.05)+FigAncho), (float)(alto*0.6+ FigAlto), paint);
    }
}
