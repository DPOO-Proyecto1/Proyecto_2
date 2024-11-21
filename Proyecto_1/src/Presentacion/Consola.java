package Presentacion;

import clases.LearningPathTree.Actividad;
import clases.LearningPathTree.Estudiante;
import clases.LearningPathTree.LearningPath;
import clases.LearningPathTree.Profesor;
import clases.LearningPathTree.Usuario;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Persistencia.ActividadLoader;

public class Consola {
	static HashMap<String, HashMap<String, Object>> actividades = ActividadLoader.cargarActividadesDesdeArchivo("Actividades.bin");
	//static HashMap<string, HashMap<String, Object>> learningPaths = learningPathLoader.cargarLearningPaths(actividades);
        
    public static void main(String[] args) throws Throwable {
        Scanner scanner = new Scanner(System.in);
        String correo, contraseña;
        String rol;
        String archivoCSV = "Usuarios.csv";
        List<Usuario> usuarios = Usuario.cargarUsuarios(archivoCSV);
        

        System.out.println("Bienvenido. Escriba 'salir' en cualquier momento para salir.");

        // Bucle que se repetirá hasta un login exitoso o hasta que el usuario decida salir
        while (true) {
            System.out.print("Ingrese su correo (o 'salir' para finalizar): ");
            correo = scanner.nextLine();

            if (correo.equalsIgnoreCase("salir")) {
                System.out.println("Saliendo de la consola...");
                scanner.close();
                return; // Finalizar el programa
            }

            System.out.print("Ingrese su contraseña: ");
            contraseña = scanner.nextLine();
            // Llamada a la función de login
            
            Object user = Usuario.verificarUsuario(usuarios, correo, contraseña); 

            if (user instanceof Estudiante) {
                Estudiante estudiante = (Estudiante) user;
                System.out.println("Bienvenido, " + estudiante.getUsername() + "!");
                mostrarOpcionesEstudiante(scanner, estudiante);
                
            } else if (user instanceof Profesor) {
                    Profesor profesor = (Profesor) user;
                    System.out.println("Bienvenido, " + profesor.getUsername() + "!");
                    mostrarOpcionesProfesor(scanner, profesor);
                    
            } else if (user instanceof String) {
                System.out.println((String) user); // Imprime el mensaje de error
            }
        }
    }


    public static void mostrarOpcionesEstudiante(Scanner scanner, Estudiante estudiante) {
            System.out.println("Opciones para estudiante:");
            System.out.println("a) Ver Learning pat");
            System.out.println("b) Iniciar actividad");
            System.out.println("c) Ver actividades");
            System.out.println("d) Historial");
            System.out.println("salir) Salir");
            //Estudiante estudiante= new Estudiante("usuario", "correo", "contraseña", "rol");
    
            while (true) {
                System.out.print("Seleccione una opción (a, b, c o 'salir' para finalizar): ");
                String opcion = scanner.nextLine();
    
                switch (opcion.toLowerCase()) {
                    case "a":
                        System.out.println("Opción A seleccionada.");
                        //estudiante.verLearningPath();
                    break;
                case "b":
                    System.out.println("Opción B seleccionada.");
                    //estudiante.realizarActividad();
                    break;
                case "c":
                	for (String nombre : actividades.keySet()) {
                        System.out.println(nombre + ": " + actividades.get(nombre));
                	}
                    break;
                    
                case "d":
                	System.out.println("Opción C seleccionada.");
                	break;
                case "salir":
                    System.out.println("Saliendo de las opciones de estudiante...");
                    return; // Regresar al menú principal
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
    
    // profesor
    public static void mostrarOpcionesProfesor(Scanner scanner, Profesor profesor) {
        System.out.println("Opciones para profesor:");
        System.out.println("a) crear leaning path");
        System.out.println("b) editar learning path");
        System.out.println("c) crear actividad");
        System.out.println("d) editar actividad");
        System.out.println("e) clonar actividad");
        System.out.println("f) agregar actividad a lea");
        System.out.println("salir) Salir");

        
        
        while (true) {
            System.out.print("Seleccione una opcion (a, b, c, d o 'salir' para finalizar): ");
            String opcion = scanner.nextLine();

            switch (opcion.toLowerCase()) {
	            case "a":
	                profesor.crearLearningPath();
	                break;
	            case "b":
	                profesor.editarLearningPath();
	                break;
	            case "c":
	            	Scanner input = new Scanner(System.in);
	            	System.out.println("Ingrese el NOMBRE de la actividad: ");
	                String name = input.next();
	                System.out.println("Ingrese el TIPO de la actividad: ");
	                String type = input.next();
	                System.out.println("ingrese la DESCRIPCIÓN de la actividad como un párrafo: ");
	                String description = input.next();
	                System.out.println("ingrese el objetivo de la actividad como un párrafo: ");
	                String objetivo = input.next();
	                System.out.println("ingrese la DIFICULTAD de la actividad: ");
	                String contenido = input.next();
	                System.out.println("ingrese el CONTENIDO de la actividad: ");
	                String dificultad = input.next();
	                System.out.println("ingrese la DURACIÓN de la actividad en minutos como un número entero: ");
	                int duration = input.nextInt();
	                System.out.println("ingrese las actividades previas a la actividad: ");
	                String actividadesprevisas = input.next();
	                System.out.println("ingrese la FECHA LÍMITE de la actividad: ");
	                String fechaLimite = input.next();
	                System.out.println("Es esta actividad OBLIGATORIA? [si/no]: ");
	                boolean required; input.next();
	                if (input.next() == "si") 
	                	{required = true;} 
	                else
	                	{required = false;}
	                
	                System.out.println("Ingrese su nombre para registrar AUTOR: ");
	                String author = input.next();
	                
	                
	                Actividad nuevaActividad = new Actividad(
	                		name, type, description,
	                		objetivo, contenido, dificultad, duration, actividadesprevisas, fechaLimite,
	                		required, author);
	                
	                    // Añadir la nueva actividad al HashMap y al archivo binario
	                    nuevaActividad.añadirActividad(actividades, "Actividades.bin");

	                    
	                break;
	            case "d":
	                profesor.editarActividad();
	                break;
	            case "e":
	                profesor.clonarActividad();
                    System.out.print("Actividades disponibles para clonar: "); 
	                break;
	            case "f":
	            	System.out.println("Opcion f seleccionada.");
                    break;
                case "salir":
                    System.out.println("Saliendo de las opciones de profesor...");
                    return; // Regresar al menú principal
                default:
                    System.out.println("Opción no valida.");
                    break;
            }
        }
    }
    
    
}

