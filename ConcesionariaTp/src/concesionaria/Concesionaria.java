package concesionaria;

import java.util.ArrayList;
import java.util.List;

import GoogleMap.GoogleMap;
import RegistroDePlan.Suscripto;
import cliente.Cliente;
import cuponDeAdjudicacion.CuponDeAdjudicacion;
import fabrica.Fabrica;
import modelo.Modelo;
import planDeAhorro.PlanDeAhorro;
import planta.Planta;
import seguroDeVida.SeguroDeVida;

public class Concesionaria{
	
	private String direccion;
	private Fabrica fabrica;
	private List<Cliente> clientes;
	private List<PlanDeAhorro> planes;
	private List<CuponDeAdjudicacion> cupones;
	private Float gastoPorAdministracion;
	private SeguroDeVida seguro;
	private GoogleMap mapa;
	
	public Concesionaria(String unaDireccion, Fabrica unaFabrica, Float gastos){
		this.direccion = unaDireccion;
		this.fabrica = unaFabrica;
		this.clientes = new ArrayList<Cliente>();
		this.planes = new ArrayList<PlanDeAhorro>();
		this.cupones = new ArrayList<CuponDeAdjudicacion>();
		this.seguro = new SeguroDeVida();
		this.mapa = new GoogleMap();
		this.gastoPorAdministracion = gastos;
	}

	public Float gastoDeFlete(Planta unaPlanta){
    	return mapa.calcularDistancia(unaPlanta)*this.gastoPorKilometro(); 
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
	 	Planta plantaEncontrada = fabrica.getPlantas().get(0);
	 	
	 	for(Planta unaPlanta:fabrica.plantasConModelo(unModelo)){
	 		if(mapa.calcularDistancia(unaPlanta)<mapa.calcularDistancia(plantaEncontrada))
	 			plantaEncontrada = unaPlanta;
	 	}			
		return plantaEncontrada;
	}
	
	public void adjudicarAuto(PlanDeAhorro unPlan){
		
		if(stock(unPlan.getModelo())>0){
			
			Suscripto unSuscripto = unPlan.clienteAdjudicado();
			CuponDeAdjudicacion cupon = cuponNuevo(unPlan,unSuscripto);
			
			this.quitarUnModelo(unPlan.getModelo());
			this.emitirCupon(cupon);
		}

	}
 
	private void quitarUnModelo(Modelo modelo) {
	    fabrica.quitarUnModeloDeStock(modelo,this.plantaMasCercana(modelo));
	}
	
	public void suscribirCliente(Cliente unCliente,PlanDeAhorro plan) {	
		plan.agregarSuscripto(unCliente);
	}

	public Float gastosAdministrativos() {
		return gastoPorAdministracion;
	}

	public Float montoDelSeguro(Suscripto s, Modelo modelo) {
		return seguro.montoAPagar(s, modelo);
	}
	
	public Integer stock(Modelo unModelo){
		return fabrica.stock(unModelo);
	}

	public List<CuponDeAdjudicacion> getCupones() {
		return cupones;
	}
}