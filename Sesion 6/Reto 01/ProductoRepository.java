package com.bedu.inventario;

import java.util.ArrayList;
import java.util.List;

public class ProductoRepository {
    private List<Producto> productos = new ArrayList<>();
    private Long currentId = 1L;

    // Guardar producto
    public void save(Producto producto) {
        producto.setId(currentId++);
        productos.add(producto);
    }

    // Buscar todos
    public List<Producto> findAll() {
        return new ArrayList<>(productos);
    }

    // Buscar por nombre (contiene texto, sin distinguir mayúsculas)
    public List<Producto> findByNombreContainingIgnoreCase(String texto) {
        List<Producto> resultados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getNombre().toLowerCase().contains(texto.toLowerCase())) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    // Buscar por precio mayor que
    public List<Producto> findByPrecioGreaterThan(double precioMin) {
        List<Producto> resultados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getPrecio() > precioMin) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    // Buscar por rango de precios
    public List<Producto> findByPrecioBetween(double min, double max) {
        List<Producto> resultados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getPrecio() >= min && p.getPrecio() <= max) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    // Buscar por prefijo de nombre (sin distinguir mayúsculas)
    public List<Producto> findByNombreStartingWithIgnoreCase(String prefijo) {
        List<Producto> resultados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getNombre().toLowerCase().startsWith(prefijo.toLowerCase())) {
                resultados.add(p);
            }
        }
        return resultados;
    }
}