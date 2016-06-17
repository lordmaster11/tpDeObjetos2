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
import financiamiento.Plan100;
import modelo.Modelo;
import suscripto.Suscripto;


public class PlanDeAhorroTest {
	 
    PlanDeAhorro planDeAhorro;
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
    	suscriptoMock = mock(Suscripto.class);
    	concesionariaMock = mock(Concesionaria.class);
    	planDeAhorro =  new PlanDeAhorro(125, modeloMock, plan100Mock, adjudicacionMock, 60, concesionariaMock);
    

    }

	@Test
	public void testSuscribirCliente() {
		
		planDeAhorro.agregarSuscripto(clienteMock);
		assertTrue(planDeAhorro.cantSuscriptos().equals(1));
		
	}
	
	@Test
	public void testGetSuscriptos() {
		planDeAhorro.agregarSuscripto(clienteMock);
		
		assertTrue (planDeAhorro.cantSuscriptos().equals(1));
	} 

	@Test
	public void testValorADesembolsar() {
		
		when(modeloMock.getValorVenta()).thenReturn(100000f);
		when(plan100Mock.valorTotalEnCuotas(modeloMock)).thenReturn(70000f);
		
		assertTrue((planDeAhorro.valorADesembolzar()).equals(70000f));
				
	}			 
	
	@Test
	public void testNuevoPlanDeAhorro(){ 	
		
		assertTrue(planDeAhorro.getModelo().equals(modeloMock));		
		assertTrue(planDeAhorro.getAdjudicacion().equals(adjudicacionMock));
		assertTrue(planDeAhorro.getConcesionaria().equals(concesionariaMock));
	}
	
	@Test
	public void efectivoAPagarTest(){ 			
		when(plan100Mock.efectivo(modeloMock)).thenReturn(0f);
		
		assertTrue(planDeAhorro.efectivoAPagar().equals(0f));
	}
	
	@Test
	public void testGetSuscriptos2(){ 	
		
		planDeAhorro.agregarSuscripto(clienteMock);
		
		assertTrue((planDeAhorro.getSubscriptos().size())==(1));
	}
	
	@Test
	public void alicuotaTest(){ 			
		when(plan100Mock.valorTotalEnCuotas(modeloMock)).thenReturn(60000f);
		
		assertTrue(planDeAhorro.alicuota().equals(1000f));
	}
}