import java.util.concurrent.locks.ReentrantLock;

public class RecursoMedico {
    private final String nombre;
    private final ReentrantLock lock = new ReentrantLock(true); // Lock con fair ordering

    public RecursoMedico(String nombre) {
        this.nombre = nombre;
    }

    public void usar(String profesional) {
        lock.lock(); // Adquirir el lock
        try {
            System.out.println("👩‍⚕️ " + profesional + " ha ingresado a " + nombre);

            // Simular tiempo de uso del recurso
            int tiempoUso = 1000 + (int)(Math.random() * 2000);
            Thread.sleep(tiempoUso);

            System.out.println("✅ " + profesional + " ha salido de " + nombre);
        } catch (InterruptedException e) {
            System.err.println("⚠️ " + profesional + " fue interrumpido durante el uso de " + nombre);
        } finally {
            lock.unlock(); // Liberar el lock siempre
        }
    }
}