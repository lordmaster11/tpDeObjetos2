package concesionaria;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import adjudicacion.Adjudicacion;
import adjudicacion.PorSorteo;
import cliente.Cliente;
import cuponDeAdjudicacion.CuponDeAdjudicacion;
import fabrica.Fabrica;
import googleMap.GoogleMap;
import modelo.Modelo;
import planDeAhorro.PlanDeAhorro;
import planta.Planta;
import seguroDeVida.SeguroDeVida;
import stockDeModelo.StockDeModelo;
import suscripto.Suscripto;

public class ConcesionariaTest {

	Concesionaria concesionariaTest;
	Fabrica fabricaMock;
	GoogleMap googleMapMock;
	Planta plantaMock;
	Modelo modeloMock;
	PlanDeAhorro planDeAhorroMock;
	PlanDeAhorro planDeAhorro2Mock;
	Cliente clienteMock;
	StockDeModelo stock1Mock;
	StockDeModelo stock2Mock;
	Modelo modeloMock1;
	Modelo modeloMock2;
	Adjudicacion unaAdjudicacionMock;
	CuponDeAdjudicacion cuponMock;
	Planta planta2Mock;
	Suscripto suscriptoMock;
	Suscripto suscripto2Mock;
	SeguroDeVida seguroMock;
	
	
	@Before
	public void setUp() throws Exception {
		
		fabricaMock = mock(Fabrica.class);
		googleMapMock = mock(GoogleMap.class);
		plantaMock = mock(Planta.class);
		planta2Mock = mock(Planta.class);
		modeloMock = mock(Modelo.class);
		modeloMock2 = mock(Modelo.class);
		modeloMock1 = mock(Modelo.class);
		planDeAhorroMock= mock(PlanDeAhorro.class);
		planDeAhorro2Mock= mock(PlanDeAhorro.class);
		unaAdjudicacionMock= mock(PorSorteo.class);
		clienteMock = mock(Cliente.class);
		suscripto2Mock = mock(Suscripto.class);
		suscriptoMock = mock(Suscripto.class);
		cuponMock = mock(CuponDeAdjudicacion.class);
		seguroMock = mock(SeguroDeVida.class);
		concesionariaTest = new Concesionaria ("Rodolfo Lopez 666", fabricaMock, 1000f, googleMapMock);
		
	}
	
	@Test 
	public void testGastoDeFlete(){
		concesionariaTest.gastoDeFlete(plantaMock);
		//que no se puede devolver ningun resultado porque
		//estamos manejando un random, y si esta mal porque!?
		//como testearlo?
		//si se considera un "smell", porque???
		//y acordarse porque me dice el profesor que es un smell??
	}
	
	@Test
	public void testAgregarCupon(){
		concesionariaTest.emitirCupon(cuponMock);
		
		assertTrue(concesionariaTest.getCupones().contains(cuponMock));
	}
	
	@Test
	public void agregarPlantaTest(){
		concesionariaTest.agregarPlanta(plantaMock);
		
		verify(fabricaMock).agregarPlanta(plantaMock);
	}
	 
	@Test
	public void agregarClienteTest(){
		concesionariaTest.agregarCliente(clienteMock);
		
		assertTrue(concesionariaTest.getClientes().contains(clienteMock));
	}
	
	@Test
	public void gastosDeAdministracionTest(){
		assertTrue(concesionariaTest.gastosAdministrativos().equals(1000f));
	}
	
	@Test
	public void suscribirClienteTest(){
		concesionariaTest.suscribirClienteAlPlan(clienteMock, planDeAhorroMock);
		
		verify(planDeAhorroMock).suscribirCliente(clienteMock);
	}
	
	@Test
	public void agregarPlanesTest(){
		concesionariaTest.agregarPlanDeAhorro(planDeAhorroMock);
		
		assertTrue(concesionariaTest.getPlanes().contains(planDeAhorroMock));
	}
	
	@Test 
	public void montoDelSeguroTest(){
		when(seguroMock.montoAPagar(suscriptoMock, modeloMock)).thenReturn(500f);
		concesionariaTest.setSeguro(seguroMock);
		
		assertTrue(concesionariaTest.montoDelSeguro(suscriptoMock, modeloMock).equals(500f));
	}
	
