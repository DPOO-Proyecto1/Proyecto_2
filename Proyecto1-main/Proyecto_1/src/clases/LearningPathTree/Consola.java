package clases.LearningPathTree;

import java.util.Scanner;

public class Consola {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String usuario, contraseña;
        String rol;

        System.out.println("Bienvenido. Escriba 'salir' en cualquier momento para salir.");

        // Bucle que se repetirá hasta un login exitoso o hasta que el usuario decida salir
        while (true) {
            System.out.print("Ingrese su usuario (o 'salir' para finalizar): ");
            usuario = scanner.nextLine();

            if (usuario.equalsIgnoreCase("salir")) {
                System.out.println("Saliendo de la consola...");
                scanner.close();
                return; // Finalizar el programa
            }

            System.out.print("Ingrese su contraseña: ");
            contraseña = scanner.nextLine();

            // Llamada a la función de login
            rol = login(usuario, contraseña);

            if (rol.equals("fallido")) {
                System.out.println("Credenciales incorrectas. Intente nuevamente.\n");
            } else {
                break; // Salir del bucle si el rol es 'estudiante' o 'profesor'
            }
        }

        // Menú según el rol del usuario
        if (rol.equals("estudiante")) {
            mostrarOpcionesEstudiante(scanner);
        } else if (rol.equals("profesor")) {
            mostrarOpcionesProfesor(scanner);
        }

        scanner.close();
        System.out.println("Consola finalizada.");
    }

    // Simulación de función autenticación 
    public static String login(String user, String password) {
        if (user.equals("estudiante") && password.equals("1234")) {
            return "estudiante";
        } else if (user.equals("profesor") && password.equals("admin")) {
            return "profesor";
        } else {
            return "fallido";
        }
    }

    // estudiante
    public static void mostrarOpcionesEstudiante(Scanner scanner) {
        System.out.println("Opciones para estudiante:");
        System.out.println("a) Ver Learning pat");
        System.out.println("b) Iniciar actividad");
        System.out.println("c) Historial ");
        System.out.println("salir) Salir");
        Estudiante estudiante= new Estudiante();

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
    public static void mostrarOpcionesProfesor(Scanner scanner) {
        System.out.println("Opciones para profesor:");
        System.out.println("a) crear leaning path");
        System.out.println("b) editar learning path");
        System.out.println("c) crear actividad");
        System.out.println("d) editar actividad");
        System.out.println("e) clonar actividad");
        System.out.println("f) agregar actividad a lea");
        System.out.println("salir) Salir");
        
        Profesor profesor = new Profesor();
        
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

