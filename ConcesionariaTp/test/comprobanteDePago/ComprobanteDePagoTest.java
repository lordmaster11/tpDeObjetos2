package comprobanteDePago;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import cliente.Cliente;
import seguroDeVida.SeguroDeVida;

public class ComprobanteDePagoTest {

	ComprobanteDePago comprobanteDePago;
	Cliente clienteMock;
	SeguroDeVida seguroMock;
	Date fechaDePago;
	
	@Before
	public void setUp() throws Exception {
		clienteMock = mock(Cliente.class);
		seguroMock = mock(SeguroDeVida.class);
		fechaDePago = new Date();
		comprobanteDePago =  new ComprobanteDePago(clienteMock, 2, fechaDePago, 500f, 20f, seguroMock);		
	}

	@Test
	public void test() {
	
	}

}
