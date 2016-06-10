package adjudicacion;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import planDeAhorro.PlanDeAhorro;
import cliente.Cliente;
import financiamiento.Financiamiento;
import financiamiento.Plan100;
import financiamiento.Plan70_30;
import modelo.Modelo;

public class AdjudicacionTest {

    Adjudicacion porMayorCoberturaTest;
	Adjudicacion porSorteoTest;
    PlanDeAhorro planDeAhorroMock;
	Cliente clienteMock;
	Cliente clienteMock2;
	Cliente clienteMock3;
	Modelo modeloMock;
	Random randomMock;
    
	@Before
	public void setUp() throws Exception {

		porSorteoTest = new PorSorteo();
		porMayorCoberturaTest = new PorMayorCobertura();
		
		clienteMock = mock(Cliente.class);
		when(clienteMock.edadCliente2()).thenReturn(30); 
		
		clienteMock2 = mock(Cliente.class); 
		when(clienteMock2.edadCliente2()).thenReturn(50);
		
		planDeAhorroMock = mock(PlanDeAhorro.class);
		randomMock = mock(Random.class);		
	} 

	@Test
	public void testSeleccionDeClientePorMayorCobertura() {

		List<Cliente> suscriptos;
		suscriptos = new ArrayList<Cliente>();
		suscriptos.add(clienteMock);
		suscriptos.add(clienteMock2);
		
		when(planDeAhorroMock.getSubscriptos()).thenReturn((ArrayList<Cliente>) suscriptos);
		
		assertTrue(porMayorCoberturaTest.seleccionDeCliente(planDeAhorroMock).equals(clienteMock2));
	}
	
	@Test
	public void testSeleccionDeClientePorSorteo() {

		List<Cliente> suscriptos;
		suscriptos = new ArrayList<Cliente>();
		suscriptos.add(clienteMock);
		suscriptos.add(clienteMock2);
		
		when(planDeAhorroMock.getSubscriptos()).thenReturn((ArrayList<Cliente>) suscriptos);
		
		planDeAhorroMock.suscribirCliente(clienteMock);
		planDeAhorroMock.suscribirCliente(clienteMock2);
		
		assertTrue(porSorteoTest.seleccionDeCliente(planDeAhorroMock).equals(clienteMock));
		
	//	Random rnd = null;
	//	assertTrue(planDeAhorroMock.getSubscriptos().get((int)(rnd.nextDouble() * (planDeAhorroMock.getSubscriptos().size()-1))));
	//	Cliente ganador = (suscriptos.get((int)(rnd.nextDouble() * (suscriptos.size()-1))));
	//	assertTrue(porSorteoTest.seleccionDeCliente(planDeAhorroMock).equals(ganador));
	}
}
