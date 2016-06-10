package planta;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import modelo.Modelo;

import org.junit.Before;
import org.junit.Test;

import stockDeModelo.StockDeModelo;

public class PlantaTest {

	Planta unaPlantaTest;
	Modelo modeloMock;
	StockDeModelo unStockTest;
	StockDeModelo unStockTest2;

	@Before
	public void setUp() throws Exception {
		unaPlantaTest = new Planta();
		
		modeloMock = mock(Modelo.class);
		when(modeloMock.getNombre()).thenReturn("peugeot 206");
		
		unStockTest = mock(StockDeModelo.class);
		when(unStockTest.getModelo()).thenReturn(modeloMock);
		when(unStockTest.getCantidad()).thenReturn(2);
		unStockTest2 = mock(StockDeModelo.class);
		when(unStockTest2.getModelo()).thenReturn(modeloMock);
		when(unStockTest2.getCantidad()).thenReturn(1);
		
	}
/*
	@Test
	public void testStockDeModelo() {
		
		unaPlantaTest.agregarStock(unStockTest);
		unaPlantaTest.agregarStock(unStockTest2);
		
		
		assertTrue(unaPlantaTest.stockDeModelo(modeloMock).equals(6));
	}

*/
}










