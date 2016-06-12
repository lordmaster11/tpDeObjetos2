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
	
	@Test
	public void testEdadCliente2(){ 
		
		assertTrue((clienteTest.edadCliente()).equals(36));
	}
	
	@Test
	public void testEdadCliente3(){ 
		Calendar fechaNac = new GregorianCalendar(1980, Calendar.DECEMBER+1, 11);
		clienteTest = new Cliente ("Juan", "Perez", 27950524, fechaNac,
			       "Necochea 662", "juanperez@gmail.com");
		assertTrue((clienteTest.edadCliente()).equals(35));
	}
	
	@Test
	public void testEdadCliente4(){ 
		Calendar fechaNac = new GregorianCalendar(2016, Calendar.MAY +1, 11);
		clienteTest = new Cliente ("Juan", "Perez", 27950524, fechaNac,
			       "Necochea 662", "juanperez@gmail.com");
		assertTrue((clienteTest.edadCliente()).equals(35));
	}
}
		