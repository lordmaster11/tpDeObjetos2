package fabrica;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import planta.Planta;

public class FabricaTest {
	
	Fabrica fabricaTest;
	Planta plantaMock;
	List<Planta> plantasMock;

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() {
		fabricaTest.agregarPlanta(plantaMock);
		
//		assertTrue(plantasMock.size()).equals(1);
	}

}
