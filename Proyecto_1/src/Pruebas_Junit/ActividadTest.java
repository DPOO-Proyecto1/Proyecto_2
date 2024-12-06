package Pruebas_Junit;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import clases.LearningPathTree.Actividad;

public class ActividadTest {
	private Actividad actividad;
	
	@BeforeEach
	void setUp() throws Exception {
		actividad.crearActividad();
	}
	
	@AfterEach
	void tearDown() throws Exception {};
	
	// TESTS 
	@Test
	void testGetNombre() {
		Assertions.assertEquals("tempName", actividad.getNombre(), "El nombre de la Actividad no fue el esperado!");
	}
	
	@Test
	void testGetTipo() {
		Assertions.assertEquals("tempActivity", actividad.getTipo(), "El tipo de actividad no fue el esperado!");
	}
	
	@Test
	void testGetDescripcion() {
		Assertions.assertEquals("tempDescription", actividad.getDescripcion(), "La descripción de la actividad no fue el esperado!");
	}
	
	@Test
	void testGetObjetivo() {
		Assertions.assertEquals("tempObjective", actividad.getObjetivo(), "El objetivo de la actividad no fue el esperado!");
	}
	
	@Test
	void testGetDificultad() {
		Assertions.assertEquals("tempDifficulty", actividad.getDificultad());
	}
	
	@Test
	void testGetDuracion() {
		Assertions.assertEquals(0, actividad.getDuracion(), "La duración de la actividad no fue la esperada!");
	}
	
	@Test
	void testGetActividadesPrevias() {
		Assertions.assertEquals("tempPreviousActivities", actividad.getActividadesPrevias());
	}
	
	@Test
	void testIsObligatorio() {
		Assertions.assertEquals(true, actividad.isObligatorio());
	}
	
	@Test
	void testGetReseñas() {
		Assertions.assertEquals("tempreviews", actividad.getReseñas());
	}
	
	@Test
	void testGetRating() {
		Assertions.assertEquals(0.00, actividad.getReseñas());
	}
	
	@Test
	void testGetAutor() {
		Assertions.assertEquals("tempAuthor", actividad.getAutor());
	}
}
