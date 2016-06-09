package financiamiento;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import modelo.Modelo;

import org.junit.Before;
import org.junit.Test;

public class FinanciamientoTest {

      Modelo modeloMock;
	Financiamiento unPlan100Test;
	Financiamiento unPlan70Test;

	@Before
	public void setUp() throws Exception {
		
		
		modeloMock = mock(Modelo.class);
		when(modeloMock.getValorVenta()).thenReturn(100000f);
		
	}

	@Test
	public void testValorEnCuotasPlan100() {
		unPlan100Test = new Plan100();
		assertTrue(unPlan100Test.valorTotalEnCuotas(modeloMock).equals(100000f));
	}

	@Test
	public void testValorEnCuotasPlan70() {
		unPlan70Test = new Plan70_30();
		assertTrue(unPlan70Test.valorTotalEnCuotas(modeloMock).equals(70000f));
	}

}
