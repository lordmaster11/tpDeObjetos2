package seguroDeVida;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import modelo.Modelo;
import suscripto.Suscripto;

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
	public void seguroDeVidaMayorTest(){
		when(suscriptoMock.edadSuscripto()).thenReturn(52);
		when(modeloMock.getValorVenta()).thenReturn(100000f);
				
		assertTrue(seguroDeVidaTest.montoAPagar(suscriptoMock, modeloMock).equals(5070f));		
	}
	
	@Test
	public void seguroDeVidaMenorTest(){
		when(suscriptoMock.edadSuscripto()).thenReturn(30);
		when(modeloMock.getValorVenta()).thenReturn(100000f);
		
		assertTrue(seguroDeVidaTest.montoAPagar(suscriptoMock, modeloMock).equals(5050f));	
	}
}