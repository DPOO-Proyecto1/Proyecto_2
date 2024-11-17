package clases.LearningPathTree;
import java.util.List;
import clases.LearningPathTree.Actividad;

public class Profesor extends Usuario {
	public Actividad actividad; 
	public List<LearningPath> listaLearningPathsCreados;
	public Profesor(String username, String email, String password, String rol) {
        super(username, email, password, rol); 
    }
	
	public void crearLearningPath() {
		
	}
	
	public void editarLearningPath() {
		
	}
	
	public void clonarActividad() {
		
	}
	
	public void crarActividad() {
		if (actividad == null) {
        actividad = new Actividad("", ""); 
		}
    	actividad.crearActividad();  
	}
	
	
	public void editarActividad() {
		
	}
 }
