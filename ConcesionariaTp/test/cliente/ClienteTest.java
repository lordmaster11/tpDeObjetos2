package cliente;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ClienteTest {
	
	Cliente clienteTest;
	Date fechaNac;
	Date fechaIngreso;

	@Before
	public void setUp() throws Exception {
		Date fechaNac = new Date(02/11/80);
		
		clienteTest = new Cliente ("Juan", "Perez", 27950524, fechaNac,
			       "Necochea 662", "juanperez@gmail.com");
	}

	@Test
	
	public void testNuevoCliente(){ 	
		Date fechaIngreso = new Date();
		
		assertTrue(clienteTest.getNombre().equals("Juan"));
		assertTrue(clienteTest.getApellido().equals("Perez"));
		assertTrue(clienteTest.getDNI().equals(27950524));
		assertTrue(clienteTest.getFechaIngreso().equals(fechaIngreso));	
	}
	
	@Test
	public void testEdadCliente(){ 
		assertTrue(clienteTest.edadCliente().equals(47));
	}
	
	@Test
	public void testEdad(){ 
		assertTrue((clienteTest.edad()).equals(46));
	}
	
	@Test
	public void testEdad2(){ 
		assertTrue((clienteTest.edadCliente2()).equals(46));
	}
}
		