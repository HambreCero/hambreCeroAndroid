package com.example.hambrecero;

public class Receta {

    private long id;
    private String nombre;
    private String descripcion;

    private int imgResId;

    public long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }

    public int getImgResId() { return imgResId; }
    public void setImgResId(int imgResId) { this.imgResId = imgResId; }

    public Receta(long id, String nombre, String descripcion, int imgResId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imgResId = imgResId;
    }

    public Receta() { }
}
