package com.example.myapplication2;

public class Complejos {
    private float a;
    private float b;
    private float c;
    private float d;
    private String resutado;

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

    public float getD() {
        return d;
    }

    public void setD(float d) {
        this.d = d;
    }

    public String getResutado() {
        return resutado;
    }

    public void setResutado(String resutado) {
        this.resutado = resutado;
    }

    public Complejos(float a, float b, float c, float d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public void suma() {
        String parReal = String.valueOf(this.a + this.c);
        String parImag = String.valueOf(this.b + this.d);
        resutado = "("+ parReal +")" + "+" + "(" + parImag + ")" + "i";
    }

    public void resta() {

        String parReal = String.valueOf(this.a - this.c);
        String parImag = String.valueOf(this.b - this.d);
        resutado = "("+ parReal +")" + "+" + "(" + parImag + ")" + "i";
    }

    public void  multiplicasion(){

        String parReal = String.valueOf(((this.a * this.c) + (this.b*this.d)));
        String parImag = String.valueOf((this.a*this.d) + (this.b * this.c));
        resutado = "("+ parReal +")" + "+" + "(" + parImag + ")" + "i";

    }

    public void division(){
        String parReal = String.valueOf(((this.a * this.c) + (this.b * this.d))/(Math.sqrt(this.c) + Math.sqrt(this.d)));
        String parImag = String.valueOf(((this.b*this.c) - (this.a*this.d))/(Math.sqrt(c)+Math.sqrt(d)));
        resutado = "("+ parReal +")" + "+" + "(" + parImag + ")" + "i";
    }
}
