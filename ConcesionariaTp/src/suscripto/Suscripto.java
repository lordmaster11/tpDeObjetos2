package suscripto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cliente.Cliente;
import comprobanteDePago.ComprobanteDePago;
import planDeAhorro.PlanDeAhorro;

public class Suscripto {

	private Cliente cliente;
	private Date fechaDeInscripcion;
	private List<ComprobanteDePago> comprobantes;
	private Boolean esAdjudicado;
	private PlanDeAhorro planDeAhorro;
	
	public Suscripto(Cliente unCliente, PlanDeAhorro plan) {
		this.cliente = unCliente;
		this.fechaDeInscripcion = new Date();
		this.esAdjudicado =false;
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
		return comprobantes.size();
	}

	public Calendar getFecNac() {
		return cliente.getFechaNacimiento();
	}

	public Date getFechaDeInscripcion() {
		return fechaDeInscripcion;
	}

	public void seAdjudico() {
		this.esAdjudicado=true;	
	}

	public Date getFechaDeIngreso() {
		return cliente.getFechaIngreso();
	}

	public Cliente getCliente() {	
		return this.cliente;
	}
	
	public void pagarCuota(PlanDeAhorro plan) {
		ComprobanteDePago comprobanteNuevo = new ComprobanteDePago(plan, this);
		comprobanteNuevo.agregarCuota();
		this.agregarComprobante(comprobanteNuevo);
	}
	
	public void agregarComprobante(ComprobanteDePago comprobante){
		this.comprobantes.add(comprobante);
	}
	
	public List<ComprobanteDePago> getComprobantes() {
		return this.comprobantes;
	}
	
	/*
	 * esto no va, lo hice pq antes se pasaban las cuotas en el constructor, 
	 * y para mi deberian inicializar en 0 y despues se deberian de ir sumando,
	 * 
	private Integer numeroDeCuota() {
		Integer cuota = 0;
		for(ComprobanteDePago comprobante : comprobantes)
		cuota = comprobante.getNumeroDeCuotas() + 1;
		return cuota;
	}
	*/
}