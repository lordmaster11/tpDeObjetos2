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
	
	@Test
	public void testQuitarCantidad(){
		
		Concesionaria concesionariaMock = mock(Concesionaria.class);
		Planta plantaMock = mock(Planta.class);
		
		stockTest.addObserver(concesionariaMock);
		stockTest.addObserver(plantaMock);
		stockTest.agregarCantidad();
		stockTest.quitarCantidad();
		
		assertTrue(stockTest.getCantidad()==1);
	}
	
	@Test
	public void testGetNombreDelModelo(){
		Modelo modeloMock = new Modelo ("Peugeot 206", 2000, 4, "Full", 60000f);
		assertTrue(modeloMock.getNombre()=="Peugeot 206");
	}
	
}
