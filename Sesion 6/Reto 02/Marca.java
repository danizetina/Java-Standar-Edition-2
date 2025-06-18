package com.bedu.inventario;

public class Marca {
    private Long id;
    private String nombre;

    public Marca(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String toString() {
        return String.format("Marca[id=%d, nombre='%s']", id, nombre);
    }
}