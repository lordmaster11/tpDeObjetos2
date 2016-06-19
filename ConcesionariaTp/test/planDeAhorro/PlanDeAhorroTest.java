package planDeAhorro;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import planta.Planta;
import adjudicacion.Adjudicacion;
import cliente.Cliente;
import concesionaria.Concesionaria;
import financiamiento.Plan100;
import modelo.Modelo;
import stockDeModelo.StockDeModelo;
import suscripto.Suscripto;


public class PlanDeAhorroTest {
	 
    PlanDeAhorro planDeAhorro;
    Cliente clienteMock;
    Cliente cliente2Mock;
    Modelo modeloMock;
	Plan100 plan100Mock;
	Adjudicacion adjudicacionMock;
	Concesionaria concesionariaMock;
	Suscripto suscriptoMock;
	Suscripto suscripto2Mock;

       
    @Before
    public void setUp() throws Exception {
    	 
    	clienteMock = mock(Cliente.class);
    	cliente2Mock = mock(Cliente.class);
    	suscriptoMock = mock(Suscripto.class);
    	suscripto2Mock = mock(Suscripto.class);
    	modeloMock = mock(Modelo.class);
    	plan100Mock =  mock(Plan100.class);
    	adjudicacionMock = mock(Adjudicacion.class);
    	concesionariaMock = mock(Concesionaria.class);
    	planDeAhorro =  new PlanDeAhorro(125, modeloMock, plan100Mock, adjudicacionMock, 60, concesionariaMock);
    
    }

	@Test
	public void testAgregarCliente() {	
		planDeAhorro.suscribirClienteAlPlan(clienteMock);
		assertTrue(planDeAhorro.cantSuscriptos().equals(1));		
	}
	
	@Test
	public void testGetSuscriptos() {
		planDeAhorro.suscribirClienteAlPlan(clienteMock);
		
		assertTrue(((planDeAhorro.getSubscriptos().get(0)).getCliente()).equals(clienteMock));
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
	public void alicuotaTest(){ 			
		when(plan100Mock.valorTotalEnCuotas(modeloMock)).thenReturn(60000f);
		
		assertTrue(planDeAhorro.alicuota().equals(1000f));
	}
	
	/**
	 * hay q ver si esta bien pq se deberia agregar un cliente y no un suscripto
	 * agregarSuscripto deberia ser privado
	 */
	
	@Test
	public void disponiblesTrueTest(){
		planDeAhorro.agregarSuscripto(suscriptoMock);
		when(suscriptoMock.todaviaNoFueAdjudicado()).thenReturn(false);
		
		planDeAhorro.agregarSuscripto(suscripto2Mock);
		when(suscripto2Mock.todaviaNoFueAdjudicado()).thenReturn(true);
		
		assertTrue(planDeAhorro.disponibles().contains(suscripto2Mock));
	}

	@Test
	public void disponiblesFalseTest(){
		planDeAhorro.agregarSuscripto(suscriptoMock);
		when(suscriptoMock.todaviaNoFueAdjudicado()).thenReturn(false);
		
		planDeAhorro.agregarSuscripto(suscripto2Mock);
		when(suscripto2Mock.todaviaNoFueAdjudicado()).thenReturn(true);

		assertFalse(planDeAhorro.disponibles().contains(suscriptoMock));
	}
	/**
	 * hay q ver si esta bien pq se deberia agregar un cliente y no un suscripto
	 * agregarSuscripto deberia ser privado
	 */
	
	@Test
	public void mayorCantidadDeCuotasPagasTest(){
		when(suscriptoMock.cantidadCuotasPagas()).thenReturn(5);
		planDeAhorro.agregarSuscripto(suscriptoMock);
		
		when(suscripto2Mock.cantidadCuotasPagas()).thenReturn(4);
		planDeAhorro.agregarSuscripto(suscripto2Mock);

		assertFalse(planDeAhorro.suscriptosConMayorCantidadDeCuotasPagas().equals(suscriptoMock));
	}
	
}