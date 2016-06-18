package suscripto;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import cliente.Cliente;
import suscripto.Suscripto;

public class SuscriptoTest {
	
	Suscripto suscriptoTest;
	Cliente clienteMock;

	@Before
	public void setUp() throws Exception {
		clienteMock = mock(Cliente.class);
	}

	@Test
	public void testNuevoSuscripto(){ 	
		
		Calendar fechaNac = new GregorianCalendar(1980, Calendar.FEBRUARY, 11);
		Date fechaInscripcion = new Date();
		Date fechaIngreso = new Date();
		
		when(clienteMock.getFechaNacimiento()).thenReturn(fechaNac);
		when(clienteMock.getFechaIngreso()).thenReturn(fechaIngreso);
	
		suscriptoTest = new Suscripto(clienteMock);	
		
		assertTrue(suscriptoTest.getFecNac().equals(fechaNac));
		assertTrue(suscriptoTest.getFechaDeIngreso().equals(fechaIngreso));
		assertTrue(suscriptoTest.getFechaDeInscripcion().equals(fechaInscripcion));		
	}
	
	@Test 
	public void edadSuscriptotest() {

	suscriptoTest = new Suscripto(clienteMock);	
	when(clienteMock.edadCliente()).thenReturn(20);
	assertTrue(suscriptoTest.edadSuscripto().equals(20));
	}
	
	@Test
	public void aunNoFueAdjudicado() {

		suscriptoTest = new Suscripto(clienteMock);	
		assertTrue(suscriptoTest.todaviaNoFueAdjudicado().equals(true));
	}
	
	@Test
	public void fueAdjudicado() {

		suscriptoTest = new Suscripto(clienteMock);	
		suscriptoTest.seAdjudico();
		assertTrue(suscriptoTest.todaviaNoFueAdjudicado().equals(false));
	}
}
