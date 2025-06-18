import java.util.concurrent.Callable;

public class SistemaComunicaciones implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(600); // Simula 0.6 segundos de procesamiento
        return "📡 Comunicaciones: enlace con estación terrestre establecido.";
    }
}