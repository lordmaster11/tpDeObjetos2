package planDeAhorro;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adjudicacion.Adjudicacion;
import cliente.Cliente;
import concesionaria.Concesionaria;
import convertirClienteASuscripto.Convertidor;
import financiamiento.Plan100;
import modelo.Modelo;
import suscripto.Suscripto;


public class PlanDeAhorroTest {	 
    PlanDeAhorro planDeAhorro;
    Cliente clienteMock;
    Cliente cliente2Mock;
    Cliente cliente3Mock;
    Modelo modeloMock;
	Plan100 plan100Mock;
	Adjudicacion adjudicacionMock;
	Concesionaria concesionariaMock;
	Suscripto suscriptoMock;
	Suscripto suscripto2Mock;
	Suscripto suscripto3Mock;
	Convertidor convertidorMock;
	
    @Before
    public void setUp() throws Exception {    	 
    	clienteMock = mock(Cliente.class);
    	cliente2Mock = mock(Cliente.class);
    	cliente3Mock = mock(Cliente.class);
    	suscriptoMock = mock(Suscripto.class);
    	suscripto2Mock = mock(Suscripto.class);
    	suscripto3Mock = mock(Suscripto.class);
    	modeloMock = mock(Modelo.class);
    	plan100Mock =  mock(Plan100.class);
    	adjudicacionMock = mock(Adjudicacion.class);
    	concesionariaMock = mock(Concesionaria.class);
    	convertidorMock = mock(Convertidor.class);
    	planDeAhorro =  new PlanDeAhorro(125, modeloMock, plan100Mock, adjudicacionMock, 60, concesionariaMock);   
    }

	@Test
	public void testAgregarCliente() {	
		planDeAhorro.suscribirCliente(clienteMock);
		when(convertidorMock.convertirClienteASuscripto(clienteMock, planDeAhorro)).thenReturn(suscriptoMock);
	
		assertTrue(planDeAhorro.cantSuscriptos().equals(1));	
	}
	
	@Test
	public void testGetSuscriptos() {
		planDeAhorro.suscribirCliente(clienteMock);
		when(convertidorMock.convertirClienteASuscripto(clienteMock, planDeAhorro)).thenReturn(suscriptoMock);
		
		assertTrue(((planDeAhorro.getSubscriptos().get(0)).getCliente()).equals(clienteMock));
	} 

	@Test
	public void testValorADesembolsar() {	
		when(modeloMock.getValorVenta()).thenReturn(100000f);
		when(plan100Mock.valorTotalEnCuotas(modeloMock)).thenReturn(70000f);
		
		assertTrue((planDeAhorro.valorADesembolzar()).equals(70000f));			
	}			 
	
	@Test
	public void testNuevoPlanDeAhorro(){ 		
		assertTrue(planDeAhorro.getModelo().equals(modeloMock));		
		assertTrue(planDeAhorro.getAdjudicacion().equals(adjudicacionMock));
		assertTrue(planDeAhorro.getConcesionaria().equals(concesionariaMock));
	}
	
	@Test
	public void efectivoAPagarTest(){ 			
		when(plan100Mock.efectivo(modeloMock)).thenReturn(0f);
		
		assertTrue(planDeAhorro.efectivoAPagar().equals(0f));
	}
		
	@Test
	public void alicuotaTest(){ 			
		when(plan100Mock.valorTotalEnCuotas(modeloMock)).thenReturn(60000f);
		
		assertTrue(planDeAhorro.alicuota().equals(1000f));
	}
	
	@Test
	public void disponiblesTrueTest(){
		planDeAhorro.suscribirCliente(clienteMock);
		when(convertidorMock.convertirClienteASuscripto(clienteMock, planDeAhorro)).thenReturn(suscriptoMock);
		when(suscriptoMock.todaviaNoFueAdjudicado()).thenReturn(false);
		
		planDeAhorro.suscribirCliente(cliente2Mock);
		when(convertidorMock.convertirClienteASuscripto(cliente2Mock, planDeAhorro)).thenReturn(suscripto2Mock);
		when(suscripto2Mock.todaviaNoFueAdjudicado()).thenReturn(true);
		
		assertTrue(planDeAhorro.disponibles().contains(suscripto2Mock));
	}

	@Test
	public void disponiblesFalseTest(){
		planDeAhorro.suscribirCliente(clienteMock);
		when(convertidorMock.convertirClienteASuscripto(clienteMock, planDeAhorro)).thenReturn(suscriptoMock);
		when(suscriptoMock.todaviaNoFueAdjudicado()).thenReturn(false);
		
		planDeAhorro.suscribirCliente(cliente2Mock);
		when(convertidorMock.convertirClienteASuscripto(cliente2Mock, planDeAhorro)).thenReturn(suscripto2Mock);
		when(suscripto2Mock.todaviaNoFueAdjudicado()).thenReturn(true);
		
		assertFalse(planDeAhorro.disponibles().contains(suscriptoMock));
	}
		
