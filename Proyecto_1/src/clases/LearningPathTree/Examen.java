package clases.LearningPathTree;
import java.util.List;

public class Examen extends Actividad {

	private static final long serialVersionUID = 1L;
	
	public Examen(String nombre2, String tipo) {
		super(nombre2, tipo);
	}
	public List<Actividad> preguntasAbiertas;
	public String estado;
}
