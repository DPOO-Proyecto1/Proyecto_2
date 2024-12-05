package Persistencia;

import java.io.*;
import java.util.HashMap;

import clases.LearningPathTree.LearningPath;

public class LearningPathLoader {

    // Método para cargar LearningPaths desde el archivo binario
    public static HashMap<String, LearningPath> cargarLearningPathsDesdeArchivo(String nombreArchivo) {
        HashMap<String, LearningPath> learningPathsMap = new HashMap<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            while (true) {
                try {
                    LearningPath learningPath = (LearningPath) ois.readObject();
                    learningPathsMap.put(learningPath.getTitulo(), learningPath);
                } catch (EOFException e) {
                    // Fin del archivo alcanzado
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los LearningPaths: " + e.getMessage());
        }

        return learningPathsMap;
    }

    // Método para agregar un nuevo LearningPath al archivo binario
    public static void agregarLearningPath(LearningPath nuevoLearningPath) {
        File archivo = new File("LearningPaths.bin");

        try {
            if (archivo.exists()) {
                try (AppendableObjectOutputStream oos = new AppendableObjectOutputStream(new FileOutputStream(archivo, true))) {
                    oos.writeObject(nuevoLearningPath); // Escribir el objeto LearningPath en el archivo
                    System.out.println("LearningPath agregado exitosamente.");
                }
            } else {
                // Si el archivo no existe, crea uno nuevo con ObjectOutputStream
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
                    oos.writeObject(nuevoLearningPath);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al agregar el LearningPath: " + e.getMessage());
        }
    }

    // Método para actualizar ciertos atributos de un LearningPath en el archivo binario
    public static void actualizarLearningPath(String titulo, int nuevaDuracion, float nuevoRating, 
                                              String nuevaFechaDeModificacion, 
                                              String nuevasActividades) {
        File archivo = new File("LearningPaths.bin");

        if (!archivo.exists()) {
            System.out.println("El archivo de LearningPaths no existe.");
            return;
        }

        try {
            // Leer todos los LearningPaths del archivo
            HashMap<String, LearningPath> learningPaths = new HashMap<>();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                while (true) {
                    try {
                        LearningPath learningPath = (LearningPath) ois.readObject();
                        learningPaths.put(learningPath.getTitulo(), learningPath);
                    } catch (EOFException e) {
                        break;
                    }
                }
            }

            // Modificar el LearningPath correspondiente
            if (learningPaths.containsKey(titulo)) {
                LearningPath learningPath = learningPaths.get(titulo);
                learningPath.setDuracion(nuevaDuracion);
                learningPath.setRating(nuevoRating);
                learningPath.setFechaDeModificacion(nuevaFechaDeModificacion);
                learningPath.setVersion();
                learningPath.setActividades(nuevasActividades);
            } else {
                System.out.println("El LearningPath con título '" + titulo + "' no existe.");
                return;
            }

            // Reescribir todos los LearningPaths al archivo
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
                for (LearningPath learningPath : learningPaths.values()) {
                    oos.writeObject(learningPath);
                }
            }

            System.out.println("LearningPath actualizado exitosamente.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al actualizar el LearningPath: " + e.getMessage());
        }
    }
}
