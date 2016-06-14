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
	Cliente clienteTest2;
	Date fechaDeIngreso;

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
	public void testEdadClienteQueCumplioAnios(){ 
		
		assertTrue((clienteTest.edadCliente()).equals(36));
	}
	
	@Test
	public void testEdadClienteQueTodaviaNoCumplioAnios(){ 
		Calendar fechaNac = new GregorianCalendar(1980, Calendar.SEPTEMBER, 11);
		clienteTest2 = new Cliente ("Esteban", "Quito", 32980511, fechaNac,
			       "Av. Milito 22", "estebanquito@gmail.com");
		assertTrue((clienteTest2.edadCliente()).equals(35));
	}
	
	@Test
	public void testEdadClienteQueNacioElMismoDia(){ 
		Calendar fechaNac = Calendar.getInstance();
		clienteTest = new Cliente ("Juan", "Perez", 27950524, fechaNac,
			       "Necochea 662", "juanperez@gmail.com");
		assertTrue((clienteTest.edadCliente()).equals(0));
	}
}
		