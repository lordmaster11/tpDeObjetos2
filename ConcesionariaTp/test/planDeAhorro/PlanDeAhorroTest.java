package planDeAhorro;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adjudicacion.Adjudicacion;
import cliente.Cliente;
import comprobanteDePago.ComprobanteDePago;
import financiamiento.Financiamiento;
import modelo.Modelo;


public class PlanDeAhorroTest {
	
    PlanDeAhorro planDeAhorro;
    Cliente clienteMock;
	Modelo modeloMock;
	Financiamiento financiamiento70_30Mock;
	Adjudicacion adjudicacionMock;
	ComprobanteDePago comprobanteMock;
       
    @Before
    public void setUp() throws Exception {
    	 
    	clienteMock = mock(Cliente.class);
    	modeloMock = mock(Modelo.class);
    	financiamiento70_30Mock =  mock(Financiamiento.class);
    	adjudicacionMock = mock(Adjudicacion.class);
    	planDeAhorro =  new PlanDeAhorro(125, modeloMock, financiamiento70_30Mock, adjudicacionMock, 0, comprobanteMock);
    
    }

	@Test
	public void testSuscribirCliente() {
		
		planDeAhorro.suscribirCliente(clienteMock);
		
		assertTrue(planDeAhorro.cantSuscriptos().equals(1));
	}
	
	@Test
	public void testGetSuscriptos() {
		planDeAhorro.suscribirCliente(clienteMock);
		
		assertTrue (((Integer)planDeAhorro.getSubscriptos().size()).equals(1));
	}
	@Test
	public void testValorADesembolsar() {
		
		when(modeloMock.getValorVenta()).thenReturn(100000f);
		when(financiamiento70_30Mock.valorTotalEnCuotas(modeloMock)).thenReturn(70000f);
		
		assertTrue((planDeAhorro.valorADesembolzar()).equals(70000f));
				
	}			 
	
	
	
	

}