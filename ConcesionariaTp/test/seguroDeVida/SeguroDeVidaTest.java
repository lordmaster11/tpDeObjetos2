package seguroDeVida;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import cliente.Cliente;
import modelo.Modelo;

public class SeguroDeVidaTest {
	
	SeguroDeVida seguroDeVidaPorEdad;
	SeguroDeVida seguroDeVidaPorVehiculo;
	Cliente clienteMock;
	Modelo modeloMock;
	

	@Before
	public void setUp() throws Exception {
		seguroDeVidaPorEdad = new PorEdad();
		seguroDeVidaPorVehiculo = new PorValorDeVehiculo();
		clienteMock = mock(Cliente.class);
		modeloMock = mock(Modelo.class);
	}

	@Test
	public void testPorEdadMayorA50Años() {
		
		when(clienteMock.edadCliente2()).thenReturn(51);	
		assertTrue(seguroDeVidaPorEdad.montoAPagar(clienteMock, modeloMock).equals(60f));		
	}
	
	@Test
	public void testPorEdadMenorA50Años() {
		
		when(clienteMock.edadCliente2()).thenReturn(49);
		assertTrue(seguroDeVidaPorEdad.montoAPagar(clienteMock, modeloMock).equals(50f));
	}

	@Test
	public void testPorValorVehiculo() {

		when(modeloMock.getValorVenta()).thenReturn(70000f);
		assertTrue(seguroDeVidaPorVehiculo.montoAPagar(clienteMock, modeloMock).equals(3500f));
	}	
}
