/**
 * 
 */
package clases.LearningPathTree;
import java.util.Date;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
//import Actividades.ArchivoCSV; 

/**
 * 
 */
public class Actividad {
	/** ATRIBUTOS */
	public String nombre;
	public String tipo;
		//TODO Auto-generated constructor stub
	
	/*public String descripcion;
	public String objetivo;
	public String nivelDificultad;
	public int duracion;
	public List<Actividad> actividadesPrevias;
	public Date fechaLimite;
	public String resultado;
	public boolean obligatorio;
	public List<String> reseñas;
	public List<Float> rating;
	public String autor;*/
	public String getnombre() {
		return nombre;
	}
	public void setnombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return nombre;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Actividad(String nombre2, String tipo) {
		super();
		this.nombre = nombre2;
		this.tipo = tipo;
	}
	

	
	/** FUNCIONES */
	public void completarActividad() {
		
	}
	

	

}
