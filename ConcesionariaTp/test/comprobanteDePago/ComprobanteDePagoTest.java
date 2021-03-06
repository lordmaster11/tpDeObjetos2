package comprobanteDePago;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import concesionaria.Concesionaria;
import planDeAhorro.PlanDeAhorro;
import suscripto.Suscripto;

public class ComprobanteDePagoTest {
	ComprobanteDePago comprobanteDePago;
	Suscripto suscriptoMock;
	PlanDeAhorro planMock;
	Date fechaDePago;
	Concesionaria concesionariaMock;
	
	@Before
	public void setUp() throws Exception {
		suscriptoMock = mock(Suscripto.class);
		planMock = mock(PlanDeAhorro.class);
		concesionariaMock = mock(Concesionaria.class);
	}

	@Test
	public void nuevaCuotatest() {
		when(suscriptoMock.proximaCuotaAPagar()).thenReturn(10);
		when(planMock.getConcesionaria()).thenReturn(concesionariaMock);
		comprobanteDePago =  new ComprobanteDePago(planMock,suscriptoMock);
		
		assertTrue(comprobanteDePago.getNumeroDeCuotas().equals(10));
	}
}