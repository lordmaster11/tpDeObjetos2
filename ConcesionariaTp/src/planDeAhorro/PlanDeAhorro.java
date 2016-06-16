package planDeAhorro;

import java.util.ArrayList;
import java.util.List;

import registroDePlan.Suscripto;
import adjudicacion.Adjudicacion;
import cliente.Cliente;
import concesionaria.Concesionaria;
import financiamiento.Financiamiento;
import modelo.Modelo;

public class PlanDeAhorro {

	private Integer numeroGrupo;
	private Modelo modelo;
	private List<Suscripto> suscriptos;
	private Financiamiento financiamiento;
	private Adjudicacion adjudicacion;
	private Integer cantidadDeCuotas;
	private Concesionaria concesionaria;
	
	public PlanDeAhorro(Integer unNumero, Modelo unModelo, Financiamiento unFinanciamiento,
			            Adjudicacion unaAdjudicacion, Integer unasCuotas, Concesionaria unaConcesionaria) {
		this.numeroGrupo = unNumero;
		this.modelo = unModelo;
		this.financiamiento = unFinanciamiento;
		this.suscriptos = new ArrayList<Suscripto>();
		this.adjudicacion = unaAdjudicacion;
		this.cantidadDeCuotas = unasCuotas;
		this.concesionaria = unaConcesionaria;
	} 

	public Float valorADesembolzar(){
		return this.financiamiento.valorTotalEnCuotas(modelo);
	}
	
	
	public List<Suscripto> getSubscriptos() {
		return this.suscriptos;
	}
	
	/**
	public Boolean estaSuscripto(Cliente unCliente) {
		Boolean encontrado = false;
		
		for(Cliente c: suscriptos){
			if(c.getDNI().equals(unCliente.getDNI()))
				encontrado = true;
		}
		return encontrado;
	}*/ //No es necesario, pero si hace falta ya esta codeado

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

	public void agregarSuscripto(Cliente unCliente) {
		suscriptos.add(clienteASuscripto(unCliente));
	}

	private Suscripto clienteASuscripto(Cliente unCliente) {
		return new Suscripto(unCliente);
	}

	public Float alicuota() {
		return financiamiento.valorTotalEnCuotas(getModelo()) / cantidadDeCuotas;
	}

	public Concesionaria getConcesionaria() {
		return this.concesionaria;
	}

	public List<Suscripto> disponibles() {
		List<Suscripto> noAdjudicados = new ArrayList<Suscripto>();
		
		for(Suscripto s: suscriptos){
			if(s.aunNoFueAdjudicado())
				noAdjudicados.add(s);
		}
		return noAdjudicados;
	}
	
	public List<Suscripto> losQueMasPagaron(){
		List<Suscripto>  ganadores = new ArrayList<Suscripto>();
		
		for(Suscripto participantes: disponibles()){
			if(participantes.cuotasPagas()==mayorCantidadCuotasPagas())
				ganadores.add(participantes);
		}
		return ganadores;		
	}

	private Integer mayorCantidadCuotasPagas() {
		Integer mayorPagas = 0;
		
		for(Suscripto current : disponibles()) {
			if(current.cuotasPagas()>mayorPagas)
				mayorPagas = current.cuotasPagas();
		}
		return mayorPagas;
	}

	public List<Suscripto> losMasViejos(List<Suscripto> ganadores){
		List<Suscripto> mayores = new ArrayList<Suscripto>();
		
		for(Suscripto current : ganadores){
			if(current.getFecNac().equals(elmasViejo(ganadores)))
				mayores.add(current);
		}
		return mayores;
	}

	private Suscripto elmasViejo(List<Suscripto> ganadores) {
		Suscripto mayor = ganadores.get(0);
		
		for(Suscripto current : ganadores) {
			if(current.getFecNac().before(mayor.getFecNac()))
				mayor = current;
		}
		return mayor;
	}
	
	public Suscripto elPrimerSuscriptor(List<Suscripto> ganadores){
		Suscripto elGanador = ganadores.get(0);
		
		for(Suscripto current : ganadores) {
			if(current.getFechaDeInscripcion().before(elGanador.getFechaDeInscripcion()))
				elGanador = current;
		}
		return elGanador;
	}
	
	public Suscripto clienteAdjudicado(){
		return adjudicacion.seleccionDeCliente(this);
	}
}
