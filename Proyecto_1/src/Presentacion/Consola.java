/*package Presentacion;

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
}*/

package Presentacion;
import clases.LearningPathTree.Estudiante;
import clases.LearningPathTree.Profesor;
import clases.LearningPathTree.Usuario;

import java.util.List;
import java.util.Scanner;

public class Consola {

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
            System.out.print("Ingrese su rol estudiante o profesor ");
            rol = scanner.nextLine();
            // Llamada a la función de login
            boolean identificacionCorrecta = Usuario.verificarUsuario(usuarios, rol, correo, contraseña); 

            if (identificacionCorrecta){
                if (rol.equals("estudiante")) {
                    
                    Estudiante estudiante= new Estudiante(correo, correo, contraseña, rol);
                    mostrarOpcionesEstudiante(scanner, estudiante);
                } else if (rol.equals("profesor")) {
                    Profesor profesor= new Profesor(correo, correo, contraseña, rol);
                    mostrarOpcionesProfesor(scanner, profesor);
                }
                
            } else {
                System.out.println("Credenciales incorrectas. Intente nuevamente.\n");
            }
        }

        // Menú según el rol del usuario
        

        //scanner.close();
        //System.out.println("Consola finalizada.");
    }

    // Simulación de función autenticación 
    /*public static String login(String user, String password) {
        if (user.equals("estudiante") && password.equals("1234")) {
            return "estudiante";
        } else if (user.equals("profesor") && password.equals("admin")) {
            return "profesor";
        } else {
            return "fallido";
        }
    }*/

    // estudiante
    public static void mostrarOpcionesEstudiante(Scanner scanner, Estudiante estudiante) {
            System.out.println("Opciones para estudiante:");
            System.out.println("a) Ver Learning pat");
            System.out.println("b) Iniciar actividad");
            System.out.println("c) Historial ");
            System.out.println("salir) Salir");
            //Estudiante estudiante= new Estudiante("usuario", "correo", "contraseña", "rol");
    
            while (true) {
                System.out.print("Seleccione una opción (a, b, c o 'salir' para finalizar): ");
                String opcion = scanner.nextLine();
    
                switch (opcion.toLowerCase()) {
                    case "a":
                        System.out.println("Opción A seleccionada.");
                        estudiante.verLearningPath();
                    break;
                case "b":
                    System.out.println("Opción B seleccionada.");
                    estudiante.realizarActividad();
                    break;
                case "c":
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
            System.out.print("Seleccione una opcion (d, e, c o 'salir' para finalizar): ");
            String opcion = scanner.nextLine();

            switch (opcion.toLowerCase()) {
	            case "a":
	                profesor.crearLearningPath();
	                break;
	            case "b":
	                profesor.editarLearningPath();
	                break;
	            case "c":
	                profesor.crarActividad();
	                break;
	            case "d":
	                profesor.editarActividad();
	                break;
	            case "e":
	                profesor.clonarActividad();
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

