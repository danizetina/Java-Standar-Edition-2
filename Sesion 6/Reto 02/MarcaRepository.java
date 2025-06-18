package com.bedu.inventario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MarcaRepository {
    private List<Marca> marcas = new ArrayList<>();
    private Long currentId = 1L;

    public Marca save(String nombre) {
        Marca marca = new Marca(currentId++, nombre);
        marcas.add(marca);
        return marca;
    }

    public List<Marca> findAll() {
        return new ArrayList<>(marcas);
    }

    public Optional<Marca> findById(Long id) {
        return marcas.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();
    }
}