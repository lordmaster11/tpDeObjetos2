package planDeAhorro;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adjudicacion.Adjudicacion2;
import cliente.Cliente;
import financiamiento.Financiamiento;
import modelo.Modelo;


public class PlanDeAhorroTest {
	
    PlanDeAhorro unPlanDeAhorro;
    Cliente unClienteMock;
	Modelo modeloMock;
	Financiamiento financiamientoMock;
	Adjudicacion2 adjudicacionMock;
       
    @Before
    public void setUp() throws Exception {
    	 
    	unClienteMock = mock(Cliente.class);
    	modeloMock = mock(Modelo.class);
    	financiamientoMock = mock(Financiamiento.class);
    	adjudicacionMock = mock(Adjudicacion2.class);
    	unPlanDeAhorro =  new PlanDeAhorro(125, modeloMock, financiamientoMock, adjudicacionMock);
	 
    	when(unClienteMock.getDNI()).thenReturn(38125365);
    }

	@Test
	public void testSuscribirCliente() {
		
		unPlanDeAhorro.suscribirCliente(unClienteMock);
		
		assertTrue(unPlanDeAhorro.cantSuscriptos().equals(1));
	}
}