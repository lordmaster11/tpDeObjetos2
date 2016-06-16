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

	@Before
	public void setUp() throws Exception {
		unaPlantaTest = new Planta("Rivadavia 524");
		modeloMock = mock(Modelo.class);
		unStockTest = mock(StockDeModelo.class);
	}   
  
	@Test
	public void testStockDeModelo() {
		
		when(modeloMock.getNombre()).thenReturn("peugeot 206");
		when(unStockTest.getModelo()).thenReturn(modeloMock);

		unaPlantaTest.agregarModelo(modeloMock);
		unaPlantaTest.agregarModelo(modeloMock);
		
		
		assertTrue(unaPlantaTest.buscarStockDelModelo(modeloMock).getCantidad().equals(2));
	}
		
	@Test
	public void quitarUnModeloTest() {

		when(modeloMock.getNombre()).thenReturn("peugeot 206");
		when(unStockTest.getModelo()).thenReturn(modeloMock);
		when(unStockTest.getCantidad()).thenReturn(6);
		
		unaPlantaTest.agregarStock(unStockTest);
		unaPlantaTest.quitarModelo(modeloMock);
		
		verify(unStockTest).quitarCantidad();
	}
	
	@Test
	public void quitarUltimoModeloTest() {

		when(modeloMock.getNombre()).thenReturn("peugeot 206");
		when(unStockTest.getModelo()).thenReturn(modeloMock);
		when(unStockTest.getCantidad()).thenReturn(1);
		
		unaPlantaTest.agregarStock(unStockTest);
		unaPlantaTest.quitarModelo(modeloMock);

		assertFalse(unaPlantaTest.existeElModelo(modeloMock));
	}
	
		
}