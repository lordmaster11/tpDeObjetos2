package planDeAhorro;

import java.util.ArrayList;
import java.util.List;

import adjudicacion.Adjudicacion;
import cliente.Cliente;
import financiamiento.Financiamiento;
import modelo.Modelo;

public class PlanDeAhorro {

	private Integer numeroGrupo;
	private Modelo modelo;
	private List<Cliente> suscriptos;
	private Financiamiento financiamiento;
	private Adjudicacion adjudicacion;
	//private Integer cantidadDeCuotas;
	
	
	public PlanDeAhorro(Integer unNumero, Modelo unModelo, Financiamiento unFinanciamiento,
			            Adjudicacion unaAdjudicacion/*, Integer unasCuotas*/) {
		this.numeroGrupo = unNumero;
		this.modelo = unModelo;
		this.financiamiento = unFinanciamiento;
		this.suscriptos = new ArrayList<Cliente>();
		//this.cantidadDeCuotas = unasCuotas;
	}

	public Float valorADesembolzar(){
		return this.financiamiento.valorTotalEnCuotas(modelo);
	}
	
	public void adjudicarAuto(){
		Cliente cliente = adjudicacion.seleccionDeCliente(this);
		this.suscriptos.remove(cliente);
		//Quitar 1 del stock de los autos desde la concesionaria...
	}

	public ArrayList<Cliente> getSubscriptos() {
		return (ArrayList<Cliente>) suscriptos;
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
}