	@Test
	public void plantaMasCercana1Test(){
		modeloMock1 = mock(Modelo.class);
		when(modeloMock1.getNombre()).thenReturn("Clio");
		modeloMock2 = mock(Modelo.class);
		when(modeloMock1.getNombre()).thenReturn("Clio 2");

		stock1Mock=mock(StockDeModelo.class);
		when(stock1Mock.getModelo()).thenReturn(modeloMock1);
		stock2Mock=mock(StockDeModelo.class);
		when(stock1Mock.getModelo()).thenReturn(modeloMock2);
		 
		List<StockDeModelo> stocksMock =new ArrayList<StockDeModelo>(Arrays.asList(stock1Mock,stock2Mock));
		when(plantaMock.getStocks()).thenReturn(stocksMock);

		List<Planta> plantasConModelo;
		plantasConModelo = new ArrayList<Planta>(Arrays.asList(plantaMock));
		
		when(fabricaMock.plantasConModelo(modeloMock1)).thenReturn(plantasConModelo);
		
		assertTrue((concesionariaTest.plantaMasCercana(modeloMock1)).equals(plantaMock));
	}
	 
	@Test
	public void plantaMasCercana2Test(){
		modeloMock1 = mock(Modelo.class);
		when(modeloMock1.getNombre()).thenReturn("BORA");
		
		stock1Mock=mock(StockDeModelo.class);
		when(stock1Mock.getModelo()).thenReturn(modeloMock1);
		when(googleMapMock.calcularDistancia(plantaMock)).thenReturn(100);
		
		stock2Mock=mock(StockDeModelo.class);
		when(stock1Mock.getModelo()).thenReturn(modeloMock1);
		when(googleMapMock.calcularDistancia(planta2Mock)).thenReturn(10);
		
		List<StockDeModelo> stocksMock =new ArrayList<StockDeModelo>(Arrays.asList(stock1Mock));
		when(plantaMock.getStocks()).thenReturn(stocksMock);

		List<StockDeModelo> stocks2Mock =new ArrayList<StockDeModelo>(Arrays.asList(stock2Mock));
		when(planta2Mock.getStocks()).thenReturn(stocks2Mock);

		List<Planta> plantasConModelo;
		plantasConModelo = new ArrayList<Planta>(Arrays.asList(plantaMock,planta2Mock));
		
		when(fabricaMock.plantasConModelo(modeloMock1)).thenReturn(plantasConModelo);
		
		assertTrue((concesionariaTest.plantaMasCercana(modeloMock1)).equals(planta2Mock));
	}
	
	@Test //(expected = SinStockException.class)
	public void adjudicarAutoTest(){
		when(fabricaMock.stock(modeloMock)).thenReturn(5);
		when(planDeAhorroMock.getModelo()).thenReturn(modeloMock);
		
		List<Planta> plantasConModelo;
		plantasConModelo = new ArrayList<Planta>(Arrays.asList(plantaMock));
		when(fabricaMock.plantasConModelo(modeloMock)).thenReturn(plantasConModelo);
		when(planDeAhorroMock.getConcesionaria()).thenReturn(concesionariaTest);
		when(planDeAhorroMock.clienteAdjudicado()).thenReturn(suscriptoMock);
			
		concesionariaTest.adjudicarAuto(planDeAhorroMock);
		
		verify(fabricaMock).quitarUnModeloDeStock(modeloMock, plantaMock);
		//pregunto si en sus disponibles sigue el nuevo adjudicado
		assertFalse(planDeAhorroMock.disponibles().contains(suscriptoMock));
		
	}
	
	@Test
	public void pagarCuotaTest(){
		when(suscriptoMock.cantidadCuotasPagas()).thenReturn(10);		
		List<Suscripto> suscriptos = new ArrayList<Suscripto>(Arrays.asList(suscriptoMock,suscripto2Mock));
		when(planDeAhorroMock.getSubscriptos()).thenReturn(suscriptos);	
		concesionariaTest.agregarPlanDeAhorro(planDeAhorro2Mock);
		concesionariaTest.agregarPlanDeAhorro(planDeAhorroMock);
		concesionariaTest.cobrarCuota(suscriptoMock,planDeAhorroMock);
		
		verify(suscriptoMock).pagarCuota(planDeAhorroMock);
		
	}
	
}