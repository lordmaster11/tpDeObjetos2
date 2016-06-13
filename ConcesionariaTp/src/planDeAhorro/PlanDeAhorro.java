package planDeAhorro;

import java.util.ArrayList;
import java.util.List;

import adjudicacion.Adjudicacion;
import cliente.Cliente;
import comprobanteDePago.ComprobanteDePago;
import financiamiento.Financiamiento;
import modelo.Modelo;

public class PlanDeAhorro {

	private Integer numeroGrupo;
	private Modelo modelo;
	private List<Cliente> suscriptos;
	private Financiamiento financiamiento;
	private Adjudicacion adjudicacion;
	private Integer cantidadDeCuotas;
	private ComprobanteDePago comprobanteDePago;
	
	
	public PlanDeAhorro(Integer unNumero, Modelo unModelo, Financiamiento unFinanciamiento,
			            Adjudicacion unaAdjudicacion, Integer unasCuotas, ComprobanteDePago unComprobante) {
		this.numeroGrupo = unNumero;
		this.modelo = unModelo;
		this.financiamiento = unFinanciamiento;
		this.suscriptos = new ArrayList<Cliente>();
		this.adjudicacion = unaAdjudicacion;
		this.cantidadDeCuotas = unasCuotas;
		this.comprobanteDePago = unComprobante;
	}

	public Float valorADesembolzar(){
		return this.financiamiento.valorTotalEnCuotas(modelo);
	}
	
	
	public ArrayList<Cliente> getSubscriptos() {
		return  (ArrayList<Cliente>) this.suscriptos;
	}

	public void suscribirCliente(Cliente unCliente) {
		suscriptos.add(unCliente);
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
		Float efectivo = financiamiento.efectivo(this.getModelo());
		return efectivo;
	}
}
