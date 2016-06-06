package concesionaria;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import GoogleMap.GoogleMap;
import fabrica.Fabrica;
import modelo.Modelo;
import planta.Planta;

public class ConcesionariaTest {

	Concesionaria concesionariaTest;
	Fabrica fabricaMock;
	GoogleMap googleMapMock;
	Planta plantaMock;
	
	@Before
	public void setUp() throws Exception {
		concesionariaTest = new Concesionaria (fabricaMock);
		fabricaMock = mock(Fabrica.class);
		googleMapMock = mock(GoogleMap.class);
		plantaMock = mock(Planta.class);
	}

	@Test
	public void testGastoDeFlete() {
		assertTrue(concesionariaTest.gastoDeFlete(plantaMock).equals(200f));
	}

}
