package planDeAhorro;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import planta.Planta;
import suscripto.Suscripto;
import adjudicacion.Adjudicacion;
import cliente.Cliente;
import comprobanteDePago.ComprobanteDePago;
import concesionaria.Concesionaria;
import financiamiento.Financiamiento;
import modelo.Modelo;


public class PlanDeAhorroTest {
	 
    PlanDeAhorro planDeAhorro;
    Cliente clienteMock;
    Cliente cliente2Mock;
    Cliente cliente3Mock;
	Modelo modeloMock;
	Financiamiento financiamiento70_30Mock;
	Adjudicacion adjudicacionMock;
	Concesionaria concesionariaMock;
       
    @Before
    public void setUp() throws Exception {

    	clienteMock = mock(Cliente.class);
    	cliente2Mock = mock(Cliente.class);
    	cliente3Mock = mock(Cliente.class);
    	modeloMock = mock(Modelo.class);
    	financiamiento70_30Mock =  mock(Financiamiento.class);
    	adjudicacionMock = mock(Adjudicacion.class);
    	planDeAhorro =  new PlanDeAhorro(125, modeloMock, financiamiento70_30Mock, adjudicacionMock, 0, concesionariaMock);
    

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
		when(financiamiento70_30Mock.valorTotalEnCuotas(modeloMock)).thenReturn(70000f);
		
		assertTrue((planDeAhorro.valorADesembolzar()).equals(70000f));
				
	}			 
	
	@Test
	public void disponiblesTest() {

		
		planDeAhorro.agregarSuscripto(cliente2Mock);
		planDeAhorro.agregarSuscripto(clienteMock);
		
		assertTrue((planDeAhorro.disponibles().size())==2);
	}
	
	

}