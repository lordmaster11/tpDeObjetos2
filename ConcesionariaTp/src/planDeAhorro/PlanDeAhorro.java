package planDeAhorro;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Suscripto> getSubscriptos() {
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

	public Float alicuota() {
		return financiamiento.valorTotalEnCuotas(getModelo()) / cantidadDeCuotas;
	}

	public Concesionaria getConcesionaria() {
		return this.concesionaria;
	}
 
	public List<Suscripto> disponibles() {
		List<Suscripto> noAdjudicados = new ArrayList<Suscripto>();
		
		for(Suscripto suscripto: suscriptos){
			if(suscripto.todaviaNoFueAdjudicado())
				noAdjudicados.add(suscripto);
		}
		return noAdjudicados;	
	}
	
	public List<Suscripto> suscriptosConMayorCantidadDeCuotasPagas(){
		List<Suscripto> suscriptosPagadores = new ArrayList<Suscripto>();
		
		for(Suscripto suscripto : disponibles()){
			if(suscripto.cantidadCuotasPagas() == mayorCantidadCuotasPagas())
				suscriptosPagadores.add(suscripto);
		}
		return suscriptosPagadores;
	} 
 
	private Integer mayorCantidadCuotasPagas() {
		Integer mayorCuotasPagas = 0;
		
		for(Suscripto suscripto : disponibles()) {
			if(suscripto.cantidadCuotasPagas() > mayorCuotasPagas)
				mayorCuotasPagas = suscripto.cantidadCuotasPagas();
		}
		return mayorCuotasPagas;
	}

	public List<Suscripto> losMasAntiguosEnConcesionaria(List<Suscripto> susc){	
		List<Suscripto> mayores = new ArrayList<Suscripto>();
		
		for(Suscripto suscripto : susc){
			if(suscripto.getFechaDeIngreso().equals(elMasAntiguoEnConcesionaria(susc).getFechaDeIngreso()))
				mayores.add(suscripto);
		}
		return mayores;  
	} 

	private Suscripto elMasAntiguoEnConcesionaria(List<Suscripto> suscriptos) {
		Suscripto elMasAntiguo = suscriptos.get(0);
		
		for(Suscripto suscripto : suscriptos) {
			if(suscripto.getFechaDeIngreso().before(elMasAntiguo.getFechaDeIngreso()))
				elMasAntiguo = suscripto;
		}
		return elMasAntiguo;
	}
	
	public Suscripto suscriptoMasAntiguo(List<Suscripto> suscriptos){
		Suscripto elMasAntiguo = suscriptos.get(0);
		
		for(Suscripto suscripto : suscriptos) {
			if(suscripto.getFechaDeInscripcion().before(elMasAntiguo.getFechaDeInscripcion()))
				elMasAntiguo = suscripto;
		}
		return elMasAntiguo;
	}
	
	public Suscripto clienteAdjudicado(){
		return adjudicacion.seleccionDeCliente(this);
	}

	public void setConvertidor(Convertidor unConvertidor) {
		this.convertidor=unConvertidor;		
	}
}