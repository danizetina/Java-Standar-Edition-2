import java.util.concurrent.Callable;

public class SistemaControlTermico implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1200); // Simula 1.2 segundos de procesamiento
        return "🔥 Control térmico: temperatura estable (22°C).";
    }
}