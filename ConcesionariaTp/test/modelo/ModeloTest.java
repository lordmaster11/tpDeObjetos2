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
		assertTrue (modeloTest.getNombre().equals("Peugeot 206"));
	}

	@Test
	public void testGetValorVenta() {
		assertTrue (modeloTest.getValorVenta().equals(60000f));
	}
	
	@Test
	public void testSetPrecio() {
		modeloTest.setPrecio(70000f);
		assertTrue(modeloTest.getValorVenta().equals(70000f));
	}
}