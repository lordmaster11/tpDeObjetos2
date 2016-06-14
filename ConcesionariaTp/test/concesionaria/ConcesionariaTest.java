package concesionaria;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import adjudicacion.Adjudicacion;
import adjudicacion.PorSorteo;
import GoogleMap.GoogleMap;
import cliente.Cliente;
import cuponDeAdjudicacion.CuponDeAdjudicacion;
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
	CuponDeAdjudicacion cuponMock;
	
	
	@Before
	public void setUp() throws Exception {
		
		fabricaMock = mock(Fabrica.class);
		googleMapMock = mock(GoogleMap.class);
		plantaMock = mock(Planta.class);
		modeloMock = mock(Modelo.class);
		modeloMock2 = mock(Modelo.class);
		modeloMock1 = mock(Modelo.class);
		concesionariaTest = new Concesionaria ("Rodolfo Lopez 666", fabricaMock,1000f);
		stockMock = mock(StockDeModelo.class);
		stockMock1 = mock(StockDeModelo.class);
		planDeAhorroMock= mock(PlanDeAhorro.class);
		unaAdjudicacionMock= mock(PorSorteo.class);
		clienteMock = mock(Cliente.class);
		cuponMock = mock(CuponDeAdjudicacion.class);
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
		
		
		assertTrue(((Integer)concesionariaTest.getCupones().size()).equals(1));
	}
}

