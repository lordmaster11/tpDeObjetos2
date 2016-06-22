package suscripto;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import cliente.Cliente;
import comprobanteDePago.ComprobanteDePago;
import concesionaria.Concesionaria;
import planDeAhorro.PlanDeAhorro;
import suscripto.Suscripto;

public class SuscriptoTest {	
	Suscripto suscriptoTest;
	Cliente clienteMock;
	PlanDeAhorro planDeAhorroMock;
	ComprobanteDePago comprobanteMock;
	Concesionaria consecionariaMock;

	@Before
	public void setUp() throws Exception {
		consecionariaMock = mock(Concesionaria.class);
		clienteMock = mock(Cliente.class);
		planDeAhorroMock = mock(PlanDeAhorro.class);
		comprobanteMock = mock(ComprobanteDePago.class);
	}

	@Test
	public void testNuevoSuscripto(){ 	
		Calendar fechaNac = new GregorianCalendar(1980, Calendar.FEBRUARY, 11);
		Calendar fechaInscripcion = new GregorianCalendar();
		Calendar fechaIngreso = new GregorianCalendar();
		
		when(clienteMock.getFechaNacimiento()).thenReturn(fechaNac);
		when(clienteMock.getFechaIngreso()).thenReturn(fechaIngreso);
	
		suscriptoTest = new Suscripto(clienteMock, planDeAhorroMock);	
		
		assertTrue(suscriptoTest.getFecNac().equals(fechaNac));
		assertTrue(suscriptoTest.getFechaDeIngreso().equals(fechaIngreso));
		assertTrue(suscriptoTest.getFechaDeInscripcion().equals(fechaIngreso));		
	} 
	
	@Test 
	public void edadSuscriptotest() {
		suscriptoTest = new Suscripto(clienteMock, planDeAhorroMock);	
		when(clienteMock.edadCliente()).thenReturn(20);
		assertTrue(suscriptoTest.edadSuscripto().equals(20));
	}
	
	@Test
	public void aunNoFueAdjudicadoTest() {
		suscriptoTest = new Suscripto(clienteMock, planDeAhorroMock);	
		assertTrue(suscriptoTest.todaviaNoFueAdjudicado().equals(true));
	}
	
	@Test
	public void fueAdjudicadoTest() {
		suscriptoTest = new Suscripto(clienteMock, planDeAhorroMock);	
		suscriptoTest.seAdjudico();
		assertTrue(suscriptoTest.todaviaNoFueAdjudicado().equals(false));
	}
	
	@Test
	public void proximaCuotaAPagarTest() {	
		when(consecionariaMock.gastosAdministrativos()).thenReturn(150f);
		when(planDeAhorroMock.getConcesionaria()).thenReturn(consecionariaMock);
		suscriptoTest = new Suscripto(clienteMock, planDeAhorroMock);
		
		suscriptoTest.pagarCuota(planDeAhorroMock);	

		assertTrue((suscriptoTest.proximaCuotaAPagar()).equals(2));
	}
		
	@Test
	public void cantidadCuotasPagasTest(){
		suscriptoTest = new Suscripto(clienteMock, planDeAhorroMock);
		when(consecionariaMock.gastosAdministrativos()).thenReturn(150f);
		when(planDeAhorroMock.getConcesionaria()).thenReturn(consecionariaMock);
		
		suscriptoTest.pagarCuota(planDeAhorroMock);
		suscriptoTest.pagarCuota(planDeAhorroMock);	

		assertTrue((suscriptoTest.cantidadCuotasPagas()).equals(2));
	}
}
