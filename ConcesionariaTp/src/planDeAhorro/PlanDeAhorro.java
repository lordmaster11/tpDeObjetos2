package planDeAhorro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import adjudicacion.Adjudicacion;
import cliente.Cliente;
import concesionaria.Concesionaria;
import convertirClienteASuscripto.Convertidor;
import financiamiento.Financiamiento;
import modelo.Modelo;
import suscripto.Suscripto;

public class PlanDeAhorro {
	private Integer numeroGrupo;
	private Modelo modelo;
	private List<Suscripto> suscriptos;
	private Financiamiento financiamiento;
	private Adjudicacion adjudicacion;
	private Integer cantidadDeCuotas;
	private Concesionaria concesionaria;
	private Convertidor convertidor;
	
	public PlanDeAhorro(Integer unNumero, Modelo unModelo, Financiamiento unFinanciamiento,
			            Adjudicacion unaAdjudicacion, Integer unasCuotas, Concesionaria unaConcesionaria) {
		this.numeroGrupo = unNumero;
		this.modelo = unModelo;
		this.financiamiento = unFinanciamiento;
		this.suscriptos = new ArrayList<Suscripto>();
		this.adjudicacion = unaAdjudicacion;
		this.cantidadDeCuotas = unasCuotas;
		this.concesionaria = unaConcesionaria;
		this.convertidor = new Convertidor();
	} 

	public Float valorADesembolzar(){
		return this.financiamiento.valorTotalEnCuotas(modelo);
	}
	
	public List<Suscripto> getSuscriptos() {
		return this.suscriptos;
	}

	public Integer cantSuscriptos() {
		return suscriptos.size();
	}

	public Adjudicacion getAdjudicacion() {
		return this.adjudicacion;
	}

	public Modelo getModelo() {
		return this.modelo;
	}

	public Float efectivoAPagar() {
		return financiamiento.efectivo(this.getModelo());
	}
	
	public void suscribirCliente(Cliente unCliente) {
		Suscripto suscripto = convertidor.convertirClienteASuscripto(unCliente, this);
		this.agregarSuscripto(suscripto);
	}

	private void agregarSuscripto(Suscripto unSuscripto) {
		suscriptos.add(unSuscripto);
	}

	//Calcula el valor de la cuota nueva a pagar.En caso
	//de que exista algun cambio en el valor del automovil este calcula esa diferencia
	//en las cuotas que resten por pagar.
	
	public Float alicuota(Suscripto unSuscripto) {
		return (financiamiento.valorTotalEnCuotas(getModelo())-unSuscripto.valorPagadoDelAuto()) 
				/( cantidadDeCuotas - unSuscripto.cantidadCuotasPagas());	
	}

	public Concesionaria getConcesionaria() {
		return this.concesionaria;
	}
 	
	public List<Suscripto> disponibles() {
		return suscriptos.stream().filter(suscripto -> suscripto.noFueAdjudicado()).collect(Collectors.toList());	
	}
	
	public List<Suscripto> suscriptosConMayorCantidadDeCuotasPagas(){
		return disponibles().stream()
							.filter(suscripto -> suscripto.cantidadCuotasPagas().equals(this.mayorCantidadCuotasPagas()))
							.collect(Collectors.toList());
	} 
 
	private Integer mayorCantidadCuotasPagas() {
		return disponibles().stream()
							.max((Suscripto s1, Suscripto s2)-> s1.cantidadCuotasPagas()
							.compareTo(s2.cantidadCuotasPagas()))
							.get().cantidadCuotasPagas();
	}
	
	public List<Suscripto> losMasAntiguosEnConcesionaria(List<Suscripto> lsSuscriptos){	
		return lsSuscriptos.stream()
				   		  .filter(suscripto -> suscripto.getFechaDeIngreso()
				          .equals(elMasAntiguoEnConcesionaria(lsSuscriptos).getFechaDeIngreso()))
				          .collect(Collectors.toList());  
	} 
	
	private Suscripto elMasAntiguoEnConcesionaria(List<Suscripto> lsSuscriptos) {
		return lsSuscriptos.stream()
						   .min((Suscripto s1, Suscripto s2)-> s1.getFechaDeIngreso()
						   .compareTo(s2.getFechaDeIngreso()))
						   .get();
	}
		
	public Suscripto suscriptoMasAntiguo(List<Suscripto> lsSuscriptos){
		return lsSuscriptos.stream()
				   		   .min((Suscripto s1, Suscripto s2)-> s1.getFechaDeInscripcion()
				   		   .compareTo(s2.getFechaDeInscripcion()))
				           .get();
	}
	
	public Suscripto clienteAdjudicado(){
		return adjudicacion.seleccionDeCliente(this);
	}

	public void setConvertidor(Convertidor unConvertidor) {
		this.convertidor = unConvertidor;		
	}
}