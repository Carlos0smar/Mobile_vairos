package com.example.myapplication2;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class WSServicios {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("cantidad")
    @Expose
    private Integer cantidad;
    @SerializedName("precio")
    @Expose
    private Double precio;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
