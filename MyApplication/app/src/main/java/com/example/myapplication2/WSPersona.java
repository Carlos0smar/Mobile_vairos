package com.example.myapplication2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WSPersona {

    @SerializedName("ci")
    @Expose
    private String ci;
    @SerializedName("paterno")
    @Expose
    private String paterno;
    @SerializedName("materno")
    @Expose
    private String materno;
    @SerializedName("nombres")
    @Expose
    private String nombres;

    public WSPersona(String ci, String paterno, String materno, String nombres) {
        this.ci = ci;
        this.paterno = paterno;
        this.materno = materno;
        this.nombres = nombres;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
}
