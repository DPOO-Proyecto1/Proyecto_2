/*package clases.LearningPathTree;

public class Usuario {
	public String username;
	public String password;
	public String email;
	public String rol;
	
	public void login() {
		
	}
	
	public void logout() {
		
	}
}*/
package clases.LearningPathTree;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Usuario 
{
	private String username;
	private String password;
	private String email;
	private String rol;
	private boolean ocupado;
	
	
	public Usuario(String username, String email, String password, String rol) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.rol = rol;
	 }
  
	 public String getUsername() {
		return this.username;
	 }
  
	 public String getEmail() {
		return this.email;
	 }
  
	 public String getPassword() {
		return this.password;
	 }
  
	 public String getRol() {
		return this.rol;
	 }
	 public boolean getOcupado(){
		 return this.ocupado;
	 }
	 
	public static List<Usuario> cargarUsuarios(String archivoCSV) throws Throwable {
      List<Usuario> usuarios = new ArrayList<Usuario>();
	  BufferedReader br = null; 

         try {
            br = new BufferedReader(new FileReader(archivoCSV));

            String linea;
            
               while((linea = br.readLine()) != null) {
                  String[] datos = linea.split(",");
                  if (datos.length == 4) {
                     String username = datos[0].trim();
                     String correo = datos[1].trim();
                     String contraseña = datos[2].trim();
                     String rol = datos[3].trim();
                     usuarios.add(new Usuario(username, correo, contraseña, rol));
                  }
               }
            } catch (IOException e) {
				e.printStackTrace();
				throw e;  // Vuelve a lanzar la excepción si es necesario
			} finally {
				if (br != null) {
					try {
						br.close();  // Asegúrate de cerrar el BufferedReader en el bloque finally
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		
		return usuarios;
   }

	public static Object verificarUsuario(List<Usuario> usuarios, String correo, String contraseña) {
	    for (Usuario usuario : usuarios) {
	        if (usuario.getEmail().equals(correo) && usuario.getPassword().equals(contraseña)) {
	        	if (usuario.getRol() == "estudiante") {
	        		Estudiante estudiante = new Estudiante(
	        			    usuario.getUsername(),
	        			    usuario.getEmail(),
	        			    usuario.getPassword(),
	        			    usuario.getOcupado());
	        		return estudiante;
	        	}
	        	else {
	        		Profesor profesor = new Profesor(
	        			    usuario.getUsername(),
	        			    usuario.getEmail(),
	        			    usuario.getPassword());
	        		return profesor;
	        		
	        	}
	        }
	    }
	    return "Usuario o contraseña incorrectos"; // Devuelve un mensaje si no se encuentra el usuario
	}
}
