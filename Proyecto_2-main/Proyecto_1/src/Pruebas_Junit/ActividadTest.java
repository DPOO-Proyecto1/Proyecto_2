package Pruebas_Junit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
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
		assertEquals("tempName", actividad.getNombre(), "El nombre de la Actividad no fue el esperado!");
	}
	
	@Test
	void testGetTipo() {
		assertEquals("tempActivity", actividad.getTipo(), "El tipo de actividad no fue el esperado!");
	}
	
	@Test
	void testGetDescripcion() {
		assertEquals("tempDescription", actividad.getDescripcion(), "La descripción de la actividad no fue el esperado!");
	}
	
	@Test
	void testGetObjetivo() {
		assertEquals("tempObjective", actividad.getObjetivo(), "El objetivo de la actividad no fue el esperado!");
	}
	
	@Test
	void testGetDificultad() {
		assertEquals("tempDifficulty", actividad.getDificultad());
	}
	
	@Test
	void testGetDuracion() {
		assertEquals(0, actividad.getDuracion(), "La duración de la actividad no fue la esperada!");
	}
	
	@Test
	void testGetActividadesPrevias() {
		assertEquals("tempPreviousActivities", actividad.getActividadesPrevias());
	}
	
	@Test
	void testIsObligatorio() {
		assertEquals(true, actividad.isObligatorio());
	}
	
	@Test
	void testGetReseñas() {
		assertEquals("tempreviews", actividad.getReseñas());
	}
	
	@Test
	void testGetRating() {
		assertEquals(0.00, actividad.getReseñas());
	}
	
	@Test
	void testGetAutor() {
		assertEquals("tempAuthor", actividad.getAutor());
	}
	
	@Test
	void testGetLearningPath() {
		assertEquals("tempLearningPath", actividad.getLearningPath());
	}
}
