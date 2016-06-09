package adjudicacion;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import modelo.Modelo;

import org.junit.Before;
import org.junit.Test;

import planDeAhorro.PlanDeAhorro;
import cliente.Cliente;
import financiamiento.Financiamiento;
import financiamiento.Plan100;
import financiamiento.Plan70_30;

public class AdjudicacionTest {

    Modelo modeloMock;
    Adjudicacion porMayorCoberturaTest;
	Adjudicacion porSorteoTest;
	Cliente unClienteMock2;
    PlanDeAhorro planDeAhorroMock;
	Cliente unClienteMock;
    
	@Before
	public void setUp() throws Exception {

		planDeAhorroMock = mock(PlanDeAhorro.class);
		unClienteMock = mock(Cliente.class);
		when(unClienteMock.edad()).thenReturn(30);
		unClienteMock2 = mock(Cliente.class);
		when(unClienteMock2.edad()).thenReturn(50);
			
	}

	@Test
	public void testSeleccionDeClientePorMayorCobertura() {

		porMayorCoberturaTest = new PorMayorCobertura();
		List<Cliente> suscriptos;
		suscriptos = new ArrayList<Cliente>();
		suscriptos.add(unClienteMock);
		suscriptos.add(unClienteMock2);
		
		when(planDeAhorroMock.getSubscriptos()).thenReturn((ArrayList<Cliente>) suscriptos);
		
		assertTrue(porMayorCoberturaTest.seleccionDeCliente(planDeAhorroMock).equals(unClienteMock2));
	}

	
}
