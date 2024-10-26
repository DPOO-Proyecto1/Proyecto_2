package clases.LearningPathTree;
import java.util.Scanner;

public class Usuario 
{
	public String username;
	public String password;
	public String email;
	public String rol;
	
	public void login() 
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
	}
	
	public void logout() {
		System.out.println("Ha salido correctamente del sistema.");
	}
}
