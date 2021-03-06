package concesionaria;

import java.util.ArrayList;
import java.util.List;

import cliente.Cliente;
import cuponDeAdjudicacion.CuponDeAdjudicacion;
import excepciones.SinStockException;
import fabrica.Fabrica;
import googleMap.GoogleMap;
import modelo.Modelo;
import planDeAhorro.PlanDeAhorro;
import planta.Planta;
import seguroDeVida.SeguroDeVida;
import suscripto.Suscripto;

public class Concesionaria{
	private String direccion;
	private Fabrica fabrica;
	private List<Cliente> clientes;
	private List<PlanDeAhorro> planes;
	private List<CuponDeAdjudicacion> cupones;
	private Float gastoPorAdministracion;
	private SeguroDeVida seguro;
	private GoogleMap mapa; 
	
	public Concesionaria(String unaDireccion, Fabrica unaFabrica, Float gastos,GoogleMap unGoogleMap){
		this.direccion = unaDireccion;
		this.fabrica = unaFabrica;
		this.clientes = new ArrayList<Cliente>();
		this.planes = new ArrayList<PlanDeAhorro>();
		this.cupones = new ArrayList<CuponDeAdjudicacion>();
		this.seguro = new SeguroDeVida();
		this.mapa = unGoogleMap;
		this.gastoPorAdministracion = gastos;
	}

	public Float gastoDeFlete(Planta unaPlanta){
    	return mapa.calcularDistancia(unaPlanta) * this.gastoPorKilometro(); 
    }

	private Float gastoPorKilometro(){		
		return 20f;
	}

	public void agregarCliente(Cliente cliente){
		clientes.add(cliente);
	}
	
	public void agregarPlanDeAhorro(PlanDeAhorro plan){
		planes.add(plan);
	}
	
	public void agregarPlanta(Planta unaPlanta) {
        fabrica.agregarPlanta(unaPlanta);		
	}
	
	public CuponDeAdjudicacion cuponNuevo(PlanDeAhorro plan, Suscripto s){
		return new CuponDeAdjudicacion(plan,s);
	}
	
	public void emitirCupon(CuponDeAdjudicacion cupon){
		cupones.add(cupon);
	}
	
	//PREC.: El modelo existe.
	public Planta plantaMasCercana(Modelo unModelo){
	 	Planta plantaEncontrada = fabrica.plantasConModelo(unModelo).get(0);
	 	
	 	for(Planta unaPlanta:fabrica.plantasConModelo(unModelo)){
	 		if(mapa.calcularDistancia(unaPlanta)<mapa.calcularDistancia(plantaEncontrada))
	 			plantaEncontrada = unaPlanta;
	 	}			
		return plantaEncontrada;
	}
	
	public void adjudicarAuto(PlanDeAhorro unPlan){
		if(pedirStock(unPlan.getModelo())>0){
			
			Suscripto unSuscripto = unPlan.clienteAdjudicado();
			unSuscripto.seAdjudico();
			CuponDeAdjudicacion cupon = cuponNuevo(unPlan,unSuscripto);
			 
			this.quitarUnModelo(unPlan.getModelo());
			this.emitirCupon(cupon);
		}
	}
 
	private void quitarUnModelo(Modelo modelo) {
	    fabrica.quitarUnModeloDeStock(modelo,this.plantaMasCercana(modelo));
	}
	
	public void suscribirClienteAlPlan(Cliente unCliente,PlanDeAhorro plan) {	
		plan.suscribirCliente(unCliente);
	}

	public Float gastosAdministrativos() {
		return gastoPorAdministracion;
	}

	public Float montoDelSeguro(Suscripto suscripto, Modelo modelo) {
		return seguro.montoAPagar(suscripto, modelo);
	}
	
	public Integer pedirStock(Modelo unModelo){
		try{
			return fabrica.stock(unModelo);
		}catch(SinStockException str){
			return 0;
		}
	}

	public List<CuponDeAdjudicacion> getCupones() {
		return cupones;
	}
	
	public List<Cliente> getClientes() {			
		return clientes;
	}

	public List<PlanDeAhorro> getPlanes() {
		return planes;
	}
		
	public List<PlanDeAhorro> losDiezPlanesConMayorCantidadDeSubscriptos(){
		List<PlanDeAhorro> resultado = new ArrayList<PlanDeAhorro>();
		List<PlanDeAhorro> planesDesordenados = planes;
		Integer repeticiones = 0;
		
		while((repeticiones < 10) && ((planesDesordenados.size()>0))){
			PlanDeAhorro unPlan =this.planConMasSuscriptos(planesDesordenados);
			
			resultado.add(unPlan);
			
			planesDesordenados.remove(unPlan);
			repeticiones++;
		}
		return resultado;
	}
	
	private PlanDeAhorro planConMasSuscriptos(List<PlanDeAhorro> planess){
		return planess.stream()
					  .max((PlanDeAhorro p1, PlanDeAhorro p2)-> p1.cantSuscriptos()
					  .compareTo(p2.cantSuscriptos()))
					  .get();
	}
	
	public void setSeguro(SeguroDeVida seguroDeVida) {
		this.seguro=seguroDeVida;	
	}

	public void cobrarCuota(Suscripto suscripto,PlanDeAhorro plan) {
		for(PlanDeAhorro p:planes){
			if(p==plan)
				for(Suscripto s: plan.getSuscriptos()){
					if(s== suscripto)
					s.pagarCuota(plan);
		}	
	  }
	}	
}