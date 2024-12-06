package clases.LearningPathTree;
import java.util.List;

public class Encuesta extends Actividad {

	private static final long serialVersionUID = 1L;
	
	public Encuesta(String nombre2, String tipo) {
		super(nombre2, tipo); 
		}
	
	public Encuesta(String nombre2, String tipo, int duracion) {
		super(nombre2, tipo, tipo, tipo, tipo, tipo, duracion, tipo, tipo, false, tipo);
	}

	public List<Actividad> preguntasAbiertas;
}