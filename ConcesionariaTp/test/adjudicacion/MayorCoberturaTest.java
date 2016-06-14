package adjudicacion;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import RegistroDePlan.Suscripto;
import planDeAhorro.PlanDeAhorro;
import cliente.Cliente;
import modelo.Modelo;

public class MayorCoberturaTest {

    Adjudicacion porMayorCoberturaTest;
	
    PlanDeAhorro planDeAhorroMock;
    Suscripto clienteMock;
    Suscripto clienteMock2;
	Modelo modeloMock;
	
    
	@Before
	public void setUp() throws Exception {

		
		porMayorCoberturaTest = new PorMayorCobertura();
		
		clienteMock = mock(Suscripto.class);		
		clienteMock2 = mock(Suscripto.class); 
		
		planDeAhorroMock = mock(PlanDeAhorro.class);
				
	} 

	@Test
	public void testSeleccionDeClientePorMayorCobertura() {

		when(clienteMock.edadSuscripto()).thenReturn(30);
		when(clienteMock2.edadSuscripto()).thenReturn(50);
		
		List<Suscripto> suscriptos;
		suscriptos = new ArrayList<Suscripto>(Arrays.asList(clienteMock));
		
		when(planDeAhorroMock.losQueMasPagaron()).thenReturn(suscriptos);
		
		assertTrue(porMayorCoberturaTest.seleccionDeCliente(planDeAhorroMock).equals(clienteMock));
		
		suscriptos.add(clienteMock2);
		
		//assertTrue(porMayorCoberturaTest.seleccionDeCliente(planDeAhorroMock).equals(clienteMock));
	}
}
