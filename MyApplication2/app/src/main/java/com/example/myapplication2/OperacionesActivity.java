package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OperacionesActivity extends AppCompatActivity {

    EditText editTextA, editTextB;
    Button buttonSuma;
    TextView TextViewResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones);

        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        buttonSuma = findViewById(R.id.buttonSuma);
        TextViewResultado = findViewById(R.id.textViewResultado); (){
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(editTextA);
            }

        buttonSuma.setOnClickListener(new View.OnClickListener

        });
    }
}