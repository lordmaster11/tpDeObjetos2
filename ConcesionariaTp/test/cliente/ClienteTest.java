package cliente;

import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class ClienteTest {
	Cliente clienteTest;
	Cliente clienteTest2;
	Calendar fechaIngreso;
	Calendar fechaNac;

	@Before
	public void setUp() throws Exception {
		fechaNac = new GregorianCalendar(1980, Calendar.FEBRUARY, 11);
		fechaIngreso = Calendar.getInstance();		
		clienteTest = new Cliente ("Juan", "Perez", 27950524, fechaNac,
									"Necochea 662", "juanperez@gmail.com");
	}

	@Test
	public void getNombreTest(){ 	
		assertTrue(clienteTest.getNombre().equals("Juan"));	
	}
	
	@Test
	public void getApellidoTest(){ 	
		assertTrue(clienteTest.getApellido().equals("Perez"));
	}
	
	@Test
	public void getDNITest(){ 	
		assertTrue(clienteTest.getDNI().equals(27950524));
	}
	
	@Test
	public void getFechaNacimientoTest(){ 	
		assertTrue(clienteTest.getFechaNacimiento().equals(fechaNac));
	}
	
	@Test
	public void getFechaIngresoTest(){ 	
		assertTrue(clienteTest.getFechaIngreso().equals(fechaIngreso));	
	}
	
	@Test
	public void testEdadClienteQueCumplioAnios(){ 	
		assertTrue((clienteTest.edadCliente()).equals(36));
	}
	
	@Test
	public void testEdadClienteQueTodaviaNoCumplioAnios(){ 
		Calendar fechaNacimiento = new GregorianCalendar(1980, Calendar.SEPTEMBER, 11);
		clienteTest2 = new Cliente ("Esteban", "Quito", 32980511, fechaNacimiento,
			       "Av. Milito 22", "estebanquito@gmail.com");
		assertTrue((clienteTest2.edadCliente()).equals(35));
	}
	
	@Test
	public void testEdadClienteQueTodaviaNoCumplioAnios2(){ 
		Calendar fechaNacimiento = new GregorianCalendar(1980, Calendar.JULY, 30);
		clienteTest = new Cliente ("Juan", "Perez", 27950524, fechaNacimiento,
			       "Necochea 662", "juanperez@gmail.com");
		assertTrue((clienteTest.edadCliente()).equals(35));
	}
	
	@Test
	public void testEdadClienteQueNacioElMismoDia(){ 
		Calendar fechaNacimiento = Calendar.getInstance();
		clienteTest2 = new Cliente ("Esteban", "Quito", 32980511, fechaNacimiento,
			       "Av. Milito 22", "estebanquito@gmail.com");
		assertTrue((clienteTest2.edadCliente()).equals(0));
	}
}	