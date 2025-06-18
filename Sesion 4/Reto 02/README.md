# ✈️ Gestión asincrónica de vuelos en un aeropuerto internacional

Este proyecto simula el **sistema de control de aterrizajes** de un aeropuerto internacional utilizando programación asincrónica en Java con `CompletableFuture`. Maneja múltiples verificaciones en paralelo para autorizar aterrizajes de forma no bloqueante, reflejando condiciones reales de operación aérea.


## 🎯 Objetivo

⚒️ Simular un flujo **asincrónico y no bloqueante** para la **gestión de aterrizajes en un aeropuerto internacional**, integrando **varias consultas en paralelo** con `CompletableFuture`, combinando sus resultados y manejando errores potenciales.

---

## 🧠 Contexto del reto

En un aeropuerto internacional, al aproximarse un **vuelo para aterrizaje**, el sistema debe realizar **consultas asincrónicas** para validar las condiciones del aterrizaje:

1. **Disponibilidad de la pista** (puede haber ocupación o mantenimiento).  
2. **Estado meteorológico** (ej. tormentas, niebla, vientos fuertes).  
3. **Estado del tráfico aéreo cercano** (otros vuelos aproximándose).  
4. **Disponibilidad de personal en tierra** (personal de guía y seguridad).

El aterrizaje solo se **autoriza si todas las condiciones son óptimas**.  
Este proceso debe ser **no bloqueante** y robusto, manejando errores si alguno de los servicios falla.

---

## 📝 Instrucciones

1. Crea una clase **`AeropuertoControl`** con los siguientes métodos:

   - `CompletableFuture<Boolean> verificarPista()`  
   - `CompletableFuture<Boolean> verificarClima()`  
   - `CompletableFuture<Boolean> verificarTraficoAereo()`  
   - `CompletableFuture<Boolean> verificarPersonalTierra()`  

   Cada método debe simular **latencia** (2-3 segundos) y devolver `true` si el servicio es favorable.

2. **Ejecuta todas las verificaciones en paralelo** usando `CompletableFuture`.  
3. **Combina los resultados** usando `thenCombine`, `thenCombineAsync` o `allOf` para **decidir si se autoriza el aterrizaje**.  
4. Si alguna consulta **falla o regresa `false`**, muestra:

   ```
   🚫 Aterrizaje denegado: condiciones no óptimas.
   ```

   Si todo es exitoso:

   ```
   🛬 Aterrizaje autorizado: todas las condiciones óptimas.
   ```

5. Usa **`exceptionally`** para manejar cualquier **error en el proceso**.

---

## 💪 Desafío adicional

- **Agrega fallas aleatorias** en cada servicio:  
  - Cada verificación puede devolver **`true` o `false` aleatoriamente** (simulando incertidumbre).  
  - Define probabilidades diferentes para cada servicio (ej. pista 80%, clima 85%, tráfico 90%, personal 95%).

Esto hará que **cada ejecución sea distinta**, reflejando escenarios **más realistas** en la gestión de aterrizajes.

---

## 💡 Ejemplo de salida esperada

```
🛫 Verificando condiciones para aterrizaje...

🛣️ Pista disponible: true
🌦️ Clima favorable: false
🚦 Tráfico aéreo despejado: true
👷‍♂️ Personal disponible: true

🚫 Aterrizaje denegado: condiciones no óptimas.
```

O:

```
🛣️ Pista disponible: true
🌦️ Clima favorable: true
🚦 Tráfico aéreo despejado: true
👷‍♂️ Personal disponible: true

🛬 Aterrizaje autorizado: todas las condiciones óptimas.
```

---
