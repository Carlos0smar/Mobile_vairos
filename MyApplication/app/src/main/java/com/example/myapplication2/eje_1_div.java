package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class eje_1_div extends AppCompatActivity {

    Button dividir;
    TextView divisor_view, dividendo_view, cociente_view, resto_view;
    EditText divisor, dividendo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eje1_div);

        dividir = findViewById(R.id.button_Dividir);
        divisor_view = findViewById(R.id.textView_Divisor);
        dividendo_view = findViewById(R.id.textView_Dividendo);
        cociente_view = findViewById(R.id.textView_Cociente);
        resto_view = findViewById(R.id.textView_Resto);
        divisor = findViewById(R.id.editTextText_Divisor);
        dividendo = findViewById(R.id.editTextText_Dividendo);

        dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String divisor_string = divisor.getText().toString();
                String dividendo_string = dividendo.getText().toString();

                divisor_view.setText(divisor_string);
                dividendo_view.setText(dividendo_string);

                int divisor_i = Integer.parseInt(divisor.getText().toString());
                int dividendo_i = Integer.parseInt(dividendo.getText().toString());;

                float cociente_f = (dividendo_i / divisor_i );
//                float b = Float.parseFloat(editEcuacionB);



                int reciduo_i = (divisor_i % dividendo_i);
                String cociente_String = Float.toString(cociente_f);
                cociente_view.setText(cociente_String);

                List<Integer> digitosResiduo = obtenerListaDigitos(reciduo_i);
                String column = "";
                for (int i = 0; i < digitosResiduo.size(); i++) {
                    String digito = Integer.toString(digitosResiduo.get(i));

                    // Crear un nuevo TextView (puedes ajustar esto según tus necesidades)
                    column = column + "/n" + digito ;
                    // Configurar el texto del TextView con el dígito

                }


                resto_view.setText(column.toString());

            }
        });

    }

    private List<Integer> obtenerListaDigitos(int numero) {
        List<Integer> digitos = new ArrayList<>();

        // Convertir el número a cadena para obtener cada dígito
        String numeroString = Integer.toString(numero);

        // Agregar cada dígito a la lista
        for (int i = 0; i < numeroString.length(); i++) {
            int digito = Character.getNumericValue(numeroString.charAt(i));
            digitos.add(digito);
        }

        return digitos;
    }
}