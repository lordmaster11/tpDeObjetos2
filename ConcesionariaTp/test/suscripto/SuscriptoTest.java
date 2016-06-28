package suscripto;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import modelo.Modelo;

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
	Modelo modeloMock;

	@Before
	public void setUp() throws Exception {
		consecionariaMock = mock(Concesionaria.class);
		clienteMock = mock(Cliente.class);
		planDeAhorroMock = mock(PlanDeAhorro.class);
		comprobanteMock = mock(ComprobanteDePago.class);
		suscriptoTest = new Suscripto(clienteMock, planDeAhorroMock);	
		modeloMock = mock(Modelo.class);
	}

	@Test
	public void getFechaNacTest(){ 	
		Calendar fechaNac = new GregorianCalendar(1980, Calendar.FEBRUARY, 11);
		
		when(clienteMock.getFechaNacimiento()).thenReturn(fechaNac);
		
		assertTrue(suscriptoTest.getFechaNac().equals(fechaNac));	
	} 
	
	@Test
	public void fechaIngresoTest(){ 	
		Calendar fechaIngreso = Calendar.getInstance();
		
		when(clienteMock.getFechaIngreso()).thenReturn(fechaIngreso);
	
		assertTrue(suscriptoTest.getFechaDeIngreso().equals(fechaIngreso));	
	} 
	
	@Test
	public void fechaDeInscripcionTest(){ 	
		Calendar fechaInscripcion = Calendar.getInstance();
			
		assertTrue(suscriptoTest.getFechaDeInscripcion().equals(fechaInscripcion));		
	} 
		
	@Test 
	public void edadSuscriptotest() {
		
		when(clienteMock.edadCliente()).thenReturn(20);
		assertTrue(suscriptoTest.edadSuscripto().equals(20));
	}
	
	@Test
	public void aunNoFueAdjudicadoTest() {
	
		assertTrue(suscriptoTest.todaviaNoFueAdjudicado().equals(true));
	}
	
	@Test
	public void fueAdjudicadoTest() {
	
		suscriptoTest.seAdjudico();
		assertTrue(suscriptoTest.todaviaNoFueAdjudicado().equals(false));
	}
	
	@Test
	public void proximaCuotaAPagarTest() {	
		when(consecionariaMock.gastosAdministrativos()).thenReturn(150f);
		when(planDeAhorroMock.getConcesionaria()).thenReturn(consecionariaMock);
		
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
	@Test
	public void valorTotalPagadoDelAtoTest(){
		
		when(planDeAhorroMock.alicuota(suscriptoTest)).thenReturn(10000f);
		when(planDeAhorroMock.getModelo()).thenReturn(modeloMock);
		when(planDeAhorroMock.getConcesionaria()).thenReturn(consecionariaMock);
		suscriptoTest.pagarCuota(planDeAhorroMock);
		suscriptoTest.pagarCuota(planDeAhorroMock);
		
		assertTrue((suscriptoTest.valorPagadoDelAuto()).equals(20000f));
	}
}