/**
 * 
 */
package clases.LearningPathTree;
import java.util.HashMap;
import java.io.IOException;
import java.util.ArrayList;
import Persistencia.ArchivoCSV;
/**
 * Clase del Learning Path
 */
public class LearningPath {
	/** ATRIBUTOS */
	public String titulo;
	public String descripcion;
	public String objetivos;
	public String nivelDificultad;
	public int duracion;
	public float rating;
	public String fechaDeCreacion;
	public String fechaDeModificacion;
	public String vercion;
    public HashMap<String, String> estructura;
	/** FUNCIONES */
	public void agregarActividad() {
		
	}
	
	public void editarLearningPath() {
		
	}
	

	
	private ArrayList<Actividad> actividades;
	public ArrayList<Actividad> getActividades() throws IOException {
		this.leerActividades();
		return actividades;
	}
	public LearningPath() {
		this.actividades = new ArrayList<Actividad>();
	}
	public void agregarActividad(String nombre, String tipo) {
		Actividad nuevaActividad = new Actividad(nombre, tipo);
		this.actividades.add(nuevaActividad);
	}

	public static void guardarActividad(ArrayList<Actividad> actividades) throws IOException {
		ArrayList<String> textos = new ArrayList<String>();
		for (Actividad actividad : actividades) 
			textos.add(actividad.toString());
		
		ArchivoCSV.guardarTextoCSV(textos, "Actividades.csv");
	}
	/*public static void guardarActividad() throws IOException {
		ArrayList<String> textos = new ArrayList<String>();
		for(Actividad actividad : this.actividades) 
			textos.add(actividad.toString());
		
		ArchivoCSV.guardarTextoCSV(textos, "Actividades.csv");
	}*/
	
	public void leerActividades() throws IOException {
		ArrayList<String> textos = ArchivoCSV.leerArchivoCSV("Actividades.csv");
		for(String texto : textos) {
			String []valores = texto.split(",");
			Actividad ActividadLeida = new Actividad(valores[0], valores[1]);
			this.actividades.add(ActividadLeida);
		}
	}
}
