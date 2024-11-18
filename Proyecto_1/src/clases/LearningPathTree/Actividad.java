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
    private String nombre;
    private String tipo;
    private String descripcion;
    private String objetivo;
    private String dificultad;
    private int duracion;
    private String actividadesPrevias;
    private String fechaLimite;
    private String resultado;
    private boolean obligatorio;
    private String reseñas;
    private double rating;
    private String autor;
    private String learningPath;

 // Constructor
    public Actividad(String nombre, String tipo, String descripcion, String objetivo, String dificultad, int duracion,
                     String actividadesPrevias, String fechaLimite, String resultado, boolean obligatorio,
                     String reseñas, double rating, String autor, String learningPath) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.dificultad = dificultad;
        this.duracion = duracion;
        this.actividadesPrevias = actividadesPrevias;
        this.fechaLimite = fechaLimite;
        this.resultado = resultado;
        this.obligatorio = obligatorio;
        this.reseñas = reseñas;
        this.rating = rating;
        this.autor = autor;
        this.learningPath = learningPath;
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

    public String getLearningPath() {
        return learningPath;
    }
    
 // Método para añadir una nueva actividad al HashMap y al archivo binario
    public void añadirActividad(HashMap<String, HashMap<String, Object>> actividadesMap, String nombreArchivo) {
        // Crear un HashMap para los atributos de la actividad
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
        atributos.put("learningPath", this.learningPath);

        // Actualizar el HashMap en memoria con la nueva actividad
        actividadesMap.put(this.nombre, atributos);

        // Llamar a agregarActividad en ActividadLoader para almacenar en el archivo
        ActividadLoader.agregarActividad(this, nombreArchivo);
    }

    //cambios Camilo
	

	/** FUNCIONES */
	public void crearActividad() {
		
		Scanner input = new Scanner(System.in);
		
		// NOMBRE
        System.out.println("Ingrese el NOMBRE de la actividad: ");
        String name = input.next();
        this.nombre = name;
        
        // TIPO
        System.out.println("Ingrese el TIPO de la actividad: ");
        String type = input.next();
        this.tipo = type;
        
        // DESCRIPCIÓN
        System.out.println("ingrese la DESCRIPCIÓN de la actividad como un párrafo: ");
        String description = input.next();
        this.descripcion = description;
        
        // DESCRIPCIÓN
        System.out.println("ingrese el OBJETIVO de la actividad: ");
        String objective = input.next();
        this.objetivo = objective;
        
        // NIVEL DIFICULTAD
        System.out.println("ingrese la DIFICULTAD de la actividad: ");
        String level = input.next();
        this.descripcion = level;
        
        // DURACIÓN
        System.out.println("ingrese la DURACIÓN de la actividad en minutos como un número entero: ");
        int duration = input.nextInt();
        this.duracion = duration;
        
        // FECHA LÍMITE
        System.out.println("ingrese la FECHA LÍMITE de la actividad: ");
        String limitDate = input.next();
        this.fechaLimite = limitDate;
        
        // OBLIGATORIO
        System.out.println("Es esta actividad OBLIGATORIA? [Y/N]: ");
        String required = input.next();
        if (required == "Y") 
        {this.obligatorio = true;} 
        else
        {this.obligatorio = false;}
        
     // NOMBRE
        System.out.println("Ingrese su nombre para registrar AUTOR: ");
        String author = input.next();
        this.autor = author;
        
        input.close();
	}
	
	public void completarActividad() {
		Scanner input = new Scanner(System.in);
		System.out.println("Ingrese el resultado de la actividad: ");
		String result = input.next();
		this.resultado = result;
		input.close();
	}
}

