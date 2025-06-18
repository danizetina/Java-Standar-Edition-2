import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("🏥 Iniciando acceso a la Sala de cirugía...\n");

        // Crear el recurso médico compartido
        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");

        // Crear profesionales médicos
        String[] profesionales = {
                "Dra. Sánchez",
                "Dr. Gómez",
                "Enf. Rodríguez",
                "Dr. Pérez",
                "Dra. Martínez",
                "Enf. López"
        };

        // Crear pool de hilos
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Enviar tareas al executor
        for (String profesional : profesionales) {
            executor.submit(new ProfesionalMedico(profesional, salaCirugia));
        }

        // Cerrar el executor
        executor.shutdown();
    }
}
