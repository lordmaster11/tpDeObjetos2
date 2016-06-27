package financiamiento;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import modelo.Modelo;

import org.junit.Before;
import org.junit.Test;

public class Al100Porciento {
    Modelo modeloMock;
	Financiamiento plan100Test;

	@Before
	public void setUp() throws Exception {
		modeloMock = mock(Modelo.class);
		when(modeloMock.getValorVenta()).thenReturn(100000f);
		plan100Test = new Plan100();	
	}

	@Test
	public void testValorEnCuotasPlan100() {
		modeloMock = mock(Modelo.class);
		when(modeloMock.getValorVenta()).thenReturn(100000f);
		plan100Test = new Plan100();
		
		assertTrue(plan100Test.valorTotalEnCuotas(modeloMock).equals(100000f));
	}

	@Test
	public void enEfectivo() {
		modeloMock = mock(Modelo.class);
		plan100Test = new Plan100();
		
		assertTrue(plan100Test.efectivo(modeloMock).equals(0f));
	}
}