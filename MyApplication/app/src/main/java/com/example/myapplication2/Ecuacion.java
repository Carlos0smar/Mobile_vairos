package com.example.myapplication2;

public class Ecuacion {
    private float a;
    private float b;
    private float c;
    private String x1;
    private String x2;

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getC() {
        return c;
    }

    public void setC(float c) {
        this.c = c;
    }

    public String getX1() {
        return x1;
    }

    public void setX1(String x1) {
        this.x1 = x1;
    }

    public String getX2() {
        return x2;
    }

    public void setX2(String x2) {
        this.x2 = x2;
    }

    public Ecuacion(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    private float d(){
        return(this.b*this.b)-(4*this.a*this.c);
    }

    public void solucion(){
        if(this.d() == 0){
            this.x1 = String.valueOf(-this.b / (2* this.a));
            this.x2 = String.valueOf(-this.b / (2* this.a));
        } else {
            if(this.d() > 0){
                this.x1 = String.valueOf((-this.b+Math.sqrt(this.d()))/(2*this.a));
                this.x2 = String.valueOf((-this.b-Math.sqrt(this.d()))/(2*this.a));
            }else{
                float pareal = -this.b / (2*this.a);
                float parimg = (float) (Math.sqrt(Math.abs(this.d()))/(2*this.a));
                this.x1 = String.valueOf(pareal) + '+' + String.valueOf(parimg) + 'i';
                this.x2 = String.valueOf(pareal) + '-' + String.valueOf(parimg) + 'i';

            }
        }
    }
}
