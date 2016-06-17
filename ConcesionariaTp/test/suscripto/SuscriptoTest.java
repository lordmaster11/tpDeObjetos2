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
		suscriptoTest = new Suscripto(clienteMock);	
	}

	@Test
	public void testNuevoSuscripto(){ 	
		
		Calendar fechaNac = new GregorianCalendar(1980, Calendar.FEBRUARY, 11);
		Date fechaInscripcion = new Date();
		Date fechaIngreso = new Date();
		
		when(clienteMock.getFechaNacimiento()).thenReturn(fechaNac);
		when(clienteMock.getFechaIngreso()).thenReturn(fechaIngreso);
	
		assertTrue(suscriptoTest.getFecNac().equals(fechaNac));
		assertTrue(suscriptoTest.getFechaDeIngreso().equals(fechaIngreso));
		assertTrue(suscriptoTest.getFechaDeInscripcion().equals(fechaInscripcion));		
	}
	
	@Test
	public void edadSuscriptotest() {
	when(clienteMock.edadCliente()).thenReturn(20);
	assertTrue(suscriptoTest.edadSuscripto().equals(20));
	}
	
	@Test
	public void aunNoFueAdjudicado() {
		assertTrue(suscriptoTest.aunNoFueAdjudicado().equals(true));
	}
	
	@Test
	public void fueAdjudicado() {
		suscriptoTest.seAdjudico();
		assertTrue(suscriptoTest.aunNoFueAdjudicado().equals(false));
	}
	
//	@Test
//	public void cantidadDeCuotasPagas() {
//		
//	}
}
