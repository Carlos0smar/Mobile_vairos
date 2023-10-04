package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Arqui_Software extends AppCompatActivity {
    Button Operacion;
    EditText textN, textX;
    TextView textResul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arqui_software);

        Operacion = findViewById(R.id.buttonOperacion_Arqui);
        textN = findViewById(R.id.editTextN);
        textX = findViewById(R.id.editTextX);
        textResul = findViewById(R.id.textViewResultado);

        Operacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = Integer.parseInt(textN.getText().toString());
                int x = Integer.parseInt(textX.getText().toString());
                int resul = Ope(n,x);
                textResul.setText(String.valueOf(resul));
            }

            private int Ope(int n, int x) {
                return n+x;
            }
        });

        return 0;
    }
}