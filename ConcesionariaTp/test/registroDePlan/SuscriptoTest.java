package registroDePlan;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import cliente.Cliente;
import suscripto.Suscripto;

public class SuscriptoTest {

	Suscripto suscriptoTest;
	Cliente clienteMock;

	@Before
	public void setUp() throws Exception {
		clienteMock = mock(Cliente.class);
		suscriptoTest = new Suscripto(clienteMock);
	}

	@Test
	public void edadSuscriptotest() {
	when(clienteMock.edadCliente()).thenReturn(20);
	assertTrue(suscriptoTest.edadSuscripto().equals(20));
	}
	@Test
	public void aunNoFueAdjudicado() {
		assertTrue(suscriptoTest.aunNoFueAdjudicado().equals(true));
	}


	

}
