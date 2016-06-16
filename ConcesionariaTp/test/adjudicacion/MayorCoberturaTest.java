package adjudicacion;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import planDeAhorro.PlanDeAhorro;
import suscripto.Suscripto;
import modelo.Modelo;

public class MayorCoberturaTest {

    Adjudicacion porMayorCoberturaTest;	
    PlanDeAhorro planDeAhorroMock;
    Suscripto suscriptoMock;
    Suscripto suscriptoMock2;
	Modelo modeloMock;
	
	@Before
	public void setUp() throws Exception {

		porMayorCoberturaTest = new PorMayorCobertura();
		
		suscriptoMock = mock(Suscripto.class);		
		suscriptoMock2 = mock(Suscripto.class); 
		
		planDeAhorroMock = mock(PlanDeAhorro.class);				
	} 

	@Test
	public void testSeleccionDeClientePorMayorCobertura() {

		when(suscriptoMock.edadSuscripto()).thenReturn(30);
		when(suscriptoMock2.edadSuscripto()).thenReturn(50);
		
		List<Suscripto> suscriptos;
		suscriptos = new ArrayList<Suscripto>(Arrays.asList(suscriptoMock));
		
		when(planDeAhorroMock.suscriptosConMayorCantidadDeCuotasPagas()).thenReturn(suscriptos);
		
		assertTrue(porMayorCoberturaTest.seleccionDeCliente(planDeAhorroMock).equals(suscriptoMock));
		
		suscriptos.add(suscriptoMock2);
		
		//assertTrue(porMayorCoberturaTest.seleccionDeCliente(planDeAhorroMock).equals(clienteMock));
	}
}
