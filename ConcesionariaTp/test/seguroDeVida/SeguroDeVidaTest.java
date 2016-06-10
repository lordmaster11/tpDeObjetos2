package seguroDeVida;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import cliente.Cliente;
import modelo.Modelo;

public class SeguroDeVidaTest {
	
	SeguroDeVida seguroDeVidaPorEdad;
	Cliente clienteMock;
	Modelo modeloMock;
	SeguroDeVida seguroDeVidaPorVehiculo;

	@Before
	public void setUp() throws Exception {
		clienteMock = mock(Cliente.class);
		modeloMock = mock(Modelo.class);
	}

	@Test
	public void testPorEdad() {
		seguroDeVidaPorEdad = new PorEdad();
		when(clienteMock.edadCliente2()).thenReturn(51);	
		assertTrue(seguroDeVidaPorEdad.montoAPagar(clienteMock, modeloMock).equals(60f));
		
		when(clienteMock.edadCliente2()).thenReturn(49);
		assertTrue(seguroDeVidaPorEdad.montoAPagar(clienteMock, modeloMock).equals(50f));
	}

	@Test
	public void testPorValorVehiculo() {
		seguroDeVidaPorVehiculo = new PorValorDeVehiculo();
		
		when(modeloMock.getValorVenta()).thenReturn(70000f);
	
		assertTrue(seguroDeVidaPorVehiculo.montoAPagar(clienteMock, modeloMock).equals(3500f));
	}
	
}
