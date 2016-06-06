package modelo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ModeloTest {

	Modelo modeloTest;
	
	@Before
	public void setUp() throws Exception {
		modeloTest = new Modelo ("Peugeot 206", 2000, 4, "Full", 60000f);
	}

	@Test
	public void testGetNombre() {
		assertTrue ( modeloTest.getNombre().equals("Peugeot 206"));
	}

}
