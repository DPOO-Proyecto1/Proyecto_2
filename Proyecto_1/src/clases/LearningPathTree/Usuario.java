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
import java.util.Scanner;

public class Usuario 
{
	public String username;
	public String password;
	public String email;
	public String rol;
	
	/*public void login() 
	{
		boolean processing = true;
		while (processing) 
		{
			Scanner input = new Scanner(System.in);
	        System.out.println("USUARIO: ");
	        String usuario = input.next();
	        input.close();
	        if (usuario != "name")
	        {System.out.println("Usuario no existe, revise errores de ortografía e intente otra vez.");}
	        else 
	        {
	        	System.out.println("Usuario encontrado!");
	        	System.out.println("CONTRASEÑA: ");
	        	String contraseña = input.next();
		        input.close();
		        if (contraseña != "contraseña")
		        {System.out.println("Contraseña incorrecta, por favor intente otra vez.");}
	        }
	     }
	}*/
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
	public static List<Usuario> cargarUsuarios(String archivoCSV) throws Throwable {
      List<Usuario> usuarios = new ArrayList<Usuario>();

      try {
         Throwable var2 = null;
         Throwable var18 = null;
         
         try {
            BufferedReader br = new BufferedReader(new FileReader(archivoCSV));

            String linea;
            try {
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
            } finally {
               if (br != null) {
                  br.close();
               }

            }
         } catch (Throwable var18) {
            if (var2 == null) {
               var2 = var18;
            } else if (var2 != var18) {
               var2.addSuppressed(var18);
            }

            throw var2;
         }
      } catch (IOException var19) {
         var19.printStackTrace();
      }

      return usuarios;
   }

   public static boolean verificarUsuario(List<Usuario> usuarios, String rol, String correo, String contraseña) {
      Iterator<Usuario> var5 = usuarios.iterator();

      Usuario usuario;
      do {
         if (!var5.hasNext()) {
            return false;
         }

         usuario = (Usuario)var5.next();
      } while(!usuario.getRol().equals(rol) || !usuario.getEmail().equals(correo) || !usuario.getPassword().equals(contraseña));

      return true;
   }
	
	public void logout() {
		System.out.println("Ha salido correctamente del sistema.");
	}
}
