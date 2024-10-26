/**
 * 
 */
package clases.LearningPathTree;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
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
}
