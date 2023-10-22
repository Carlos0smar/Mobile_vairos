package com.example.myapplication2;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class Graficos2D extends View {
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        private static final String TAG = " DATOS";

        public Graficos2D(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawColor(Color.BLACK);
            Paint paint = new Paint();

            paint.setColor(Color.WHITE);
            int ancho = getWidth()
    ;
            int alto = getHeight();
    //        PARA VER EL ALTO Y ANCHO DE LA PANTALLA
            Log.d(TAG, "Ancho = " + ancho + "Alto = " + alto);
    //        canvas.drawLine(10,10,100,100, paint);

            canvas.drawLine(0, alto/2, ancho, alto/2,paint);
            canvas.drawLine(ancho/2,0,ancho/2,alto,paint);

            float limInfx  = -20;
            float limSupx = 20;
            float limInfy = -20;
            float limSupy = 20;


            for(float x = limInfx; x<=limSupx; x+= 0.01){
                double y = fx(x);
    //            Log.d(TAG, "x = "+x+ " y = " + y);
                double xt = ((x-limInfx)/ (limSupx - limInfx)) * ancho;
                Log.d(TAG, "x = " +x + " xt = "+ xt);

                double yt = alto - (((y-limInfy)/ (limSupy - limInfy)) * alto);
                Log.d(TAG, "y = " +y + " yt = "+ yt);

                canvas.drawCircle((float)xt,(float) yt, 5, paint);

        }
    }
    double fx(float x){
        return x*Math.atan(x);
    }


}
