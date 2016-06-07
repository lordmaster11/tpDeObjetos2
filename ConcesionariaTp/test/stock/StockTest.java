package stock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Observer;

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
	Planta plantaMock;
	
	@Before
	public void setUp(){
		modeloMock = mock(Modelo.class);
		Planta plantaMock = mock(Planta.class);
		Concesionaria concesionariaMock = mock(Concesionaria.class);
		stockTest = new StockDeModelo(modeloMock, plantaMock, concesionariaMock);
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
