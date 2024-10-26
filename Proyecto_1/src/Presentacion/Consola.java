package Presentacion;

import java.io.IOException;

import clases.LearningPathTree.Actividad;
import clases.LearningPathTree.LearningPath;

public class Consola {
	private LearningPath learningPath;
	public Consola() throws IOException {
		this.learningPath = new LearningPath();
		//this.crearobjetos();
		//this.guardar();
		this.leer();
	}
	
	private void leer() throws IOException {
		try {
            this.learningPath.getActividades();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		for(Actividad actividades : this.learningPath.getActividades())
        
		    System.out.println(actividades.toString());
        System.out.println(this.learningPath.getActividades());
        
    
    }
	

	private void guardar() throws IOException {
			LearningPath.guardarActividad(null);
		
	}

	private void crearobjetos() {
		this.learningPath.agregarActividad("Parcial 2", "Examen");	
        
	}

	public static void main(String[] args) throws IOException {
		new Consola();
	}
}