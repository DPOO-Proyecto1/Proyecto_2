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
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class Actividad {
	/** ATRIBUTOS */
	public String nombre;
	public String tipo;
	public String descripcion;
	public String objetivo;
	public String nivelDificultad;
	public int duracion;
	public List<Actividad> actividadesPrevias;
	public String fechaLimite;
	public String resultado;
	public boolean obligatorio;
	public List<String> reseñas;
	public List<Float> rating;
	public String autor;
	
	public Actividad(String string, String string2) {
		//TODO Auto-generated constructor stub
	}

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

