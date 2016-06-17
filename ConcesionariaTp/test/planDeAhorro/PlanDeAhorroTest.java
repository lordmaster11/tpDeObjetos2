package planDeAhorro;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adjudicacion.Adjudicacion;
import cliente.Cliente;

import concesionaria.Concesionaria;

import financiamiento.Financiamiento;
import financiamiento.Plan100;
import modelo.Modelo;
import stockDeModelo.StockDeModelo;
import suscripto.Suscripto;


public class PlanDeAhorroTest {
	 
    PlanDeAhorro planDeAhorroTest;
    Cliente clienteMock;
	Modelo modeloMock;
	Plan100 plan100Mock;
	Adjudicacion adjudicacionMock;
	Concesionaria concesionariaMock;
	Suscripto suscriptoMock;
   
    @Before
    public void setUp() throws Exception {
    	 
    	clienteMock = mock(Cliente.class);
    	modeloMock = mock(Modelo.class);
    	plan100Mock =  mock(Plan100.class);
    	adjudicacionMock = mock(Adjudicacion.class);
    	concesionariaMock = mock(Concesionaria.class);
    	planDeAhorroTest =  new PlanDeAhorro(125, modeloMock, plan100Mock, adjudicacionMock, 60, concesionariaMock);
    	
    }

	@Test
	public void testSuscribirCliente() {
		planDeAhorroTest.agregarSuscripto(clienteMock);
		assertTrue(planDeAhorroTest.cantSuscriptos().equals(1));		
	}
	
	@Test
	public void testCantidadSuscriptos() {
		planDeAhorroTest.agregarSuscripto(clienteMock);
		
		assertTrue (planDeAhorroTest.cantSuscriptos().equals(1));
	} 

	@Test
	public void testValorADesembolsar() {
		
		when(modeloMock.getValorVenta()).thenReturn(100000f);
		when(plan100Mock.valorTotalEnCuotas(modeloMock)).thenReturn(70000f);
		
		assertTrue((planDeAhorroTest.valorADesembolzar()).equals(70000f));				
	}			 
	
	@Test
	public void testNuevoPlanDeAhorro(){ 	
		
		assertTrue(planDeAhorroTest.getModelo().equals(modeloMock));		
		assertTrue(planDeAhorroTest.getAdjudicacion().equals(adjudicacionMock));
		assertTrue(planDeAhorroTest.getConcesionaria().equals(concesionariaMock));
	}
	
	@Test
	public void efectivoAPagarTest(){ 			
		when(plan100Mock.efectivo(modeloMock)).thenReturn(0f);
		
		assertTrue(planDeAhorroTest.efectivoAPagar().equals(0f));
	}
	
	@Test
	public void testGetSuscriptos(){ 	
		List<Suscripto> suscriptos;
		suscriptos = new ArrayList<Suscripto>(Arrays.asList(suscriptoMock));
		
//		when(planDeAhorroTest.agregarSuscripto(clienteMock)).thenReturn(suscriptos);
		
		assertTrue(planDeAhorroTest.getSubscriptos().equals(suscriptos));
	}
	
	@Test
	public void alicuotaTest(){ 			
		when(plan100Mock.valorTotalEnCuotas(modeloMock)).thenReturn(60000f);
		
		assertTrue(planDeAhorroTest.alicuota().equals(1000f));
	}
}