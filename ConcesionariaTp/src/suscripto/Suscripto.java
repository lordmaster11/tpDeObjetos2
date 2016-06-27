package suscripto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import cliente.Cliente;
import comprobanteDePago.ComprobanteDePago;
import planDeAhorro.PlanDeAhorro;

public class Suscripto {
	private Cliente cliente;
	private Calendar fechaDeInscripcion;
	private List<ComprobanteDePago> comprobantes;
	private Boolean esAdjudicado;
	private PlanDeAhorro planDeAhorro;
	
	public Suscripto(Cliente unCliente, PlanDeAhorro plan) {
		this.cliente = unCliente;
		this.fechaDeInscripcion = Calendar.getInstance();	
		this.esAdjudicado = false;
		this.comprobantes = new ArrayList<ComprobanteDePago>();		
		this.planDeAhorro = plan;
	}

	public Integer edadSuscripto(){
		return cliente.edadCliente();
	}

	public Boolean todaviaNoFueAdjudicado() {
		return !esAdjudicado;
	}

	public Integer cantidadCuotasPagas() {
		return this.getComprobantes().size();
	}

	public Calendar getFechaDeIngreso() {
		return cliente.getFechaIngreso();
	}
	
	public Calendar getFechaNac() {
		return cliente.getFechaNacimiento();
	}

	public Calendar getFechaDeInscripcion() {
		return fechaDeInscripcion;
	}

	public void seAdjudico() {
		this.esAdjudicado = true;	
	}

	public Cliente getCliente() {	
		return this.cliente;
	}
	
	public void pagarCuota(PlanDeAhorro plan) {
		ComprobanteDePago comprobanteNuevo = new ComprobanteDePago(plan, this);
		this.agregarComprobante(comprobanteNuevo);
	}
	
	private void agregarComprobante(ComprobanteDePago comprobante){
		this.comprobantes.add(comprobante);
	}
	
	public List<ComprobanteDePago> getComprobantes() {
		return this.comprobantes;
	}
	
	public Integer proximaCuotaAPagar() {	
		return this.comprobantes.size()+1;
	}	
}