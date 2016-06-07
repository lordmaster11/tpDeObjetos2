package planDeAhorro;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adjudicacion.Adjudicacion;
import cliente.Cliente;
import financiamiento.Financiamiento;
import modelo.Modelo;


public class PlanDeAhorroTest {
	
    PlanDeAhorro unPlanDeAhorro;
    Cliente unClienteMock;
	Modelo modeloMock;
	Financiamiento financiamientoMock;
	Adjudicacion adjudicacionMock;
       
    @Before
    public void setUp() throws Exception {
    	 
    	unClienteMock = mock(Cliente.class);
    	modeloMock = mock(Modelo.class);
    	financiamientoMock = mock(Financiamiento.class);
    	adjudicacionMock = mock(Adjudicacion.class);
    	unPlanDeAhorro =  new PlanDeAhorro(125, modeloMock, financiamientoMock, adjudicacionMock, 0);
    }

	@Test
	public void testSuscribirCliente() {
		
		unPlanDeAhorro.suscribirCliente(unClienteMock);
		
		assertTrue(unPlanDeAhorro.cantSuscriptos().equals(1));
	}
}