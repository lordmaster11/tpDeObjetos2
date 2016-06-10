package concesionaria;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import adjudicacion.Adjudicacion;
import adjudicacion.PorSorteo;
import GoogleMap.GoogleMap;
import cliente.Cliente;
import fabrica.Fabrica;
import modelo.Modelo;
import planDeAhorro.PlanDeAhorro;
import planta.Planta;
import stockDeModelo.StockDeModelo;

public class ConcesionariaTest {

	Concesionaria concesionariaTest;
	Fabrica fabricaMock;
	GoogleMap googleMapMock;
	Planta plantaMock;
	Modelo modeloMock;
	PlanDeAhorro planDeAhorroMock;
	Cliente clienteMock;
	StockDeModelo stockMock;
	StockDeModelo stockMock1;
	Modelo modeloMock1;
	Modelo modeloMock2;
	Adjudicacion unaAdjudicacionMock;
	Cliente unClienteMock;
	
	@Before
	public void setUp() throws Exception {
		
		fabricaMock = mock(Fabrica.class);
		googleMapMock = mock(GoogleMap.class);
		plantaMock = mock(Planta.class);
		modeloMock = mock(Modelo.class);
		modeloMock2 = mock(Modelo.class);
		modeloMock1 = mock(Modelo.class);
		concesionariaTest = new Concesionaria ("Rodolfo Lopez 666", fabricaMock);
		stockMock = mock(StockDeModelo.class);
		stockMock1 = mock(StockDeModelo.class);
		planDeAhorroMock= mock(PlanDeAhorro.class);
		unaAdjudicacionMock= mock(PorSorteo.class);
		unClienteMock = mock(Cliente.class);
	}
	
	@Test
	public void testGastoDeFlete(){
		assertTrue(concesionariaTest.gastoDeFlete(plantaMock).equals(200f));
	}
	
	@Test
	public void testAgregarClientes(){
		concesionariaTest.agregarCliente(clienteMock);
		
		assertTrue(((Integer)concesionariaTest.getClientes().size()).equals(1));
	}
	
	@Test
	public void testAgregarPlan(){
		concesionariaTest.agregarPlanDeAhorro(planDeAhorroMock);
		
		assertTrue(((Integer)concesionariaTest.getPlanes().size()).equals(1));
	}
	
	
	@Test
	public void testAdjudicarAuto(){
		when(modeloMock1.getNombre()).thenReturn("Peugeot 206");
		when(modeloMock2.getNombre()).thenReturn("Peugeot 208");

		when(stockMock.getModelo()).thenReturn(modeloMock1);
		when(stockMock.getCantidad()).thenReturn(5);
		when(stockMock1.getModelo()).thenReturn(modeloMock2);
		when(stockMock1.getCantidad()).thenReturn(5);
		
		List<StockDeModelo> unStocksDeModelos;
		unStocksDeModelos = new ArrayList<StockDeModelo>();
		unStocksDeModelos.add(stockMock);
		unStocksDeModelos.add(stockMock1);
	
		when(plantaMock.getStocks()).thenReturn(unStocksDeModelos);
		
		
		when(planDeAhorroMock.getModelo()).thenReturn(modeloMock2);
		
		when(planDeAhorroMock.getAdjudicacion()).thenReturn(unaAdjudicacionMock);
		
		//when(unaAdjudicacionMock.seleccionDeCliente(planDeAhorroMock)).thenReturn(unClienteMock);
		
		concesionariaTest.agregarPlanta(plantaMock);
		
		concesionariaTest.adjudicarAuto(planDeAhorroMock);
		
		//assertTrue((concesionariaTest.cantidadDelStock(modeloMock2))==(4));
		
		verify(stockMock1).cantidadDeModelosEs(4);
		
		//assertTrue(concesionariaTest.plantaMasCercanaConModelo(modeloMock2).);
	}

 

}

