### 🎯 Objetivo
⚒️ Implementar genéricos y wildcards para gestionar diferentes tipos de órdenes de producción en una planta industrial, clasificando entre producción en masa, personalizada y prototipos.
Además, deberás procesar las órdenes utilizando métodos flexibles con restricciones de tipo.

### 🧠 Contexto del reto
Imagina que trabajas en una planta industrial que produce:

🔧 Órdenes de producción en masa (productos estándar).
🛠️ Órdenes personalizadas (adaptadas a cliente).
🧪 Prototipos (productos en prueba).
Debes implementar un sistema que:

Gestione listas de órdenes de diferentes tipos (usando genéricos).
Muestre información de las órdenes sin importar el tipo.
Procese las órdenes personalizadas, agregando un costo adicional por ajuste.

### 📝 Instrucciones
Crea una clase abstracta llamada OrdenProduccion con los siguientes atributos:

codigo (String)
cantidad (int)
Incluye un método mostrarResumen() para imprimir información básica.

Crea tres subclases:

OrdenMasa (producción en masa)
OrdenPersonalizada (agrega cliente como atributo)
OrdenPrototipo (agrega faseDesarrollo como atributo)
Implementa un método genérico:

mostrarOrdenes(List<? extends OrdenProduccion> lista)
(Debe leer cualquier tipo de orden y mostrar sus datos).
Implementa otro método:

procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional)
(Debe modificar solo las órdenes personalizadas, mostrando un mensaje con el costo agregado).
En el método main, crea listas con varios tipos de órdenes (mínimo 2 por tipo) y prueba los métodos anteriores.

### 💪 Desafío adicional
Implementa una función que cuente el total de órdenes de cada tipo en la planta.

### 💡 Ejemplo de salida esperada
📋 Órdenes registradas:
🔧 OrdenMasa - Código: A123 - Cantidad: 500
🔧 OrdenMasa - Código: A124 - Cantidad: 750

📋 Órdenes registradas:
🛠️ OrdenPersonalizada - Código: P456 - Cantidad: 100 - Cliente: ClienteX
🛠️ OrdenPersonalizada - Código: P789 - Cantidad: 150 - Cliente: ClienteY

📋 Órdenes registradas:
🧪 OrdenPrototipo - Código: T789 - Cantidad: 10 - Fase: Diseño
🧪 OrdenPrototipo - Código: T790 - Cantidad: 5 - Fase: Pruebas

💰 Procesando órdenes personalizadas...
✅ Orden P456 ajustada con costo adicional de $200
✅ Orden P789 ajustada con costo adicional de $200

📊 Resumen total de órdenes:
🔧 Producción en masa: 2
🛠️ Personalizadas: 2
🧪 Prototipos: 2
