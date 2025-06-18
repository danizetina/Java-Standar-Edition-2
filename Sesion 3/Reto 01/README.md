# 🍕 Confirmación segura de pedidos en una pizzería

Este proyecto implementa un sistema inteligente de gestión de pedidos para pizzerías que utiliza **Java Stream API** y **Optional** para:

- Filtrar y procesar pedidos de entrega a domicilio  
- Manejar seguramente datos incompletos (teléfonos nulos)  
- Generar confirmaciones automáticas para clientes  
- Garantizar procesamiento sin errores por datos faltantes 

## 🎯 Objetivo

⚒️ Aplicar `Optional` y `Stream API` para filtrar y transformar una lista de pedidos de una pizzería, asegurando el manejo seguro de datos incompletos (como números telefónicos) y generando mensajes personalizados para confirmar los envíos.

---

## 🧠 Contexto del reto

En una **pizzería**, algunos clientes han realizado **pedidos para entrega a domicilio**, pero **no todos han dejado su número de teléfono** para la confirmación.  

El sistema debe:

- Filtrar **solo los pedidos que sean para entrega a domicilio**.  
- Recuperar y **utilizar solo los números de teléfono disponibles** (sin `null`).  
- Transformar cada número en un **mensaje de confirmación**.  

---

## 📝 Instrucciones

### 1️⃣ Crear la clase `Pedido`

- Atributos:
  - `cliente` (`String`)
  - `tipoEntrega` (`String`) → `"domicilio"` o `"local"`
  - `telefono` (`String`, puede ser `null`)
- Implementar el método `getTelefono()` que devuelva un `Optional<String>`.

---

### 2️⃣ Procesar la lista de pedidos usando `Stream API`

1. Filtrar **solo los pedidos con tipo de entrega `"domicilio"`**.
2. Recuperar los **teléfonos disponibles** usando `Optional`.
3. Transformar cada teléfono en un **mensaje de confirmación** como:

```
📞 Confirmación enviada al número: 555-1234
```

4. Mostrar todos los mensajes en consola.

---

## 💡 Ejemplo de salida esperada

```
📞 Confirmación enviada al número: 555-1234
📞 Confirmación enviada al número: 555-5678
```

---
