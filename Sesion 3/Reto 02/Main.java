import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Datos
        List<Sucursal> sucursales = Arrays.asList(
                new Sucursal("Centro", Arrays.asList(
                        new Encuesta("Juan Pérez", "El tiempo de espera fue largo", 2),
                        new Encuesta("María García", null, 4),
                        new Encuesta("Carlos López", "Muy buen servicio", 5)
                )),
                new Sucursal("Norte", Arrays.asList(
                        new Encuesta("Ana Martínez", "La atención fue buena, pero la limpieza puede mejorar", 3),
                        new Encuesta("Luisa Fernández", null, 1),
                        new Encuesta("Pedro Sánchez", "Excelente trato del personal", 5)
                )),
                new Sucursal("Sur", Arrays.asList(
                        new Encuesta("Laura Díaz", "El médico fue muy malo", 1),
                        new Encuesta("Andrés Ruiz", "Poca privacidad en la consulta", 2),
                        new Encuesta("Sofía Mendoza", null, 3)
                ))
        );

        // Procesar encuestas
        ProcesadorEncuestas procesador = new ProcesadorEncuestas();
        procesador.generarSeguimientos(sucursales);
    }
}