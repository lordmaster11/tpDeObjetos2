package financiamiento;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import modelo.Modelo;

import org.junit.Before;
import org.junit.Test;

public class Al70_30Porciento {

      Modelo modeloMock;
	Financiamiento unPlan70_30Test;

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testValorEnCuotasPlan70() {
		modeloMock = mock(Modelo.class);
		when(modeloMock.getValorVenta()).thenReturn(100000f);
		unPlan70_30Test = new Plan70_30();
		assertTrue(unPlan70_30Test.valorTotalEnCuotas(modeloMock).equals(70000f));
	}
	
	@Test
	public void enEfectivo() {
		modeloMock = mock(Modelo.class);
		when(modeloMock.getValorVenta()).thenReturn(100000f);
		unPlan70_30Test = new Plan70_30();	
		
	assertTrue(unPlan70_30Test.efectivo(modeloMock).equals(30000f));
	}
}
