package cuponDeAdjudicacion;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import concesionaria.Concesionaria;
import planDeAhorro.PlanDeAhorro;
import suscripto.Suscripto;

public class CuponDeAdjudicacionTest {
	
	Suscripto suscriptoMock;
	PlanDeAhorro planMock;
	CuponDeAdjudicacion cuponTest;
	Concesionaria concesionariaMock;

	@Before
	public void setUp() throws Exception {
		
		Concesionaria concesionariaMock = mock(Concesionaria.class);
		
		planMock = mock(PlanDeAhorro.class);
		when(planMock.getConcesionaria()).thenReturn(concesionariaMock);
		
		suscriptoMock = mock(Suscripto.class);
		cuponTest = new CuponDeAdjudicacion(planMock, suscriptoMock);
	}

	@Test
	public void test() {
		
	}
}