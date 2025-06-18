package com.bedu.inventario;

public class Main {
    public static void main(String[] args) {
        ProductoRepository repository = new ProductoRepository();

        // Agregar productos
        repository.save(new Producto(null, "Laptop Lenovo", "Portátil 16GB RAM", 12500.00));
        repository.save(new Producto(null, "Mouse Logitech", "Inalámbrico", 350.00));
        repository.save(new Producto(null, "Teclado Mecánico", "Switches azules", 950.00));
        repository.save(new Producto(null, "Monitor Samsung", "27 pulgadas 4K", 3200.00));

        // Mostrar todos
        System.out.println("📦 Todos los productos:");
        repository.findAll().forEach(System.out::println);

        // Precio > 500
        System.out.println("\n💰 Productos con precio > 500:");
        repository.findByPrecioGreaterThan(500).forEach(System.out::println);

        // Nombre contiene "lap" (case insensitive)
        System.out.println("\n🔍 Productos que contienen 'lap':");
        repository.findByNombreContainingIgnoreCase("lap").forEach(System.out::println);

        // Precio entre 400 y 1000
        System.out.println("\n🎯 Productos entre $400 y $1000:");
        repository.findByPrecioBetween(400, 1000).forEach(System.out::println);

        // Nombre empieza con "m" (case insensitive)
        System.out.println("\n📘 Productos que empiezan con 'm':");
        repository.findByNombreStartingWithIgnoreCase("m").forEach(System.out::println);
    }
}