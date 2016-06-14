package seguroDeVida;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import RegistroDePlan.Suscripto;
import modelo.Modelo;

public class SeguroDeVidaTest {
	
	SeguroDeVida seguroDeVidaTest;
	Suscripto suscriptoMock;
	Modelo modeloMock;
	

	@Before
	public void setUp() throws Exception {
		seguroDeVidaTest = new SeguroDeVida();
		suscriptoMock = mock(Suscripto.class);
		modeloMock = mock(Modelo.class);
	}

	@Test
	public void testPorEdadMayorA50Años() {
		
		when(suscriptoMock.edadSuscripto()).thenReturn(51);	
		assertTrue(seguroDeVidaTest.montoAPagar(suscriptoMock, modeloMock).equals(60f));
		
		when(suscriptoMock.edadSuscripto()).thenReturn(49);
		assertTrue(seguroDeVidaTest.montoAPagar(suscriptoMock, modeloMock).equals(50f));
	}
	
	
}
