package fabrica;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import modelo.Modelo;
import planta.Planta;

public class FabricaTest {
	
	Fabrica fabricaTest;
	Planta plantaMock;
	Modelo modeloMock;	

	@Before
	public void setUp() throws Exception {
		fabricaTest = new Fabrica();
	}
	

	@Test
	public void testAgregarPlanta() {
		fabricaTest.agregarPlanta(plantaMock);
		
		assertTrue(fabricaTest.getPlantas().size()==1);
	}
	
	@Test
	public void testActualizarPrecio() {
		
		fabricaTest.actualizarPrecio(65000f, modeloMock);
		
		verify(modeloMock.getValorVenta().equals(65000f));
	}

}
/*
public void actualizarPrecio(Float precioNuevo, Modelo model){
	Planta p = plantaConModelo(model);
	p.buscarStockDelModelo(model).getModelo().setPrecio(precioNuevo);
}
verify(unBanco).agregarSolicitud(creditoMock);

*/