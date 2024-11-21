
/*package clases.LearningPathTree;
import java.util.HashMap;
import java.io.IOException;
import java.util.ArrayList;
import Persistencia.ArchivoCSV;
// Clase del Learning Path
 
public class LearningPath {
	// ATRIBUTOS 
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
	//FUNCIONES 
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
	}
	
	public void leerActividades() throws IOException {
		ArrayList<String> textos = ArchivoCSV.leerArchivoCSV("Actividades.csv");
		for(String texto : textos) {
			String []valores = texto.split(",");
			Actividad ActividadLeida = new Actividad(valores[0], valores[1]);
			this.actividades.add(ActividadLeida);
		}
	}
}*/
package clases.LearningPathTree;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

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
	public String version;
    public HashMap<String, String> estructura;
    public List<Actividad> listaActividades;
	/** FUNCIONES */
	
	public void editarLearningPath(Actividad actividad) {
		
		boolean processing = true; 
		while (processing) 
		{
			System.out.println("1.) Agregar Actividad a LearningPath");
			System.out.println("2.) Eliminar Actividad de LearningPath");
			Scanner input = new Scanner(System.in);
			System.out.println("Seleccionar opción: ");
			String answer = input.next();
			int choice =Integer.parseInt(answer);
			input.close();
		
			if (choice == 1) {
				listaActividades.add(actividad);
				System.out.println("La Actividad ha sido añadida correctamente.");
				processing = false;
			} else if (choice == 2) {
				listaActividades.remove(actividad);
				System.out.println("La Actividad ha sido eliminada correctamente.");
				processing = false;
			} else  {
				System.out.println("Valor ingresado no funciona, intente otra vez.");
			}
		}
	}
	/*
	public LearningPath() {
		this.actividades = new ArrayList<Actividad>();
	}
	*public void agregarActividad(String nombre, String tipo) {
		Actividad nuevaActividad = new Actividad(nombre, tipo);
		this.actividades.add(nuevaActividad);
	}
	*/
	public HashMap<String, List<String>> cargarLearningPaths(HashMap<String, HashMap<String, String>> actividades) {
		
		// Este será el resultado
        HashMap<String, List<String>> agrupadasPorLearningPath = new HashMap<>();

        // Recorremos el HashMap original
        for (Entry<String, HashMap<String, String>> actividadEntry : actividades.entrySet()) {
            String nombreActividad = actividadEntry.getKey(); // Nombre de la actividad
            HashMap<String, String> atributos = actividadEntry.getValue(); // Atributos de la actividad

            // Obtenemos el valor de "learningPath"
            String learningPath = atributos.get("learningPath");

            // Si el learningPath es "no", lo ignoramos
            if ( learningPath == "no") {
                continue;
            }

            // Si el learningPath no está en el resultado, lo inicializamos
            agrupadasPorLearningPath.putIfAbsent(learningPath, new ArrayList<>());

            // Agregamos el nombre de la actividad a la lista correspondiente
            agrupadasPorLearningPath.get(learningPath).add(nombreActividad);
        }
        
        for (Entry<String, List<String>> entry : agrupadasPorLearningPath.entrySet()) {
            System.out.println("Learning Path: " + entry.getKey());
            System.out.println("Actividades: " + entry.getValue());
        }
        return agrupadasPorLearningPath;
	}
	
	
	
	/*public static void guardarActividad() throws IOException {
		ArrayList<String> textos = new ArrayList<String>();
		for(Actividad actividad : this.actividades) 
			textos.add(actividad.toString());
		
		ArchivoCSV.guardarTextoCSV(textos, "Actividades.csv");
	}*/
	
	
}

