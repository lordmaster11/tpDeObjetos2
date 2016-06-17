package fabrica;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import modelo.Modelo;
import planta.Planta;
import stockDeModelo.StockDeModelo;

public class FabricaTest {
	
	Fabrica fabricaTest;
	Planta plantaMock;
	Modelo modeloMock;
	Planta planta2Mock;	

	@Before
	public void setUp() throws Exception {
		fabricaTest = new Fabrica();
		modeloMock = mock(Modelo.class);
		plantaMock = mock(Planta.class);
		planta2Mock = mock(Planta.class);
	}
	
	//El int que devuelve size() es ahora un Integer para poder mandarle
	// el mensaje equals y que de verde el coverage
	@Test 
	public void testAgregarPlanta() {
		fabricaTest.agregarPlanta(plantaMock);
		assertTrue(fabricaTest.getPlantas().contains(plantaMock));
	}
	
	@Test
	public void testActualizarPrecio() {
		
		when(modeloMock.getNombre()).thenReturn("Peugeot 206");
		
		Planta plantaMock2 = mock(Planta.class);
		fabricaTest.agregarPlanta(plantaMock2);
		when(plantaMock.nombresDeLosModelos()).thenReturn(new ArrayList<>());
		
		fabricaTest.agregarPlanta(plantaMock);
		when(plantaMock.nombresDeLosModelos()).thenReturn(new ArrayList<String>(Arrays.asList("Peugeot 206")));
		
		StockDeModelo stockMock = mock(StockDeModelo.class);
		when(plantaMock.buscarStockDelModelo(modeloMock)).thenReturn(stockMock);
		when(stockMock.getModelo()).thenReturn(modeloMock);
		
		fabricaTest.actualizarPrecio(70000f, modeloMock);
		verify(modeloMock).setPrecio(70000f);
	}
	
	@Test
	public void testQuitarUnModeloDeStock() {
		
		fabricaTest.quitarUnModeloDeStock(modeloMock,plantaMock);
		
		verify(plantaMock).quitarModelo(modeloMock);
	}
	@Test
	public void teststock() {
		
		
		
		ArrayList<String> modelos= new ArrayList<String>(Arrays.asList("Peugeot 206","Peugeot 208"));
		when(plantaMock.nombresDeLosModelos()).thenReturn(modelos);
		
		when(modeloMock.getNombre()).thenReturn("Peugeot 206");
		
		when(plantaMock.nombresDeLosModelos()).thenReturn(modelos);
		when(planta2Mock.nombresDeLosModelos()).thenReturn(modelos);
		
		StockDeModelo stockDeModeloMock;
		stockDeModeloMock = mock(StockDeModelo.class);
		
		when(stockDeModeloMock.getCantidad()).thenReturn(3);
		when(plantaMock.buscarStockDelModelo(modeloMock)).thenReturn(stockDeModeloMock);
		when(planta2Mock.buscarStockDelModelo(modeloMock)).thenReturn(stockDeModeloMock);
		
		
		fabricaTest.agregarPlanta(planta2Mock);
		fabricaTest.agregarPlanta(plantaMock);
		
		assertTrue(fabricaTest.stock(modeloMock).equals(6));
	}
	
}