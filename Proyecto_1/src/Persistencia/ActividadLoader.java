package Persistencia;

import java.io.*;
import java.util.HashMap;

import clases.LearningPathTree.Actividad;

public class ActividadLoader {

    public static HashMap<String, HashMap<String, Object>> cargarActividadesDesdeArchivo(String nombreArchivo) {
        HashMap<String, HashMap<String, Object>> actividadesMap = new HashMap<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            while (true) {
                try {
                    Actividad actividad = (Actividad) ois.readObject();

                    // Crear un HashMap para los atributos de la actividad
                    HashMap<String, Object> atributos = new HashMap<>();
                    atributos.put("tipo", actividad.getTipo());
                    atributos.put("descripcion", actividad.getDescripcion());
                    atributos.put("objetivo", actividad.getObjetivo());
                    atributos.put("dificultad", actividad.getDificultad());
                    atributos.put("duracion", actividad.getDuracion());
                    atributos.put("actividadesPrevias", actividad.getActividadesPrevias());
                    atributos.put("fechaLimite", actividad.getFechaLimite());
                    atributos.put("resultado", actividad.getResultado());
                    atributos.put("obligatorio", actividad.isObligatorio());
                    atributos.put("reseñas", actividad.getReseñas());
                    atributos.put("rating", actividad.getRating());
                    atributos.put("autor", actividad.getAutor());
                    atributos.put("learningPath", actividad.getLearningPath());

                    // Almacenar el HashMap en actividadesMap usando el nombre de la actividad como clave
                    actividadesMap.put(actividad.getNombre(), atributos);

                } catch (EOFException e) {
                    // Fin del archivo alcanzado
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar las actividades: " + e.getMessage());
        }

        return actividadesMap;
    }

    // Método para agregar una nueva actividad al archivo binario
    public static void agregarActividad(Actividad nuevaActividad, String nombreArchivo) {
        try (AppendableObjectOutputStream oos = new AppendableObjectOutputStream(new FileOutputStream(nombreArchivo, true))) {
            oos.writeObject(nuevaActividad); // Escribir el objeto actividad en el archivo
            System.out.println("Actividad agregada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al agregar la actividad: " + e.getMessage());
        }
    }
}
