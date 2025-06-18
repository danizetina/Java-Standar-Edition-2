package com.bedu.inventario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductoRepository {
    private List<Producto> productos = new ArrayList<>();
    private Long currentId = 1L;

    public Producto save(String nombre, String descripcion, double precio, Marca marca) {
        Producto producto = new Producto(currentId++, nombre, descripcion, precio, marca);
        productos.add(producto);
        return producto;
    }

    public List<Producto> findAll() {
        return new ArrayList<>(productos);
    }

    public List<Producto> findByMarca(Marca marca) {
        return productos.stream()
                .filter(p -> p.getMarca() != null && p.getMarca().getId().equals(marca.getId()))
                .collect(Collectors.toList());
    }
}