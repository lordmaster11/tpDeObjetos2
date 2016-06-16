package suscripto;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import registroDePlan.Suscripto;
import cliente.Cliente;

public class SuscriptoTest {
	
	Suscripto suscriptoTest;
	Cliente clienteMock;

	@Before
	public void setUp() throws Exception {
		clienteMock = mock(Cliente.class);
		suscriptoTest = new Suscripto(clienteMock);
		
	}

	@Test
	public void test() {
		
	}

}
