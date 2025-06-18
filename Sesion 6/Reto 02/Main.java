package com.bedu.inventario;

public class Main {
    public static void main(String[] args) {
        // Crear repositorios
        MarcaRepository marcaRepo = new MarcaRepository();
        ProductoRepository productoRepo = new ProductoRepository();

        // Crear marcas
        Marca apple = marcaRepo.save("Apple");
        Marca samsung = marcaRepo.save("Samsung");

        // Crear productos asociados a marcas
        productoRepo.save("iPhone 15", "Último modelo de iPhone", 999.99, apple);
        productoRepo.save("iPad Pro", "Tablet profesional", 799.99, apple);
        productoRepo.save("Galaxy S23", "Teléfono Android", 899.99, samsung);
        productoRepo.save("Smart TV QLED", "TV 4K 55 pulgadas", 1299.99, samsung);

        // Mostrar productos agrupados por marca
        System.out.println("📚 Productos por marca:");
        marcaRepo.findAll().forEach(marca -> {
            System.out.println("🏷️ " + marca.getNombre() + ":");
            productoRepo.findByMarca(marca)
                    .forEach(p -> System.out.println("   - " + p.getNombre() + " ($" + p.getPrecio() + ")"));
        });

        // Mostrar todos los productos con sus marcas
        System.out.println("\n🛒 Todos los productos:");
        productoRepo.findAll().forEach(System.out::println);
    }
}