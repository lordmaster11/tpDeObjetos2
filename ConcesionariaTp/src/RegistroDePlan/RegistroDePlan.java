package RegistroDePlan;

import java.util.Date;

import cliente.Cliente;

public class RegistroDePlan {

	private Cliente cliente;
	private Date fechaDeInscripcion;
	private  Boolean fueAdjudicado;
	private Integer ultimaCuotaPaga;
	
	public RegistroDePlan(Cliente unCliente, Date unaFecha) {
		this.cliente = unCliente;
		this.fechaDeInscripcion = unaFecha;
		this.fueAdjudicado =false;
		this.ultimaCuotaPaga =0;
	}

}
