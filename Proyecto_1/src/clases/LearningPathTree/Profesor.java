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
	
<<<<<<< HEAD
=======
	public void crarActividad() {
		/*if (actividad == null) {
        actividad = new Actividad("", ""); 
		}*/
    	actividad.crearActividad();  
	}
	
>>>>>>> d19e1069f307662995a95d02492673474b159b78
	
	public void editarActividad() {
		
	}
 }
