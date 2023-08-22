package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CalculadoraActivity extends AppCompatActivity {
    private String operator = "";
    private String current_number = "";
     int last_number = 0;

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9,
    button0, buttonC, buttonSum, buttonRes, buttonMul, buttonDiv, buttonIgual ;

    TextView ShowResul ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonC = findViewById(R.id.buttonC);
        buttonSum = findViewById(R.id.buttonSum);
        buttonRes = findViewById(R.id.buttonRes);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonMul = findViewById(R.id.buttonMul);
        buttonIgual = findViewById(R.id.buttonIgual);
        ShowResul = findViewById(R.id.ShowResul);
        ShowResul.setText("0");

        ArrayList<Button> nums = new ArrayList<>();
        nums.add(button0);
        nums.add(button1);
        nums.add(button2);
        nums.add(button3);
        nums.add(button4);
        nums.add(button5);
        nums.add(button6);
        nums.add(button7);
        nums.add(button8);
        nums.add(button9);

        for (Button b : nums){
            b.setOnClickListener(View -> {
                if(!ShowResul.getText().toString().equals("0")){
                    ShowResul.setText(ShowResul.getText().toString() + b.getText().toString());
                }else{
                    ShowResul.setText(b.getText().toString());
                }
            });
        }

        ArrayList<Button> opers = new ArrayList<>();
        opers.add(buttonSum);
        opers.add(buttonRes);
        opers.add(buttonMul);
        opers.add(buttonDiv);
        for(Button b : opers){
            b.setOnClickListener(view -> {
                last_number = Integer.parseInt(ShowResul.getText().toString());
                operator = b.getText().toString();
                ShowResul.setText("0");
            });
        }

        buttonC.setOnClickListener(view -> {

                last_number = 0;
                ShowResul.setText("0");
//            String num = ShowResul.getText().toString();
//            if(num.length()>1){
//                ShowResul.setText(num.substring(0, num.length()-1));
//            }else if(num.length() == 1 && !num.equals("0")){
//                ShowResul.setText("0");
//            }
        });

        buttonIgual.setOnClickListener(view -> {
            int secondNum = Integer.parseInt(ShowResul.getText().toString());
            double result;
            switch (operator) {
                case "/":
                    result = last_number/secondNum;
                    break;
                case "*":
                    result = last_number*secondNum;
                    break;
                case "+":
                    result = last_number + secondNum;
                    break;
                case "-":
                    result = last_number-secondNum;
                    break;
                default:
                    result = last_number+secondNum;
            }
            ShowResul.setText(String.valueOf(result));
//            last_number = result;
        });

//        buttonC.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ShowResul.setText("");
//            }
//        });

//        button0.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String currentText = ShowResul.getText().toString();
//                String buttonText = button0.getText().toString();
//
//                ShowResul.setText(currentText + buttonText);
//            }
//        });
//
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String currentText = ShowResul.getText().toString();
//                String buttonText = button1.getText().toString();
//
//                ShowResul.setText(currentText + buttonText);
//            }
//        });
//
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String currentText = ShowResul.getText().toString();
//                String buttonText = button2.getText().toString();
//
//                ShowResul.setText(currentText + buttonText);
//            }
//        });
//
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String currentText = ShowResul.getText().toString();
//                String buttonText = button3.getText().toString();
//
//                ShowResul.setText(currentText + buttonText);
//            }
//        });
//
//        button4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String currentText = ShowResul.getText().toString();
//                String buttonText = button4.getText().toString();
//
//                ShowResul.setText(currentText + buttonText);
//            }
//        });
//
//        button5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String currentText = ShowResul.getText().toString();
//                String buttonText = button5.getText().toString();
//
//                ShowResul.setText(currentText + buttonText);
//            }
//        });
//
//        button6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String currentText = ShowResul.getText().toString();
//                String buttonText = button6.getText().toString();
//
//                ShowResul.setText(currentText + buttonText);
//            }
//        });
//
//        button7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String currentText = ShowResul.getText().toString();
//                String buttonText = button7.getText().toString();
//
//                ShowResul.setText(currentText + buttonText);
//            }
//        });
//
//        button8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String currentText = ShowResul.getText().toString();
//                String buttonText = button8.getText().toString();
//
//                ShowResul.setText(currentText + buttonText);
//            }
//        });
//
//        button9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String currentText = ShowResul.getText().toString();
//                String buttonText = button9.getText().toString();
//
//                ShowResul.setText(currentText + buttonText);
//            }
//        });
//
//        buttonSum.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String currentText = ShowResul.getText().toString();
//                String buttonText = buttonSum.getText().toString();
//
//                ShowResul.setText(currentText + buttonText);
//            }
//        });
//
//        // Manejo de botones de operación
//        View.OnClickListener operatorClickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!current_number.isEmpty()) {
//                    last_number = Integer.parseInt(current_number);
//                    current_number = "";
//                }
//                operator = ((Button) v).getText().toString();
//            }
//        };
//
//
//        // Manejo del botón de igual (=)
//        buttonIgual.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!current_number.isEmpty() && !operator.isEmpty()) {
//                    int operand2 = Integer.parseInt(current_number);
//                    double result = performOperation(last_number, operand2, operator);
//                    ShowResul.setText("");
//                    ShowResul.setText(String.valueOf(result));
//                    current_number = "";
//                    operator = "";
//                }
//            }
//        });

    }

//    private double performOperation(double operand1, double operand2, String operator) {
//        switch (operator) {
//            case "+":
//                return operand1 + operand2;
//            case "-":
//                return operand1 - operand2;
//            case "*":
//                return operand1 * operand2;
//            case "/":
//                if (operand2 != 0) {
//                    return operand1 / operand2;
//                } else {
//                    return Double.NaN; // División por cero
//                }
//            default:
//                return 0;
//        }
//    }
}