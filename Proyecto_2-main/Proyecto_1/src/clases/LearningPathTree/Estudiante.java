package clases.LearningPathTree;
import java.util.List;

public class Estudiante extends Usuario {
	public boolean ocupado=false;
	public float progreso;
	public List<LearningPath> listaLearningPathsInscritos;
	public Estudiante(String username, String email, String password, String rol) {
        super(username, email, password, rol); 
    }
	
	public void verLearningPath() {
		
	}
	
	public void realizarActividad() {
		
	}
}
