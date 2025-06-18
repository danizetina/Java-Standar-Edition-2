import java.util.List;
import java.util.Optional;

public class Pizzeria {
    public void procesarConfirmaciones(List<Pedido> pedidos) {
        pedidos.stream()
                // Filtrar solo pedidos a domicilio
                .filter(p -> "domicilio".equalsIgnoreCase(p.getTipoEntrega()))
                // Obtener teléfonos como Optional y filtrar los vacíos
                .map(Pedido::getTelefono)
                .filter(Optional::isPresent)
                // Extraer el valor del Optional y transformar a mensaje
                .map(Optional::get)
                .forEach(telefono ->
                        System.out.println("📞 Confirmación enviada al número: " + telefono)
                );
    }
}