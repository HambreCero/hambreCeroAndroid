package com.example.hambrecero;

public class Receta {

    private long id;
    private String nombre;

    // ✅ NUEVO: para la lista (coste)
    private String descripcionCorta;

    // ✅ NUEVO: para el detalle (texto completo)
    private String descripcionLarga;

    private int imgResId;

    public long getId() { return id; }
    public String getNombre() { return nombre; }

    public String getDescripcionCorta() { return descripcionCorta; }
    public String getDescripcionLarga() { return descripcionLarga; }

    public int getImgResId() { return imgResId; }
    public void setImgResId(int imgResId) { this.imgResId = imgResId; }

    // ✅ Constructor nuevo (con corta y larga)
    public Receta(long id, String nombre, String descripcionCorta, String descripcionLarga, int imgResId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcionCorta = descripcionCorta;
        this.descripcionLarga = descripcionLarga;
        this.imgResId = imgResId;
    }

    public Receta() { }
}
