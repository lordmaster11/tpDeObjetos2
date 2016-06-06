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
		
		assertTrue(stockTest.getCantidad().equals(2));
	}
	
	///????? nose si esta bien
	
	@Test 
	public void testQuitarCantidad(){
		
		Concesionaria concesionariaMock = mock(Concesionaria.class);
		Planta plantaMock = mock(Planta.class);
		
		stockTest.addObserver(concesionariaMock);
		stockTest.addObserver(plantaMock);
		stockTest.agregarCantidad();
		stockTest.quitarCantidad();
		
		assertTrue(stockTest.getCantidad().equals(1));
	}
	
	@Test
	public void testNombreDelModelo(){
		when(modeloMock.getNombre()).thenReturn("Peugeot 206");
				
		assertTrue(stockTest.nombreDelModelo().equals("Peugeot 206"));
	}
	
	
	@Test
	public void testGetModelo() {	
		assertTrue(stockTest.getModelo().equals(modeloMock));
	}
	

}
