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

	@Before
	public void setUp() throws Exception {
		fabricaTest = new Fabrica();
		modeloMock = mock(Modelo.class);
		plantaMock = mock(Planta.class);
	}
	
	//El int que devuelve size() es ahora un Integer para poder mandarle
	// el mensaje equals y que de verde el coverage
	@Test 
	public void testAgregarPlanta() {
		fabricaTest.agregarPlanta(plantaMock);
		assertTrue(((Integer) fabricaTest.getPlantas().size()).equals(1));
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
}