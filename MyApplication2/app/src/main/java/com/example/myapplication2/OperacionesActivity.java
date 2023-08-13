package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OperacionesActivity extends AppCompatActivity {

    EditText editTextA, editTextB;
    Button buttonSuma, buttonResta, buttonDivision, buttonMultiplicacion;
    TextView TextViewResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones);

        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        buttonSuma = findViewById(R.id.buttonSuma);
        buttonResta = findViewById(R.id.buttonResta);
        buttonMultiplicacion = findViewById(R.id.buttonMultiplicacion);
        buttonDivision = findViewById(R.id.buttonDivision);
        TextViewResultado = findViewById(R.id.textViewResultado);
        buttonSuma.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(editTextA.getText().toString());
                int y = Integer.parseInt(editTextB.getText().toString());
                Operaciones operaciones = new Operaciones(x,y);
                TextViewResultado.setText(String.valueOf(operaciones.sumar()));
            }

        });

        buttonResta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int x = Integer.parseInt(editTextA.getText().toString());
                int y = Integer.parseInt(editTextB.getText().toString());
                Operaciones operaciones = new Operaciones(x, y);
                TextViewResultado.setText(String.valueOf(operaciones.restar()));
            }
        });

        buttonMultiplicacion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int x = Integer.parseInt(editTextA.getText().toString());
                int y = Integer.parseInt(editTextB.getText().toString());
                Operaciones operaciones = new Operaciones(x,y);
                TextViewResultado.setText(String.valueOf(operaciones.multiplicar()));
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(editTextA.getText().toString());
                int y = Integer.parseInt(editTextB.getText().toString());
                Operaciones operacioens = new Operaciones(x,y);
                TextViewResultado.setText(String.valueOf(operacioens.dividir()));
            }
        });
    }
}