package planDeAhorro;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import RegistroDePlan.RegistroDePlan;
import adjudicacion.Adjudicacion;
import cliente.Cliente;
import comprobanteDePago.ComprobanteDePago;
import financiamiento.Financiamiento;
import modelo.Modelo;
import seguroDeVida.SeguroDeVida;

public class PlanDeAhorro {

	private Integer numeroGrupo;
	private Modelo modelo;
	private List<Cliente> suscriptos;
	private Financiamiento financiamiento;
	private Adjudicacion adjudicacion;
	private Integer cantidadDeCuotas;
	private List<ComprobanteDePago> comprobantesDePago;
	private List<RegistroDePlan> registros;
	
	
	public PlanDeAhorro(Integer unNumero, Modelo unModelo, Financiamiento unFinanciamiento,
			            Adjudicacion unaAdjudicacion, Integer unasCuotas, ComprobanteDePago unComprobante) {
		this.numeroGrupo = unNumero;
		this.modelo = unModelo;
		this.financiamiento = unFinanciamiento;
		this.suscriptos = new ArrayList<Cliente>();
		this.adjudicacion = unaAdjudicacion;
		this.cantidadDeCuotas = unasCuotas;
		this.comprobantesDePago =  new ArrayList<ComprobanteDePago>();
		this.registros = new ArrayList<RegistroDePlan>();
	}

	public Float valorADesembolzar(){
		return this.financiamiento.valorTotalEnCuotas(modelo);
	}
	
	
	public ArrayList<Cliente> getSubscriptos() {
		return  (ArrayList<Cliente>) this.suscriptos;
	}

	public void suscribirCliente(Cliente unCliente) {	
		suscriptos.add(unCliente);
		registros.add(new RegistroDePlan(unCliente,new Date()));
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

	public void generarComprobanteDePago(Cliente unCliente) {

     re   new ComprobanteDePago(unCliente,(this.calcularCuotaDe(unCliente)), new Date(),this.calcularAlicuota(),this.calcularGastos(), SeguroDeVida unSeguro);
		
	}
}
