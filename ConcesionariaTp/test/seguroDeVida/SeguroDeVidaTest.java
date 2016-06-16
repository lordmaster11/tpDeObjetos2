package seguroDeVida;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import registroDePlan.Suscripto;
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

	/*//nose si lo hisite vos a el anterior pero lo comento y pongo unos mas completos que tambien 
	 //calculen con un costo de vehiculo; lo que no entiendo es xq me tira amarillo
	@Test
	public void testPorEdadMayorA50A�os() {
		
		when(suscriptoMock.edadSuscripto()).thenReturn(51);	
		assertTrue(seguroDeVidaTest.montoAPagar(suscriptoMock, modeloMock).equals(60f));
		
		when(suscriptoMock.edadSuscripto()).thenReturn(49);
		assertTrue(seguroDeVidaTest.montoAPagar(suscriptoMock, modeloMock).equals(50f));
	}
	*/
	@Test
	public void seguroDeVidaMayorTest(){
		when(suscriptoMock.edadSuscripto()).thenReturn(52);
		when(modeloMock.getValorVenta()).thenReturn(100000f);
		
		
		assertTrue(seguroDeVidaTest.montoAPagar(suscriptoMock, modeloMock)==(5070f));
		
	}
	
	@Test
	public void seguroDeVidaMenorTest(){
		when(suscriptoMock.edadSuscripto()).thenReturn(30);
		when(modeloMock.getValorVenta()).thenReturn(100000f);
		
		assertTrue(seguroDeVidaTest.montoAPagar(suscriptoMock, modeloMock)==(5050f));
		
	}
	
}
