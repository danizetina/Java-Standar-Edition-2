import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UCIMonitoringSystem {
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("⚕️ Sistema de Monitoreo de UCI Iniciado ⚕️\n");

        // Creamos un pool de hilos para los pacientes
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);

        // Monitoreo para 3 pacientes
        monitorPatient(executor, "Paciente 1");
        monitorPatient(executor, "Paciente 2");
        monitorPatient(executor, "Paciente 3");

        // Programa el cierre después de 30 segundos (ajustable)
        executor.schedule(() -> {
            executor.shutdown();
            System.out.println("\n⚕️ Sistema de Monitoreo Detenido ⚕️");
        }, 30, TimeUnit.SECONDS);
    }

    private static void monitorPatient(ScheduledExecutorService executor, String patientId) {
        // Programa la tarea de monitoreo cada 300ms
        executor.scheduleAtFixedRate(() -> {
            // Generar signos vitales aleatorios
            int heartRate = 40 + random.nextInt(100); // 40-140 bpm
            int systolicBP = 80 + random.nextInt(80); // 80-160 mmHg
            int diastolicBP = 50 + random.nextInt(50); // 50-100 mmHg
            int oxygenLevel = 80 + random.nextInt(25); // 80-105%

            // Verificar y mostrar alertas críticas
            checkCriticalSigns(patientId, heartRate, systolicBP, diastolicBP, oxygenLevel);
        }, 0, 300, TimeUnit.MILLISECONDS);
    }

    private static void checkCriticalSigns(String patientId, int hr, int sbp, int dbp, int spo2) {
        // Backpressure: limitamos a 1 alerta por segundo por paciente
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        // Verificar cada parámetro crítico
        if (hr < 50) {
            System.out.println("⚠️ " + patientId + " - FC crítica baja: " + hr + " bpm");
        } else if (hr > 120) {
            System.out.println("⚠️ " + patientId + " - FC crítica alta: " + hr + " bpm");
        }

        if (sbp < 90 || dbp < 60) {
            System.out.println("⚠️ " + patientId + " - PA crítica baja: " + sbp + "/" + dbp + " mmHg");
        } else if (sbp > 140 || dbp > 90) {
            System.out.println("⚠️ " + patientId + " - PA crítica alta: " + sbp + "/" + dbp + " mmHg");
        }

        if (spo2 < 90) {
            System.out.println("⚠️ " + patientId + " - SpO2 baja: " + spo2 + "%");
        }
    }
}