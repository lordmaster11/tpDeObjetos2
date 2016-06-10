package cliente;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class ClienteTest {
	
	Cliente clienteTest;
	Date fechaNac;
	Date fechaIngreso;

	@Before
	public void setUp() throws Exception {
		Calendar fechaNac = new GregorianCalendar(1980, Calendar.FEBRUARY+1, 11);
		
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
/*	
	@Test
	public void testEdadCliente(){ 
		 fechaNac = new Date(11/02/1980);
		assertTrue(clienteTest.edadCliente().equals(36));
	}
*/
	
	@Test
	public void testEdadCliente2(){ 
		assertTrue((clienteTest.edadCliente2()).equals(36));
	}
/*	
	@Test
	public void testEdad(){ 
		Date fechaNac = new Date(02/11/1980);
		assertTrue((clienteTest.edad()).equals(46));
	}
*/	
}
		