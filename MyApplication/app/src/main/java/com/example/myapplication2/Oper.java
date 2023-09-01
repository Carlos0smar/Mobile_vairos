package com.example.myapplication2;

import java.io.Serializable;

public class Oper implements Serializable {
    private int a;
    private int b;

    public Oper(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String suma(){
        return "la suma es: " + (this.a + this.b);
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }


}
