package planta;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import modelo.Modelo;

import org.junit.Before;
import org.junit.Test;

import stockDeModelo.StockDeModelo;

public class PlantaTest {

	Planta plantaTest;
	Modelo modeloMock;
	StockDeModelo stockMock;
	StockDeModelo stockMock2;

	@Before
	public void setUp() throws Exception {
		plantaTest = new Planta("Rivadavia 524");
		modeloMock = mock(Modelo.class);
		stockMock = mock(StockDeModelo.class);
		stockMock2 = mock(StockDeModelo.class);
	}   
  
	@Test
	public void testStockDeModelo() {
		
		when(modeloMock.getNombre()).thenReturn("peugeot 206");
		when(stockMock.getModelo()).thenReturn(modeloMock);

		plantaTest.agregarModelo(modeloMock);
		plantaTest.agregarModelo(modeloMock);
		
		
		assertTrue(plantaTest.buscarStockDelModelo(modeloMock).getCantidad().equals(2));
	}
		
	@Test
	public void quitarUnModeloTest() {

		when(modeloMock.getNombre()).thenReturn("peugeot 206");
		when(stockMock.getModelo()).thenReturn(modeloMock);
		when(stockMock.getCantidad()).thenReturn(6);
		
		plantaTest.agregarStock(stockMock);
		plantaTest.quitarModelo(modeloMock);
		
		verify(stockMock).quitarCantidad();
	}
	
	@Test
	public void quitarUltimoModeloTest() {

		when(modeloMock.getNombre()).thenReturn("peugeot 206");
		when(stockMock.getModelo()).thenReturn(modeloMock);
		when(stockMock.getCantidad()).thenReturn(1);
		
		plantaTest.agregarStock(stockMock);
		plantaTest.quitarModelo(modeloMock);

		assertFalse(plantaTest.existeElModelo(modeloMock));
	}
	
	@Test
	public void getStocks() {
		
		plantaTest.agregarModelo(modeloMock);

		assertTrue(plantaTest.getStocks().size()==(1));
	}
}