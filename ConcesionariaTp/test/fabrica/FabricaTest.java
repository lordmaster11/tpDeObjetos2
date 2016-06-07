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

/*
public void actualizarPrecio(Float precioNuevo, Modelo model){
	Planta p = plantaConModelo(model);
	p.buscarStockDelModelo(model).getModelo().setPrecio(precioNuevo);
}
verify(unBanco).agregarSolicitud(creditoMock);

*/

/*

falta inicializar algunas clases

Modelo modeloMock;
Float nuevoPrecio;
Fabrica unaFabrica;
Planta plantaMock;
StockDeModelo stockDeModeloMock;
List<StockDeModelo> modelosMock;
ArrayList<String> modelos;


@Before
public void setUp() throws Exception {
	nuevoPrecio = 80000f;
	modelos = new ArrayList<String>();
	modelos.add("Peugeot 206");
	modelos.add("Peugeot 208");
	
	modeloMock = mock(Modelo.class);
	when(modeloMock.getNombre()).thenReturn("Peugeot 206");
	when(modeloMock.getValorVenta()).thenReturn(60000f);
	/*
	stockDeModeloMock= mock(StockDeModelo.class);
	when(stockDeModeloMock.getModelo()).thenReturn(modeloMock);
	when(stockDeModeloMock.getCantidad()).thenReturn(5);*/
/*	
    plantaMock = mock(Planta.class);
    when(plantaMock.getStocks()).thenReturn(modelosMock);
    when(plantaMock.buscarStockDelModelo(modeloMock)).thenReturn(stockDeModeloMock);
    when(plantaMock.nombresDeLosModelos()).thenReturn(modelos);
}

@Test
public void testBuscarModelo() {
	
	
	assertTrue(unaFabrica.plantaConModelo(modeloMock).equals(plantaMock));
}


public void testActualizarPrecio() {
	
	unaFabrica.actualizarPrecio(nuevoPrecio, modeloMock);
	assertTrue(modeloMock.getValorVenta().equals(nuevoPrecio));
}
*/


