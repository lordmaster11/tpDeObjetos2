package concesionaria;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import GoogleMap.GoogleMap;
import cliente.Cliente;
import fabrica.Fabrica;
import modelo.Modelo;
import planDeAhorro.PlanDeAhorro;
import planta.Planta;

public class ConcesionariaTest {

	Concesionaria concesionariaTest;
	Fabrica fabricaMock;
	GoogleMap googleMapMock;
	Planta plantaMock;
	Modelo modeloMock;
	PlanDeAhorro planDeAhorroMock;
	Cliente clienteMock;
	
	@Before
	public void setUp() throws Exception {
		
		fabricaMock = mock(Fabrica.class);
		googleMapMock = mock(GoogleMap.class);
		plantaMock = mock(Planta.class);
		modeloMock = mock(Modelo.class);
		concesionariaTest = new Concesionaria ("Rodolfo Lopez 666", fabricaMock);
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

}
