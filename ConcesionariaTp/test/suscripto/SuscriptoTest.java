package suscripto;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import cliente.Cliente;
import comprobanteDePago.ComprobanteDePago;
import planDeAhorro.PlanDeAhorro;
import suscripto.Suscripto;

public class SuscriptoTest {
	
	Suscripto suscriptoTest;
	Cliente clienteMock;
	PlanDeAhorro planDeAhorroMock;
	ComprobanteDePago comprobanteMock;

	@Before
	public void setUp() throws Exception {
		clienteMock = mock(Cliente.class);
		planDeAhorroMock = mock(PlanDeAhorro.class);
		comprobanteMock = mock(ComprobanteDePago.class);
	}

	/**
	 * supuestamente esta bien y da verde pero a veces da rojo
	 * assertTrue(suscriptoTest.getFechaDeInscripcion().equals(fechaInscripcion));		
	 */
	
	@Test
	public void testNuevoSuscripto(){ 	
		
		Calendar fechaNac = new GregorianCalendar(1980, Calendar.FEBRUARY, 11);
		Date fechaInscripcion = new Date();
		Date fechaIngreso = new Date();
		
		when(clienteMock.getFechaNacimiento()).thenReturn(fechaNac);
		when(clienteMock.getFechaIngreso()).thenReturn(fechaIngreso);
	
		suscriptoTest = new Suscripto(clienteMock, planDeAhorroMock);	
		
		assertTrue(suscriptoTest.getFecNac().equals(fechaNac));
		assertTrue(suscriptoTest.getFechaDeIngreso().equals(fechaIngreso));
		assertTrue(suscriptoTest.getFechaDeInscripcion().equals(fechaInscripcion));		
	}
	
	@Test 
	public void edadSuscriptotest() {

	suscriptoTest = new Suscripto(clienteMock, planDeAhorroMock);	
	when(clienteMock.edadCliente()).thenReturn(20);
	assertTrue(suscriptoTest.edadSuscripto().equals(20));
	}
	
	@Test
	public void aunNoFueAdjudicado() {

		suscriptoTest = new Suscripto(clienteMock, planDeAhorroMock);	
		assertTrue(suscriptoTest.todaviaNoFueAdjudicado().equals(true));
	}
	
	@Test
	public void fueAdjudicado() {

		suscriptoTest = new Suscripto(clienteMock, planDeAhorroMock);	
		suscriptoTest.seAdjudico();
		assertTrue(suscriptoTest.todaviaNoFueAdjudicado().equals(false));
	}
	
	/**
	 * esta re mal testeado lo dejo para seguir o para q lo arregles vos
	 */
	
	@Test
	public void cantidadCuotasPagasTest() {

		suscriptoTest.pagarCuota(planDeAhorroMock);;	
		verify(comprobanteMock).agregarCuota();
		suscriptoTest.agregarComprobante(comprobanteMock);
		assertTrue(((Integer)(suscriptoTest.getComprobantes()).size()).equals(1));
	}
	
}
