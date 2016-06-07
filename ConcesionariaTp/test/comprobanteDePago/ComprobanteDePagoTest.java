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
	Date unaFecha;
	SeguroDeVida seguroMock;
	
	@Before
	public void setUp() throws Exception {
		clienteMock = mock(Cliente.class);
		seguroMock = mock(SeguroDeVida.class);
		comprobanteDePago =  new ComprobanteDePago(clienteMock, 2, 500f, 20f, seguroMock);
	}

	@Test
	public void test() {
	
	}

}
