package clases.LearningPathTree;

import java.util.List;

public class Quiz extends Actividad {

	private static final long serialVersionUID = 1L;
	
	public Quiz(String nombre2, String tipo) {
		super(nombre2, tipo);
	}
	public List<Actividad> preguntas;
	public float calificacionMinima;
}
/*package clases.LearningPathTree;

import java.util.List;

public class Quiz extends Actividad {
	public List<Actividad> preguntas;
	public float calificacionMinima;
}
 */