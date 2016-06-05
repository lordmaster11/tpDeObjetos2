package stock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import modelo.Modelo;
import planta.Planta;
import stockDeModelo.StockDeModelo;

public class StockTest {

	StockDeModelo stockTest;
	Modelo modeloMock;
	
	@Before
	public void setUp(){
		modeloMock = mock(Modelo.class);
		stockTest = new StockDeModelo(modeloMock);
	}

	@Test
	public void testAgregarCantidad(){
		
		Planta plantaMock = mock(Planta.class);
		stockTest.addObserver(plantaMock);
		stockTest.agregarCantidad();
		
		assertTrue(stockTest.getCantidad()==2);
	}

}
