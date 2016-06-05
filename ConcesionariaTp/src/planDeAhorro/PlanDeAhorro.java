package planDeAhorro;

import java.util.ArrayList;
import java.util.List;

import adjudicacion.Adjudicacion2;
import cliente.Cliente;
import financiamiento.Financiamiento;
import modelo.Modelo;

public class PlanDeAhorro {

	private Integer numeroGrupo;
	private Modelo modelo;
	private List<Cliente> suscriptos;
	private Financiamiento financiamiento;
	private Adjudicacion2 adjudicacion;
	
	
	public PlanDeAhorro(Integer unNumero, Modelo unModelo, Financiamiento unFinanciamiento,
			            Adjudicacion2 unaAdjudicacion) {
		this.numeroGrupo = unNumero;
		this.modelo = unModelo;
		this.financiamiento = unFinanciamiento;
		this.suscriptos = new ArrayList<Cliente>();
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
}
