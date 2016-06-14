package comprobanteDePago;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import RegistroDePlan.Suscripto;
import concesionaria.Concesionaria;
import planDeAhorro.PlanDeAhorro;

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
		
		when(planMock.getConcesionaria()).thenReturn(concesionariaMock);
		comprobanteDePago =  new ComprobanteDePago(10,planMock,suscriptoMock);		
	}

	@Test
	public void test() {
	
	}

}
