package googleMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import GoogleMap.GoogleMap;
import planta.Planta;

public class GoogleMapTest {

	Random randomMock;
	Planta plantaMock;
	GoogleMap googleMapTest;
	
	@Before
	public void setUp() throws Exception {
		randomMock = mock(Random.class);
		plantaMock = mock(Planta.class);
		googleMapTest = new GoogleMap();
	}

	@Test
	public void calcularDistancia() {
//		List<Suscripto> suscriptos;
//		suscriptos = new ArrayList<Suscripto>(Arrays.asList(clienteMock,clienteMock2));
//		
//		when(planDeAhorroMock.disponibles()).thenReturn(suscriptos);
		when(randomMock.nextInt()).thenReturn(200);
		
		assertEquals(randomMock, googleMapTest.calcularDistancia(plantaMock));
	}
}
