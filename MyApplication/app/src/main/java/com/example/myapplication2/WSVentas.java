package com.example.myapplication2;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class WSVentas {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("codigo")
    @Expose
    private String codigo;
    @SerializedName("lugar")
    @Expose
    private String lugar;
    @SerializedName("cantidad")
    @Expose
    private Integer cantidad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
