package googleMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import googleMap.GoogleMap;
import planta.Planta;

public class GoogleMapTest {
	Random randomMock;
	Planta plantaMock;
	GoogleMap googleMapTest;
	
	@Before
	public void setUp() throws Exception {
		randomMock = mock(Random.class);
		plantaMock = mock(Planta.class);
	}
 
	@Test
	public void calcularDistanciaTest() {
		when(randomMock.nextInt()).thenReturn(3);

		googleMapTest = new GoogleMap(randomMock);
		
		assertTrue(googleMapTest.calcularDistancia(plantaMock).equals(9001));
	}
}