package clases.LearningPathTree;
import java.util.List;

public class Encuesta extends Actividad {
	public Encuesta(String nombre2, String tipo) {
		super(nombre2, tipo);
	public Encuesta(String nombre2, String tipo, int duracion) {
		super(nombre2, tipo, tipo, tipo, tipo, duracion, tipo, tipo, tipo, obligatorio, tipo, duracion, tipo, tipo);
	}

	public List<Actividad> preguntasAbiertas;
}

/*package clases.LearningPathTree;
import java.util.List;

public class Encuesta extends Actividad {
	public List<Actividad> preguntasAbiertas;
}
 */