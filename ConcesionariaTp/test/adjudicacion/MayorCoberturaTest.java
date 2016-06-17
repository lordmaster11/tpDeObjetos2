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
    Suscripto suscriptoMock3;
	Modelo modeloMock;
	
	@Before
	public void setUp() throws Exception {

		porMayorCoberturaTest = new PorMayorCobertura();
		
		suscriptoMock = mock(Suscripto.class);		
		suscriptoMock2 = mock(Suscripto.class); 
		
		planDeAhorroMock = mock(PlanDeAhorro.class);				
	} 

	@Test
	public void testSeleccionDeClientePorMayorCoberturaPorCantidadDeCuotasPagas() {
		
		List<Suscripto> suscriptos;
		suscriptos = new ArrayList<Suscripto>(Arrays.asList(suscriptoMock));
		
		when(planDeAhorroMock.suscriptosConMayorCantidadDeCuotasPagas()).thenReturn(suscriptos);
		
		assertTrue(porMayorCoberturaTest.seleccionDeCliente(planDeAhorroMock).equals(suscriptoMock));
	}
	
	@Test
	public void testSeleccionDeClientePorMayorCoberturaPorMayorAntiguedadEnConcesionaria() {
		
		List<Suscripto> suscriptos;
		suscriptos = new ArrayList<Suscripto>(Arrays.asList(suscriptoMock, suscriptoMock2));
		
		when(planDeAhorroMock.suscriptosConMayorCantidadDeCuotasPagas()).thenReturn(suscriptos);
		
		List<Suscripto> suscriptosMasAntiguosEnConcesionaria;
		suscriptosMasAntiguosEnConcesionaria = new ArrayList<Suscripto>(Arrays.asList(suscriptoMock2));
		
		when(planDeAhorroMock.losMasAntiguosEnConcesionaria(suscriptos)).thenReturn(suscriptosMasAntiguosEnConcesionaria);
		
		assertTrue(porMayorCoberturaTest.seleccionDeCliente(planDeAhorroMock).equals(suscriptoMock2));
	}
	
	@Test
	public void testSeleccionDeClientePorMayorCoberturaPorMayorAntiguedadEnElPlan() {
		
		List<Suscripto> suscriptos;
		suscriptos = new ArrayList<Suscripto>(Arrays.asList(suscriptoMock, suscriptoMock2, suscriptoMock3));
		
		when(planDeAhorroMock.suscriptosConMayorCantidadDeCuotasPagas()).thenReturn(suscriptos);
		
		List<Suscripto> suscriptosMasAntiguosEnConcesionaria;
		suscriptosMasAntiguosEnConcesionaria = new ArrayList<Suscripto>(Arrays.asList(suscriptoMock, suscriptoMock3));
		
		when(planDeAhorroMock.losMasAntiguosEnConcesionaria(suscriptos)).thenReturn(suscriptosMasAntiguosEnConcesionaria);
		
		
		when(planDeAhorroMock.suscriptoMasAntiguo(suscriptosMasAntiguosEnConcesionaria)).thenReturn(suscriptoMock3);
		
		assertTrue(porMayorCoberturaTest.seleccionDeCliente(planDeAhorroMock).equals(suscriptoMock3));
	}
}
