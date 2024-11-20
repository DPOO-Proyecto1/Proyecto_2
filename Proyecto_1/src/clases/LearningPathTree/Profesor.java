package clases.LearningPathTree;
import java.util.List;
import clases.LearningPathTree.Actividad;

public class Profesor extends Usuario {
	public Actividad actividad; 
	public List<LearningPath> listaLearningPathsCreados;
	public Profesor(String username, String email, String password) {
        super(username, email, password, "profesor"); 
    }
	
	public void crearLearningPath() {
		
	}
	
	public void editarLearningPath() {
		
	}
	
	public void clonarActividad() {
		
	}

	public void editarActividad() {
		
	}
 }
