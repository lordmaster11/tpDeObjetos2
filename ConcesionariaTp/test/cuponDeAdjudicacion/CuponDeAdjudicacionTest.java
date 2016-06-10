package cuponDeAdjudicacion;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import cliente.Cliente;

public class CuponDeAdjudicacionTest {
	
	Cliente clienteMock;
	CuponDeAdjudicacion cuponTest;

	@Before
	public void setUp() throws Exception {
		cuponTest = new CuponDeAdjudicacion(clienteMock, 500f);
		clienteMock = mock(Cliente.class);
	}

	@Test
	public void test() {
		
	}

}
