import java.util.List;
import java.util.Optional;

public class ProcesadorEncuestas {
    public void generarSeguimientos(List<Sucursal> sucursales) {
        sucursales.stream()
                // Aplanar todas las encuestas de todas las sucursales
                .flatMap(sucursal -> sucursal.getEncuestas().stream()
                        // Asociar cada encuesta con su sucursal
                        .map(encuesta -> new Object[] {sucursal.getNombre(), encuesta})
                )
                // Filtrar encuestas con calificación <= 3
                .filter(par -> ((Encuesta) par[1]).getCalificacion() <= 3)
                // Obtener comentarios como Optional y filtrar los vacíos
                .map(par -> new Object[] {
                        par[0], // nombre sucursal
                        ((Encuesta) par[1]).getComentario()
                })
                .filter(par -> ((Optional<String>) par[1]).isPresent())
                // Transformar a mensaje de seguimiento
                .forEach(par -> {
                    String nombreSucursal = (String) par[0];
                    String comentario = ((Optional<String>) par[1]).get();
                    System.out.printf("Sucursal %s: Seguimiento a paciente con comentario: \"%s\"%n",
                            nombreSucursal, comentario);
                });
    }
}