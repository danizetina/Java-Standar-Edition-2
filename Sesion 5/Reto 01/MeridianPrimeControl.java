import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class MeridianPrimeControl {
    private static final Random random = new Random();
    private static final AtomicBoolean running = new AtomicBoolean(true);
    private static int eventCount = 0;

    public static void main(String[] args) {
        System.out.println("⚡ Sistema de Meridian Prime iniciado ⚡\n");

        // Hilo principal que genera eventos
        new Thread(() -> {
            try {
                // 1. Evento de tráfico (crítico)
                Thread.sleep(800);
                System.out.println("🚗 Alerta: Congestión del " + (83 + random.nextInt(5)) + "% en Avenida Solar");
                checkCriticalEvent();

                // Evento no crítico
                Thread.sleep(300);
                System.out.println("🚙 Tráfico fluido en Avenida Lunar");

                // 2. Evento de contaminación (crítico)
                Thread.sleep(700);
                System.out.println("🌫️ Alerta: Contaminación alta (PM2.5: " + (65 + random.nextInt(5)) + " ug/m3)");
                checkCriticalEvent();

                // Evento no crítico
                Thread.sleep(400);
                System.out.println("🌤️ Calidad del aire dentro de límites normales");

                // 3. Evento de accidente (crítico)
                Thread.sleep(600);
                System.out.println("🚑 Emergencia vial: Accidente con prioridad Alta");
                checkCriticalEvent();

                // Evento no crítico
                Thread.sleep(500);
                System.out.println("🚓 Patrulla de tránsito en ruta");

                // 4. Evento de tren (crítico)
                Thread.sleep(900);
                System.out.println("🚝 Tren maglev con retraso crítico: " + (7 + random.nextInt(4)) + " minutos");
                checkCriticalEvent();

                // Evento no crítico
                Thread.sleep(350);
                System.out.println("🚈 Tren expreso llegando a tiempo");

                // 5. Evento de semáforo (crítico)
                Thread.sleep(750);
                System.out.println("🚦 Semáforo en Rojo detectado 3 veces seguidas en cruce Norte");
                checkCriticalEvent();

                // Evento no crítico
                Thread.sleep(450);
                System.out.println("🟢 Semáforo inteligente optimizando flujo");

                // Alerta global
                Thread.sleep(1200);
                System.out.println("\n🚨 Alerta global: Múltiples eventos críticos detectados en Meridian Prime");

                running.set(false); // Detiene el sistema

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Hilo de control
        new Thread(() -> {
            while (running.get()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("\n⚡ Sistema de Meridian Prime detenido ⚡");
            System.exit(0);
        }).start();
    }

    private static void checkCriticalEvent() {
        if (++eventCount >= 3 && running.get()) {
            System.out.println("\n🚨 [ALERTA PRELIMINAR] Se están acumulando eventos críticos");
        }
    }
}