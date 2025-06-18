import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class AeropuertoControl {
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("🛫 Verificando condiciones para aterrizaje...\n");

        // Iniciar todas las verificaciones en paralelo
        CompletableFuture<Boolean> pistaFuture = verificarPista();
        CompletableFuture<Boolean> climaFuture = verificarClima();
        CompletableFuture<Boolean> traficoFuture = verificarTraficoAereo();
        CompletableFuture<Boolean> personalFuture = verificarPersonalTierra();

        // Combinar todos los resultados
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                pistaFuture, climaFuture, traficoFuture, personalFuture
        );

        // Procesar resultados cuando todos completen
        allFutures.thenRun(() -> {
            try {
                boolean pista = pistaFuture.get();
                boolean clima = climaFuture.get();
                boolean trafico = traficoFuture.get();
                boolean personal = personalFuture.get();

                System.out.println("\n🛣️ Pista disponible: " + pista);
                System.out.println("🌦️ Clima favorable: " + clima);
                System.out.println("🚦 Tráfico aéreo despejado: " + trafico);
                System.out.println("👷‍♂️ Personal disponible: " + personal);
                System.out.println();

                if (pista && clima && trafico && personal) {
                    System.out.println("🛬 Aterrizaje autorizado: todas las condiciones óptimas.");
                } else {
                    System.out.println("🚫 Aterrizaje denegado: condiciones no óptimas.");
                }
            } catch (Exception e) {
                System.err.println("⚠️ Error al verificar condiciones: " + e.getMessage());
                System.out.println("🚫 Aterrizaje denegado: error en el sistema.");
            }
        }).join(); // Bloquear solo para este ejemplo (en app real sería asíncrono)
    }

    public static CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simular latencia (2-3 segundos)
                TimeUnit.MILLISECONDS.sleep(2000 + random.nextInt(1000));

                // Simular falla aleatoria (20% de probabilidad de false)
                boolean disponible = random.nextDouble() <= 0.8;

                // Simular falla del servicio (5% de probabilidad)
                if (random.nextDouble() < 0.05) {
                    throw new RuntimeException("Servicio de pista no disponible");
                }

                return disponible;
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupción al verificar pista");
            }
        });
    }

    public static CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(2000 + random.nextInt(1000));
                boolean favorable = random.nextDouble() <= 0.85;
                if (random.nextDouble() < 0.05) {
                    throw new RuntimeException("Servicio meteorológico no disponible");
                }
                return favorable;
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupción al verificar clima");
            }
        });
    }

    public static CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(2000 + random.nextInt(1000));
                boolean despejado = random.nextDouble() <= 0.9;
                if (random.nextDouble() < 0.05) {
                    throw new RuntimeException("Servicio de tráfico aéreo no disponible");
                }
                return despejado;
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupción al verificar tráfico");
            }
        });
    }

    public static CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(2000 + random.nextInt(1000));
                boolean disponible = random.nextDouble() <= 0.95;
                if (random.nextDouble() < 0.05) {
                    throw new RuntimeException("Servicio de personal no disponible");
                }
                return disponible;
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupción al verificar personal");
            }
        });
    }
}