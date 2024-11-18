package Pruebas_Junit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import clases.LearningPathTree.Usuario;

public class UsuarioTest {
	private Usuario usuario;
	
	@BeforeEach
	void setUp() throws Exception {
		usuario.username = "name";
		usuario.email = "email";
		usuario.password = "password";
		usuario.rol = "rol";
	}
	
	@AfterEach
	void tearDown() throws Exception {};
	
	@Test
	void testGetUsername() {
		assertEquals("testUsername", usuario.getUsername(), "El nombre de usuario no fue el esperado!");
	}
	
	@Test
	void testGetEmail() {
		assertEquals("testEmail", usuario.getEmail(), "El e-mail no fue el esperado!");
	}
	
	void testGetPassword() {
		assertEquals("testPassword", usuario.getPassword(), "La contraseña no fue la esperada!");
	}
	
	void testGetRol() {
		assertEquals("testRole", usuario.getRol(), "El rol no fue el esperado!");
	}
}
