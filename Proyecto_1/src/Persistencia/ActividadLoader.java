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
    public static void agregarActividad(Actividad nuevaActividad) {
        File archivo = new File("Actividades.bin");

        try {
            if (archivo.exists()) {
                try (AppendableObjectOutputStream oos = new AppendableObjectOutputStream(new FileOutputStream(archivo, true))) {
                    oos.writeObject(nuevaActividad); // Escribir el objeto actividad en el archivo
                    System.out.println("Actividad agregada exitosamente.");
                }
            } else {
                // Si el archivo no existe, crea uno nuevo con ObjectOutputStream
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
                    oos.writeObject(nuevaActividad);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al agregar la actividad: " + e.getMessage());
        }
    }

    // Método para actualizar los atributos de una actividad en el archivo binario
    public static void actualizarActividad(String nombreActividad, String nuevoResultado, String nuevaReseña, double nuevoRating) {
        File archivo = new File("Actividades.bin");

        if (!archivo.exists()) {
            System.out.println("El archivo de actividades no existe.");
            return;
        }

        try {
            // Leer todas las actividades del archivo
            HashMap<String, Actividad> actividades = new HashMap<>();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                while (true) {
                    try {
                        Actividad actividad = (Actividad) ois.readObject();
                        actividades.put(actividad.getNombre(), actividad);
                    } catch (EOFException e) {
                        break;
                    }
                }
            }

            // Modificar la actividad correspondiente
            if (actividades.containsKey(nombreActividad)) {
                Actividad actividad = actividades.get(nombreActividad);
                actividad.setResultado(nuevoResultado);
                actividad.setReseñas(nuevaReseña);
                actividad.setRating(nuevoRating);
            } else {
                System.out.println("La actividad con nombre '" + nombreActividad + "' no existe.");
                return;
            }

            // Reescribir todas las actividades al archivo
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
                for (Actividad actividad : actividades.values()) {
                    oos.writeObject(actividad);
                }
            }

            System.out.println("Actividad actualizada exitosamente.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al actualizar la actividad: " + e.getMessage());
        }
    }
}
