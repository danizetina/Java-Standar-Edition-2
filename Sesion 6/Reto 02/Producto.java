package com.bedu.inventario;

public class Producto {
    private Long id;
    private String nombre;
    private String descripcion;
    private double precio;
    private Marca marca;

    public Producto(Long id, String nombre, String descripcion, double precio, Marca marca) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.marca = marca;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public Marca getMarca() { return marca; }
    public void setMarca(Marca marca) { this.marca = marca; }

    @Override
    public String toString() {
        return String.format("Producto[id=%d, nombre='%s', marca='%s', precio=%.2f]",
                id, nombre, marca != null ? marca.getNombre() : "Sin marca", precio);
    }
}