	/** 
	 * da siempre bien, cambias las cuotas y da siempre verde
	 */
	
	@Test
	public void mayorCantidadDeCuotasPagasTest(){	
		planDeAhorro.suscribirCliente(clienteMock);
		when(convertidorMock.convertirClienteASuscripto(clienteMock, planDeAhorro)).thenReturn(suscriptoMock);
		when(suscriptoMock.cantidadCuotasPagas()).thenReturn(5);
		
		planDeAhorro.suscribirCliente(cliente2Mock);
		when(convertidorMock.convertirClienteASuscripto(clienteMock, planDeAhorro)).thenReturn(suscripto2Mock);
		when(suscripto2Mock.cantidadCuotasPagas()).thenReturn(4);
		
		assertFalse(planDeAhorro.suscriptosConMayorCantidadDeCuotasPagas().equals(suscriptoMock));
	}
	
	@Test
	public void mayorCantidadDeCuotasPagasIgualesTest(){	
		when(suscriptoMock.todaviaNoFueAdjudicado()).thenReturn(true);
		planDeAhorro.suscribirCliente(clienteMock);
		when(convertidorMock.convertirClienteASuscripto(clienteMock, planDeAhorro)).thenReturn(suscriptoMock);
		when(suscriptoMock.cantidadCuotasPagas()).thenReturn(5);
		
		
		when(suscripto2Mock.todaviaNoFueAdjudicado()).thenReturn(true);
		planDeAhorro.suscribirCliente(cliente2Mock);
		when(convertidorMock.convertirClienteASuscripto(cliente2Mock, planDeAhorro)).thenReturn(suscripto2Mock);
		when(suscripto2Mock.cantidadCuotasPagas()).thenReturn(6);
		
		
		when(suscripto3Mock.todaviaNoFueAdjudicado()).thenReturn(true);
		planDeAhorro.suscribirCliente(cliente3Mock);
		when(convertidorMock.convertirClienteASuscripto(cliente3Mock, planDeAhorro)).thenReturn(suscripto3Mock);
		when(suscripto3Mock.cantidadCuotasPagas()).thenReturn(5);
		
		List<Suscripto> suscriptosCuotasPagas = new ArrayList<Suscripto>(Arrays.asList(suscriptoMock,suscripto3Mock));
		
		assertTrue(planDeAhorro.suscriptosConMayorCantidadDeCuotasPagas().equals(suscriptosCuotasPagas));
	}

	@Test
	public void elMasAntiguoEnConcesionariaTest(){
		Calendar fecha1 = new GregorianCalendar(1980, Calendar.FEBRUARY, 11);
		when(suscriptoMock.getFechaDeIngreso()).thenReturn(fecha1);
		
		Calendar fecha2 = new GregorianCalendar(1995, Calendar.JUNE, 29);
		when(suscripto2Mock.getFechaDeIngreso()).thenReturn(fecha2);
		
		Calendar fecha3 = new GregorianCalendar(1980, Calendar.FEBRUARY, 5);
		when(suscripto3Mock.getFechaDeIngreso()).thenReturn(fecha3);
	
		List<Suscripto> todosLosSuscriptos = new ArrayList<Suscripto>(Arrays.asList(suscriptoMock,suscripto2Mock,suscripto3Mock));
		
		List<Suscripto> suscriptosAntiguosEnConcesionaria= new ArrayList<Suscripto>(Arrays.asList(suscripto3Mock));
		
		assertTrue(planDeAhorro.losMasAntiguosEnConcesionaria(todosLosSuscriptos).equals(suscriptosAntiguosEnConcesionaria));	
	}
	
	@Test
	public void suscriptoMasAntiguoTest(){	
		Calendar fecha1 = new GregorianCalendar(2010, Calendar.FEBRUARY, 11);
		when(suscriptoMock.getFechaDeInscripcion()).thenReturn(fecha1);
		
		Calendar fecha2 = new GregorianCalendar(2003, Calendar.JUNE, 29);
		when(suscripto2Mock.getFechaDeInscripcion()).thenReturn(fecha2);
		
		Calendar fecha3 = new GregorianCalendar(2003, Calendar.JUNE, 31);
		when(suscripto3Mock.getFechaDeInscripcion()).thenReturn(fecha3);
	
		List<Suscripto> todosLosSuscriptos = new ArrayList<Suscripto>(Arrays.asList(suscriptoMock,suscripto2Mock,suscripto3Mock));
		
		assertTrue(planDeAhorro.suscriptoMasAntiguo(todosLosSuscriptos).equals(suscripto2Mock));		
	}
	
	@Test
	public void seleccionDeClienteTest(){
		when(adjudicacionMock.seleccionDeCliente(planDeAhorro)).thenReturn(suscripto2Mock);
		
		assertTrue(planDeAhorro.clienteAdjudicado().equals(suscripto2Mock));		
	}	
}