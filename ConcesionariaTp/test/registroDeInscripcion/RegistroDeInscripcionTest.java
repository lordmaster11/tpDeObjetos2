package registroDeInscripcion;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import RegistroDePlan.RegistroDePlan;
import cliente.Cliente;

public class RegistroDeInscripcionTest {
	
	RegistroDePlan registroTest;
	Cliente clienteMock;

	@Before
	public void setUp() throws Exception {
		Date fechaInscripcion = new Date();
		registroTest = new RegistroDePlan(clienteMock, fechaInscripcion);
		clienteMock = mock(Cliente.class);
	}

	@Test
	public void test() {
		
	}

}
