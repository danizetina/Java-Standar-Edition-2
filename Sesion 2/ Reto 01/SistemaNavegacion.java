import java.util.concurrent.Callable;

public class SistemaNavegacion implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000); // Simula 1 segundo de procesamiento
        return "🛰️ Navegación: trayectoria corregida con éxito.";
    }
}