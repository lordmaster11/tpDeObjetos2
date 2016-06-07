package cliente;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ClienteTest {
	
	Cliente clienteTest;
	Date fechaNac;
	Date fechaIngreso;

	@Before
	public void setUp() throws Exception {
		Date fechaNac = new Date(11/02/80);
		Date fechaIngreso = new Date(06/06/16);
		
		clienteTest = new Cliente ("Juan", "Perez", 27950524, fechaNac,
			       "Necochea 662", "juanperez@gmail.com", fechaIngreso);
	}

	@Test
	public void testNuevoCliente() { 
		assertTrue(clienteTest.getNombre().equals("Juan"));
		assertTrue(clienteTest.getApellido().equals("Perez"));
		assertTrue(clienteTest.getDNI().equals(27950524));
		assertFalse(clienteTest.getFechaIngreso().equals(fechaIngreso));
	}
}
