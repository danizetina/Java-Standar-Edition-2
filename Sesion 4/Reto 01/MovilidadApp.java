import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class MovilidadApp {
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("🚦 Calculando ruta...");
        System.out.println("💰 Estimando tarifa...");

        // Iniciar procesos asincrónicos
        CompletableFuture<String> rutaFuture = calcularRuta();
        CompletableFuture<Double> tarifaFuture = estimarTarifa();

        // Combinar resultados
        rutaFuture.thenCombine(tarifaFuture, (ruta, tarifa) -> {
                    return String.format("✅ 🚗 Ruta calculada: %s | Tarifa estimada: $%.2f", ruta, tarifa);
                })
                .exceptionally(ex -> {
                    System.err.println("⚠️ Error: " + ex.getMessage());
                    return "❌ No se pudo completar la solicitud. Por favor intente nuevamente.";
                })
                .thenAccept(System.out::println)
                .join(); // Esperar a que todo termine (solo para el ejemplo)
    }

    public static CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simular latencia de 2-3 segundos
                int delay = 2000 + random.nextInt(1000);
                TimeUnit.MILLISECONDS.sleep(delay);

                // Simular cálculo de ruta
                String[] puntos = {"Centro", "Norte", "Sur", "Este", "Oeste"};
                String origen = puntos[random.nextInt(puntos.length)];
                String destino;
                do {
                    destino = puntos[random.nextInt(puntos.length)];
                } while (destino.equals(origen));

                // Simular falla aleatoria (10% de probabilidad)
                if (random.nextDouble() < 0.1) {
                    throw new RuntimeException("No se pudo calcular la ruta. Tráfico muy congestionado.");
                }

                return "Ruta: " + origen + " -> " + destino;
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupción al calcular ruta");
            }
        });
    }

    public static CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simular latencia de 1-2 segundos
                int delay = 1000 + random.nextInt(1000);
                TimeUnit.MILLISECONDS.sleep(delay);

                // Simular cálculo de tarifa
                double tarifaBase = 50.0;
                double incrementoDemanda = random.nextDouble() * 30.0;
                double incrementoDistancia = random.nextDouble() * 20.0;

                // Simular falla aleatoria (10% de probabilidad)
                if (random.nextDouble() < 0.1) {
                    throw new RuntimeException("No se pudo estimar tarifa. Demanda muy variable.");
                }

                return tarifaBase + incrementoDemanda + incrementoDistancia;
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupción al estimar tarifa");
            }
        });
    }
}