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
	
    PlanDeAhorro planDeAhorro;
    Cliente clienteMock;
	Modelo modeloMock;
	Financiamiento financiamientoMock;
	Adjudicacion adjudicacionMock;
       
    @Before
    public void setUp() throws Exception {
    	 
    	clienteMock = mock(Cliente.class);
    	modeloMock = mock(Modelo.class);
    	financiamientoMock = mock(Financiamiento.class);
    	adjudicacionMock = mock(Adjudicacion.class);
    	planDeAhorro =  new PlanDeAhorro(125, modeloMock, financiamientoMock, adjudicacionMock, 0);
    }

	@Test
	public void testSuscribirCliente() {
		
		planDeAhorro.suscribirCliente(clienteMock);
		
		assertTrue(planDeAhorro.cantSuscriptos().equals(1));
	}
	
	@Test
	public void testGetSuscriptos() {
		planDeAhorro.suscribirCliente(clienteMock);
		
		assertTrue (((Integer)planDeAhorro.getSubscriptos().size()).equals(1));
	}
}