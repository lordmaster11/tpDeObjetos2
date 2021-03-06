package adjudicacion;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import planDeAhorro.PlanDeAhorro;
import suscripto.Suscripto;

public class PorSorteoTest {
	Adjudicacion porSorteoTest;
	Random randomMock;
	Suscripto clienteMock;
	Suscripto clienteMock2;
	PlanDeAhorro planDeAhorroMock;
	
	@Before
	public void setUp() throws Exception {
		randomMock = mock(Random.class);
		porSorteoTest = new PorSorteo(randomMock);		
		clienteMock = mock(Suscripto.class);
		clienteMock2 = mock(Suscripto.class); 
		planDeAhorroMock = mock(PlanDeAhorro.class);
	}

	@Test
	public void testPorSorteo() {
		List<Suscripto> suscriptos;
		suscriptos = new ArrayList<Suscripto>(Arrays.asList(clienteMock,clienteMock2));
		
		when(planDeAhorroMock.disponibles()).thenReturn(suscriptos);
		when(randomMock.nextInt()).thenReturn(0);
		
		assertEquals(clienteMock, porSorteoTest.seleccionDeCliente(planDeAhorroMock));
	}
}