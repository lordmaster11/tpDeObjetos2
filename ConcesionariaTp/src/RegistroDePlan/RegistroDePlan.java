package RegistroDePlan;

import java.util.Date;

import cliente.Cliente;

public class RegistroDePlan {

	private Cliente cliente;
	private Object fechaDeInscripcion;
	
	public RegistroDePlan(Cliente unCliente, Date unaFecha) {
		this.cliente = unCliente;
		this.fechaDeInscripcion = unaFecha;		
	}

}
