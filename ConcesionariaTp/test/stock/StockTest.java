package stock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import modelo.Modelo;
import planta.Planta;
import stockDeModelo.StockDeModelo;
import concesionaria.Concesionaria;

public class StockTest {

	StockDeModelo stockTest;
	Modelo modeloMock;
	Concesionaria concesionariaMock;
	
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
	
	public void testQuitarCantidad(){
		
		Planta plantaMock = mock(Planta.class);
		stockTest.addObserver(concesionariaMock);
		stockTest.agregarCantidad();
		stockTest.quitarCantidad();
		
		assertTrue(stockTest.getCantidad()==555);
	}

}
