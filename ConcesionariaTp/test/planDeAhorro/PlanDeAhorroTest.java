package planDeAhorro;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cliente.Cliente;


public class PlanAhorroTest {


       public PlanDeAhorro unPlanDeAhorro;
       public Cliente unClienteMock;
	
       @Before
	public void setUp() throws Exception {

		 unClienteMock = mock(Cliente.class);
		 unPlanDeAhorro =  new PlanDeAhorro();
		 when(unClienteMock.getDNI()).thenReturn(38125365);
	}

	@Test
	public void testSuscribirCliente() {
		
		unPlanDeAhorro.suscribirCliente(unClienteMock);
		
		assertTrue(unPlanDeAhorro.estaSuscripto(unClienteMock));
	}

}