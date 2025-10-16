package javabeans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Pelicula {

    private String titulo,director;
    private int anio;
    private Actor[] actores;
    private String genero;
    private double calificacion;
}
