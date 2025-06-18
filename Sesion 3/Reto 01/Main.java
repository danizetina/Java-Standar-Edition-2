import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Lista de pedidos de ejemplo
        List<Pedido> pedidos = Arrays.asList(
                new Pedido("Juan Pérez", "domicilio", "555-1234"),
                new Pedido("María García", "local", null),
                new Pedido("Carlos López", "domicilio", "555-5678"),
                new Pedido("Ana Martínez", "domicilio", null),
                new Pedido("Luisa Fernández", "domicilio", "555-9012")
        );

        // Procesar confirmaciones
        Pizzeria servicio = new Pizzeria();
        servicio.procesarConfirmaciones(pedidos);
    }
}