import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        System.out.println("\n📋 Órdenes registradas:");
        for (OrdenProduccion orden : lista) {
            orden.mostrarResumen();
        }
    }

    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        System.out.println("\n💰 Procesando órdenes personalizadas...");
        for (Object obj : lista) {
            if (obj instanceof OrdenPersonalizada) {
                OrdenPersonalizada orden = (OrdenPersonalizada) obj;
                System.out.println("✅ Orden " + orden.codigo + " ajustada con costo adicional de $" + costoAdicional);
            }
        }
    }

    public static void contarOrdenes(List<? extends OrdenProduccion>... listas) {
        System.out.println("\n📊 Resumen total de órdenes:");
        int masa = 0, personalizadas = 0, prototipos = 0;

        for (List<? extends OrdenProduccion> lista : listas) {
            if (!lista.isEmpty()) {
                if (lista.get(0) instanceof OrdenMasa) {
                    masa += lista.size();
                } else if (lista.get(0) instanceof OrdenPersonalizada) {
                    personalizadas += lista.size();
                } else if (lista.get(0) instanceof OrdenPrototipo) {
                    prototipos += lista.size();
                }
            }
        }

        System.out.println("🔧 Producción en masa: " + masa);
        System.out.println("🛠️ Personalizadas: " + personalizadas);
        System.out.println("🧪 Prototipos: " + prototipos);
    }

    public static void main(String[] args) {
        // Crear listas con diferentes tipos de órdenes
        List<OrdenMasa> ordenesMasa = new ArrayList<>();
        ordenesMasa.add(new OrdenMasa("A123", 500));
        ordenesMasa.add(new OrdenMasa("A124", 750));

        List<OrdenPersonalizada> ordenesPersonalizadas = new ArrayList<>();
        ordenesPersonalizadas.add(new OrdenPersonalizada("P456", 100, "ClienteX"));
        ordenesPersonalizadas.add(new OrdenPersonalizada("P789", 150, "ClienteY"));

        List<OrdenPrototipo> ordenesPrototipo = new ArrayList<>();
        ordenesPrototipo.add(new OrdenPrototipo("T789", 10, "Diseño"));
        ordenesPrototipo.add(new OrdenPrototipo("T790", 5, "Pruebas"));

        // Mostrar todas las órdenes
        mostrarOrdenes(ordenesMasa);
        mostrarOrdenes(ordenesPersonalizadas);
        mostrarOrdenes(ordenesPrototipo);

        // Procesar órdenes personalizadas
        List<OrdenProduccion> listaProcesamiento = new ArrayList<>();
        listaProcesamiento.addAll(ordenesPersonalizadas);
        procesarPersonalizadas(listaProcesamiento, 200);

        // Contar el total de órdenes de cada tipo (desafío adicional)
        contarOrdenes(ordenesMasa, ordenesPersonalizadas, ordenesPrototipo);
    }
}
