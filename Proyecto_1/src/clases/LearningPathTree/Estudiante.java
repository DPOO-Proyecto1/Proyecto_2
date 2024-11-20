package clases.LearningPathTree;


public class Estudiante extends Usuario {
    private boolean ocupado;

    // Constructor de Estudiante que llama al constructor de Usuario
    public Estudiante(String username, String email, String password, boolean ocupado) {
        super(username, email, password, "estudiante"); // Llama al constructor de Usuario
        this.ocupado = ocupado;
    }

    // Getter y Setter para el atributo adicional
    public boolean getOccupado() {
        return ocupado;
    }

    public void setocupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public String toString() {
        return super.toString() + ", Grado: " + ocupado;
    }
}