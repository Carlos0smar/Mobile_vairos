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



        int RectanguloAlto= 0;
        int RectanguloAncho = 0;

        paint.setColor(Color.WHITE);
        int ancho = getWidth();
        int alto = getHeight();
        int TrianguloAlto= 1000;
        int TrianguloAncho = 7000;


//
//        if(TrianguloAlto >(alto)){
//            TrianguloAlto =(TrianguloAlto/alto)+300;
//        }
//
//        if(TrianguloAncho >(ancho)){
//            TrianguloAncho =(TrianguloAncho/ancho)+300;
//        }

        if(TrianguloAlto >(alto-300) || TrianguloAncho >(alto-300)){
            if(TrianguloAlto>TrianguloAncho){
            TrianguloAlto =(TrianguloAlto/(alto));
            TrianguloAncho =(TrianguloAncho/(alto));

            }
            if(TrianguloAlto>TrianguloAncho) {
                TrianguloAlto = (TrianguloAlto / (ancho));
                TrianguloAncho = (TrianguloAncho / (ancho));
            }

            }

//        if(TrianguloAncho >(ancho-300)){
//        }
//        PARA VER EL ALTO 2281 Y ANCHO  1080 DE LA PANTALLA
        Log.d(TAG, "Ancho = " + ancho + "Alto = " + alto);
//        canvas.drawLine(10,10,100,100, paint);

        Double Hipotenusa = Math.sqrt(Math.pow(TrianguloAncho, 2) + Math.pow(TrianguloAlto,2));


        canvas.drawLine((float)(ancho*0.08) , (float)(alto*0.08), (float)(ancho*0.08), (float)(alto*0.08+TrianguloAlto), paint);
        canvas.drawLine((float)(ancho*0.08 ) , (float)(alto*0.08+ TrianguloAlto), (float)(ancho*0.08 + TrianguloAncho), (float)(alto*0.08+TrianguloAlto), paint);
        canvas.drawLine((float)(ancho*0.08 ) , (float)(alto*0.08), (float)(ancho*0.08 + TrianguloAncho), (float)(alto*0.08+ TrianguloAlto), paint);

        canvas.drawLine((float)(ancho*0.08) , (float)(alto*0.6), (float)(ancho*0.08), (float)((alto*0.6)+TrianguloAlto), paint);
        canvas.drawLine((float)(ancho*0.08) , (float)(alto*0.6), (float)((ancho*0.08)+TrianguloAncho), (float)(alto*0.6), paint);
        canvas.drawLine((float)(ancho*0.08) , (float)(alto*0.6 + TrianguloAlto), (float)((ancho*0.08)+TrianguloAncho), (float)(alto*0.6+ TrianguloAlto), paint);
        canvas.drawLine((float)(ancho*0.08 +TrianguloAncho) , (float)(alto*0.6 ), (float)((ancho*0.08)+TrianguloAncho), (float)(alto*0.6+ TrianguloAlto), paint);

//
//        canvas.drawLine(0, alto / 2, ancho, alto / 2, paint);
//        canvas.drawLine(ancho / 2, 0, ancho / 2, alto, paint);

//        float limInfx = -20;
//        float limSupx = 20;
//        float limInfy = -20;
//        float limSupy = 20;


//        for (float x = limInfx; x <= limSupx; x += 0.01) {
//            double y = fx(x);
////            Log.d(TAG, "x = "+x+ " y = " + y);
//            double xt = ((x - limInfx) / (limSupx - limInfx)) * ancho;
//            Log.d(TAG, "x = " + x + " xt = " + xt);
//
//            double yt = alto - (((y - limInfy) / (limSupy - limInfy)) * alto);
//            Log.d(TAG, "y = " + y + " yt = " + yt);
//
//            canvas.drawCircle((float) xt, (float) yt, 5, paint);
//        }
    }
//    double fx(float x){
//        return x*Math.atan(x);
//    }
}
