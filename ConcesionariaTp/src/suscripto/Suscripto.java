package suscripto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cliente.Cliente;
import comprobanteDePago.ComprobanteDePago;

public class Suscripto {

	private Cliente cliente;
	private Date fechaDeInscripcion;
	private List<ComprobanteDePago> comprobantes;
	private Boolean fueAdjudicado;
	
	public Suscripto(Cliente unCliente) {
		this.cliente = unCliente;
		this.fechaDeInscripcion = new Date();
		this.fueAdjudicado =false;
		this.comprobantes = new ArrayList<ComprobanteDePago>();
	}

	public Integer edadSuscripto(){
		return cliente.edadCliente();
	}

	public Boolean aunNoFueAdjudicado() {
		return !fueAdjudicado;
	}

	public Integer cantidadCuotasPagas() {
		return comprobantes.size();
	}

	public Calendar getFecNac() {
		return cliente.getFechaNacimiento();
	}

	public Date getFechaDeInscripcion() {
		return fechaDeInscripcion;
	}

	public void seAdjudico() {
		this.fueAdjudicado=true;	
	}

	public Date getFechaDeIngreso() {
		return cliente.getFechaIngreso();
	}
}
