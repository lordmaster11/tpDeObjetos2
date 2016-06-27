package concesionaria;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fabrica.Fabrica;
import googleMap.GoogleMap;
import planDeAhorro.PlanDeAhorro;


public class los10PlanesConMasSuscriptosTest {
	PlanDeAhorro planDeAhorro1Mock;
	PlanDeAhorro planDeAhorro2Mock;
	PlanDeAhorro planDeAhorro3Mock;
	PlanDeAhorro planDeAhorro4Mock;
	PlanDeAhorro planDeAhorro5Mock;
	PlanDeAhorro planDeAhorro6Mock;
	PlanDeAhorro planDeAhorro7Mock;
	PlanDeAhorro planDeAhorro8Mock;
	PlanDeAhorro planDeAhorro9Mock;
	PlanDeAhorro planDeAhorro10Mock;
	PlanDeAhorro planDeAhorro11Mock;
	PlanDeAhorro planDeAhorro12Mock;
	PlanDeAhorro planDeAhorro13Mock;
	PlanDeAhorro planDeAhorro14Mock;
	PlanDeAhorro planDeAhorro15Mock;
	Concesionaria concesionariaTest;
	Fabrica fabricaMock;
	GoogleMap googleMapMock;
	
	@Before
	public void setUp() throws Exception {
		fabricaMock = mock(Fabrica.class);
		googleMapMock = mock(GoogleMap.class);
		concesionariaTest = new Concesionaria ("Rodolfo Lopez 666", fabricaMock, 1000f, googleMapMock);
		planDeAhorro1Mock = mock(PlanDeAhorro.class);
		planDeAhorro2Mock = mock(PlanDeAhorro.class);
		planDeAhorro3Mock = mock(PlanDeAhorro.class);
		planDeAhorro4Mock = mock(PlanDeAhorro.class);
		planDeAhorro5Mock = mock(PlanDeAhorro.class);
		planDeAhorro6Mock = mock(PlanDeAhorro.class);
		planDeAhorro7Mock = mock(PlanDeAhorro.class);
		planDeAhorro8Mock = mock(PlanDeAhorro.class);
		planDeAhorro9Mock = mock(PlanDeAhorro.class);
		planDeAhorro10Mock = mock(PlanDeAhorro.class);
		planDeAhorro11Mock = mock(PlanDeAhorro.class);
		planDeAhorro12Mock = mock(PlanDeAhorro.class);
		planDeAhorro13Mock = mock(PlanDeAhorro.class);
		planDeAhorro14Mock = mock(PlanDeAhorro.class);
		planDeAhorro15Mock = mock(PlanDeAhorro.class);	
	}

	@Test
	public void los10PlanesConMasCantidadDeSuscriptosTest() {
		when(planDeAhorro1Mock.cantSuscriptos()).thenReturn(100);
		when(planDeAhorro2Mock.cantSuscriptos()).thenReturn(5);
		when(planDeAhorro3Mock.cantSuscriptos()).thenReturn(6);
		when(planDeAhorro4Mock.cantSuscriptos()).thenReturn(7);
		when(planDeAhorro5Mock.cantSuscriptos()).thenReturn(8);
		when(planDeAhorro6Mock.cantSuscriptos()).thenReturn(9);
		when(planDeAhorro7Mock.cantSuscriptos()).thenReturn(10);
		when(planDeAhorro8Mock.cantSuscriptos()).thenReturn(11);
		when(planDeAhorro9Mock.cantSuscriptos()).thenReturn(12);
		when(planDeAhorro10Mock.cantSuscriptos()).thenReturn(13);
		when(planDeAhorro11Mock.cantSuscriptos()).thenReturn(14);
		when(planDeAhorro12Mock.cantSuscriptos()).thenReturn(15);
		when(planDeAhorro13Mock.cantSuscriptos()).thenReturn(16);
		when(planDeAhorro14Mock.cantSuscriptos()).thenReturn(17);
		when(planDeAhorro15Mock.cantSuscriptos()).thenReturn(1);
		
		concesionariaTest.agregarPlanDeAhorro(planDeAhorro1Mock);
		concesionariaTest.agregarPlanDeAhorro(planDeAhorro2Mock);
		concesionariaTest.agregarPlanDeAhorro(planDeAhorro3Mock);
		concesionariaTest.agregarPlanDeAhorro(planDeAhorro4Mock);
		concesionariaTest.agregarPlanDeAhorro(planDeAhorro5Mock);
		concesionariaTest.agregarPlanDeAhorro(planDeAhorro6Mock);
		concesionariaTest.agregarPlanDeAhorro(planDeAhorro7Mock);
		concesionariaTest.agregarPlanDeAhorro(planDeAhorro8Mock);
		concesionariaTest.agregarPlanDeAhorro(planDeAhorro9Mock);
		concesionariaTest.agregarPlanDeAhorro(planDeAhorro10Mock);
		concesionariaTest.agregarPlanDeAhorro(planDeAhorro11Mock);
		concesionariaTest.agregarPlanDeAhorro(planDeAhorro12Mock);
		concesionariaTest.agregarPlanDeAhorro(planDeAhorro13Mock);
		concesionariaTest.agregarPlanDeAhorro(planDeAhorro14Mock);
		concesionariaTest.agregarPlanDeAhorro(planDeAhorro15Mock);
		
		List<PlanDeAhorro> planesEsperadosEnOrden= new ArrayList<PlanDeAhorro>
		                                          (Arrays.asList(planDeAhorro1Mock,
		                                        		  planDeAhorro14Mock,planDeAhorro13Mock,planDeAhorro12Mock,
		                                        		  planDeAhorro11Mock,planDeAhorro10Mock,planDeAhorro9Mock,
		                                        		  planDeAhorro8Mock,planDeAhorro7Mock,planDeAhorro6Mock));
		
		assertTrue(concesionariaTest.losDiezPlanesConMayorCantidadDeSubscriptos().equals(planesEsperadosEnOrden));
		}
}