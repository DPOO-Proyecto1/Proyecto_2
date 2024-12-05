package clases.LearningPathTree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import Persistencia.ActividadLoader;
import Persistencia.LearningPathLoader;

/**
 * Clase del Learning Path
 */
import java.io.Serializable;

public class LearningPath implements Serializable {
    private static final long serialVersionUID = 1L;

    private String titulo;
    private String descripcion;
    private String objetivos;
    private String nivelDificultad;
    private int duracion;
    private float rating;
    private String fechaDeCreacion;
    private String fechaDeModificacion;
    private int version;
    private String actividades;

    // Constructor
    public LearningPath(String titulo, String descripcion, String objetivos, String nivelDificultad,
                        int duracion, String fechaDeCreacion, String fechaDeModificacion,
                        int version, String actividades) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.objetivos = objetivos;
        this.nivelDificultad = nivelDificultad;
        this.duracion = duracion;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeModificacion = fechaDeModificacion;
        this.version = version;
        this.actividades = actividades;
    }

	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getObjetivos() {
		return objetivos;
	}


	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}


	public String getNivelDificultad() {
		return nivelDificultad;
	}


	public void setNivelDificultad(String nivelDificultad) {
		this.nivelDificultad = nivelDificultad;
	}


	public int getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}


	public String getFechaDeCreacion() {
		return fechaDeCreacion;
	}


	public void setFechaDeCreacion(String fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}


	public String getFechaDeModificacion() {
		return fechaDeModificacion;
	}


	public void setFechaDeModificacion(String fechaDeModificacion) {
		this.fechaDeModificacion = fechaDeModificacion;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion() {
		this.version = version+1;
	}


	public String getActividades() {
		return actividades;
	}


	public void setActividades(String actividad) {
		this.actividades = actividad+" "+actividades;
	}
	
	public void agregarLearningPath() {
        // Llamar a agregarLearningPath en LearningPathLoader para almacenar en el archivo
        LearningPathLoader.agregarLearningPath(this);
    }
}