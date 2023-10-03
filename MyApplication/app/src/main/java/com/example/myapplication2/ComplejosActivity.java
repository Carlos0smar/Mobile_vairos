package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ComplejosActivity extends AppCompatActivity {


    EditText editNumA, editNumB, editNumC, editNumD;
    Button buttonSumar, buttonRestar, buttonMultiplicar, buttonDividir;
    TextView textViewResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complejos);

        editNumA = findViewById(R.id.editNumA);
        editNumB = findViewById(R.id.editNumB);
        editNumC = findViewById(R.id.editNumC);
        editNumD = findViewById(R.id.editNumD);

        buttonSumar = findViewById(R.id.buttonSumar);
        buttonRestar = findViewById(R.id.buttonRestar);
        buttonMultiplicar = findViewById(R.id.buttonMultiplicar);
        buttonDividir = findViewById(R.id.buttonDividir);

        textViewResultado = findViewById(R.id.textViewResultado);


        buttonSumar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                float a = Float.parseFloat(editNumA.getText().toString());
                float b = Float.parseFloat(editNumB.getText().toString());
                float c = Float.parseFloat(editNumC.getText().toString());
                float d = Float.parseFloat(editNumD.getText().toString());

                Complejos ecuacion = new Complejos(a,b,c,d);
                ecuacion.suma();
                textViewResultado.setText(ecuacion.getResutado());
            }
        });

        buttonRestar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                float a = Float.parseFloat(editNumA.getText().toString());
                float b = Float.parseFloat(editNumB.getText().toString());
                float c = Float.parseFloat(editNumC.getText().toString());
                float d = Float.parseFloat(editNumD.getText().toString());

                Complejos ecuacion = new Complejos(a,b,c,d);
                ecuacion.resta();
                textViewResultado.setText(ecuacion.getResutado());
            }
        });

        buttonMultiplicar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                float a = Float.parseFloat(editNumA.getText().toString());
                float b = Float.parseFloat(editNumB.getText().toString());
                float c = Float.parseFloat(editNumC.getText().toString());
                float d = Float.parseFloat(editNumD.getText().toString());

                Complejos ecuacion = new Complejos(a,b,c,d);
                ecuacion.multiplicasion();
                textViewResultado.setText(ecuacion.getResutado());
            }
        });

        buttonDividir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                float a = Float.parseFloat(editNumA.getText().toString());
                float b = Float.parseFloat(editNumB.getText().toString());
                float c = Float.parseFloat(editNumC.getText().toString());
                float d = Float.parseFloat(editNumD.getText().toString());

                Complejos ecuacion = new Complejos(a,b,c,d);
                ecuacion.division();
                textViewResultado.setText(ecuacion.getResutado());
            }
        });
        return 0;
    }
}