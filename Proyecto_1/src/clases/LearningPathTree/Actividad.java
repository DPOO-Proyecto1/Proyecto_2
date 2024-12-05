/*
package clases.LearningPathTree;
import java.util.Date;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
//import Actividades.ArchivoCSV; 


public class Actividad {
	//ATRIBUTOS 
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
	public String autor;
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
	

	
	/* FUNCIONES 
	public void completarActividad() {
		
	}
	

	

}*/

/**
 * 
 */
package clases.LearningPathTree;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Persistencia.ActividadLoader;

import java.io.Serializable;

public class Actividad implements Serializable {
	
	private static final long serialVersionUID = 1L; // Define un ID fijo
	
    private String nombre;
    private String tipo;
    private String descripcion;
    private String objetivo;
    private String contenido;
    private String dificultad;
    private int duracion;
    private String actividadesPrevias;
    private String fechaLimite;
    private String resultado;
    private boolean obligatorio;
    private String reseñas;
    private double rating;
    private String autor;

 // Constructor


    public Actividad(String nombre, String tipo, String descripcion, String objetivo, String contenido, String dificultad, int duracion,
            String actividadesPrevias, String fechaLimite, boolean obligatorio, String autor) {
				
    			this.nombre = nombre;
				this.tipo = tipo;
				this.descripcion = descripcion;
				this.objetivo = objetivo;
				this.contenido = contenido;
				this.dificultad = dificultad;
				this.duracion = duracion;
				this.actividadesPrevias = actividadesPrevias;
				this.fechaLimite = fechaLimite;
				this.obligatorio = obligatorio;
				this.autor = autor;
    }
	

	// Getters para cada atributo
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public String getContenido() {
    	return contenido;
    }
    public String getDificultad() {
        return dificultad;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getActividadesPrevias() {
        return actividadesPrevias;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public String getResultado() {
        return resultado;
    }

    public boolean isObligatorio() {
        return obligatorio;
    }

    public String getReseñas() {
        return reseñas;
    }

    public double getRating() {
        return rating;
    }

    public String getAutor() {
        return autor;
    }
    
    public void setResultado(String resultado) {
        this.resultado= resultado ;
    }


    public void setReseñas(String reseña) {
        this.reseñas= reseña; 
    	
    }

    public void setRating(Double rating) {
        	this.rating= rating;
    }

 // Método para añadir una nueva actividad al HashMap y al archivo binario
    public void añadirActividad(HashMap<String, HashMap<String, Object>> actividadesMap, String nombreArchivo) {

        HashMap<String, Object> atributos = new HashMap<>();
        atributos.put("tipo", this.tipo);
        atributos.put("descripcion", this.descripcion);
        atributos.put("objetivo", this.objetivo);
        atributos.put("dificultad", this.dificultad);
        atributos.put("duracion", this.duracion);
        atributos.put("actividadesPrevias", this.actividadesPrevias);
        atributos.put("fechaLimite", this.fechaLimite);
        atributos.put("resultado", this.resultado);
        atributos.put("obligatorio", this.obligatorio);
        atributos.put("reseñas", this.reseñas);
        atributos.put("rating", this.rating);
        atributos.put("autor", this.autor);

        // Actualizar el HashMap en memoria con la nueva actividad
        actividadesMap.put(this.nombre, atributos);

        // Llamar a agregarActividad en ActividadLoader para almacenar en el archivo
        ActividadLoader.agregarActividad(this);
    }
	

	/** FUNCIONES */
	public void crearActividad() {
		
		
	}
	
	public void completarActividad() {
		Scanner input = new Scanner(System.in);
		System.out.println("Ingrese el resultado de la actividad: ");
		String result = input.next();
		this.resultado = result;
		input.close();
	}
}

