package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ecuaciones extends AppCompatActivity {
    EditText editEcuacionA, editEcuacionB, editEcuacionC;
    Button buttonEcuacion;
    TextView textViewX1, textViewX2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecuaciones);

        editEcuacionA = findViewById(R.id.editEcuacionA);
        editEcuacionB = findViewById(R.id.editEcuacionB);
        editEcuacionC = findViewById(R.id.editEcuacionC);
        buttonEcuacion = findViewById(R.id.buttonEcuacion);
        textViewX1 = findViewById(R.id.textViewX1);
        textViewX2 = findViewById(R.id.textViewX2);

        buttonEcuacion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                float a = Float.parseFloat(editEcuacionA.getText().toString());
                float b = Float.parseFloat(editEcuacionB.getText().toString());
                float c = Float.parseFloat(editEcuacionC.getText().toString());
                Ecuacion ecuacion = new Ecuacion(a,b,c);
                ecuacion.solucion();
                textViewX1.setText(ecuacion.getX1());
                textViewX2.setText(ecuacion.getX2());
            }
        });
//        return 0;
    }
}