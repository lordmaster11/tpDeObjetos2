package stockDeModelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import modelo.Modelo;
import planta.Planta;
import stockDeModelo.StockDeModelo;
import concesionaria.Concesionaria;

public class StockDeModeloTest {

	StockDeModelo stockTest;
	Modelo modeloMock;
	Concesionaria concesionariaMock;
	Planta plantaMock;
	
	@Before
	public void setUp(){
		modeloMock = mock(Modelo.class);
		stockTest = new StockDeModelo(modeloMock);
	}

	@Test
	public void testAgregarCantidad(){		
		stockTest.agregarCantidad();
		
		assertTrue(stockTest.getCantidad().equals(2));
	}
	
	@Test 
	public void testQuitarCantidad(){
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