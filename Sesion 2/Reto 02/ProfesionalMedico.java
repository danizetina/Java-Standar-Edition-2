public class ProfesionalMedico implements Runnable {
    private final String nombre;
    private final RecursoMedico recurso;

    public ProfesionalMedico(String nombre, RecursoMedico recurso) {
        this.nombre = nombre;
        this.recurso = recurso;
    }

    @Override
    public void run() {
        try {
            // Simular tiempo antes de intentar acceder al recurso
            Thread.sleep((int)(Math.random() * 1000));
            recurso.usar(nombre);
        } catch (InterruptedException e) {
            System.err.println("⚠️ " + nombre + " no pudo completar su tarea");
        }
    }
}