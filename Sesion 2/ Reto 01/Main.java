import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("🚀 Simulación de misión espacial iniciada...");

        // Crear pool de 4 hilos (uno por subsistema)
        ExecutorService executor = Executors.newFixedThreadPool(4);

        try {
            // Enviar todas las tareas al executor
            Future<String> comunicaciones = executor.submit(new SistemaComunicaciones());
            Future<String> soporteVital = executor.submit(new SistemaSoporteVital());
            Future<String> controlTermico = executor.submit(new SistemaControlTermico());
            Future<String> navegacion = executor.submit(new SistemaNavegacion());

            // Esperar y mostrar los resultados en el orden especificado
            System.out.println(comunicaciones.get());
            System.out.println(soporteVital.get());
            System.out.println(controlTermico.get());
            System.out.println(navegacion.get());

            System.out.println("\n✅ Todos los sistemas reportan estado operativo.");

        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error en la misión: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
}