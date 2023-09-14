package com.example.myapplication2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WSPersons {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ci")
    @Expose
    private String ci;
    @SerializedName("paterno")
    @Expose
    private String paterno;
    @SerializedName("materno")
    @Expose
    private String materno;
    @SerializedName("nombre")
    @Expose
    private String nombre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
