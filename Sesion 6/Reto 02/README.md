# 🛒 Productos por marca en una tienda en línea

Extensión del sistema de inventario que implementa **relaciones ManyToOne** entre productos y marcas, simulando la estructura básica de un catálogo de e-commerce. Este proyecto demuestra:

- Configuración de **relaciones JPA** (`@ManyToOne`)  
- **Mapeo bidireccional** entre entidades  
- **Consultas agrupadas** por relaciones  
- **Patrón Repository** para operaciones CRUD  

## 🎯 Objetivo

⚒️ Reforzar el uso de relaciones en JPA mediante una entidad nueva llamada `Marca`, relacionada con `Producto`, simulando un modelo básico de una tienda en línea. Se trabajará con relaciones `@ManyToOne`, ideal para representar que varios productos pertenecen a una marca.

---

## 📝 Instrucciones

📌 **Importante:**  
Este reto se realiza **en el mismo proyecto del Ejemplo 02**, reutilizando la entidad `Producto` y agregando una nueva entidad `Marca`.

---

### 🛠️ Tareas a realizar:

1. ✍️ Crea una nueva clase `Marca` con los siguientes atributos:
   - `id` (clave primaria, autogenerada)
   - `nombre` (nombre de la marca)

2. 🔁 Relaciona `Producto` con `Marca` usando `@ManyToOne`:

    ```java
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;
    ```

3. 🔄 Agrega en `Producto`:
   - Constructor con parámetro `Marca`
   - Getter para `getMarca()`

4. 🧪 Desde `CommandLineRunner`, realiza lo siguiente:
   - Crea al menos **2 marcas**
   - Asocia al menos **2 productos a cada marca**
   - Muestra los productos agrupados por marca:

   ```java
   System.out.println("📚 Productos por marca:");
   marcaRepo.findAll().forEach(marca -> {
      System.out.println("🏷️ " + marca.getNombre() + ":");
      productoRepo.findAll().stream()
         .filter(p -> p.getMarca().getId().equals(marca.getId()))
         .forEach(p -> System.out.println("   - " + p.getNombre()));
   });
   ```

5. 🧾 Asegúrate de crear un `MarcaRepository` que extienda `JpaRepository`.

6. 🧾 Muestra la salida en consola con `System.out.println()`


   Al ejecutar el programa verás una salida similar a:

   ```
   📚 Productos por marca:
   🏷️ Apple:
      - iPhone 15
      - iPad Pro
   🏷️ Samsung:
      - Galaxy S23
      - Smart TV
   ```

---
