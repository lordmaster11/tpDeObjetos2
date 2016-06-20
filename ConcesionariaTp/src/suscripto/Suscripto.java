package suscripto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
		this.fechaDeInscripcion = new GregorianCalendar();
		this.esAdjudicado =false;
		this.comprobantes = new ArrayList<ComprobanteDePago>();
		// no entiendo cual es la necesidad de que suscripto conosca un plan.
		// nose en donde lo usas. la unica vez que utilizas plan de ahorro se 
		// lo pasas como parametro.
		// lo que tenia pensado es que el pagar cuota se hacia en consecionaria.se le
		//pasa un plan al que el suscripto/cliente va pagar y un suscr./cliente.
		//busca en el plan de ahorro ese suscripto y le agrega un comprobante(esto es
		//el mensaje de abajo pagar cuota)
		//lo que teniamos hecho era cada plan de ahorro tenia una lista de suscripto, y
		
		//tambien el mensaje que sacaste(numero de cuota)va, xq usa ese mensaje cuando 
		//se ganera el 
		//comprobante de pago. utiliza ese mensaje para saver que numero de cuota 
		//se va pagar. Nose porque lo inicializar en 0 al numero de cuota y no entiendo
		//como queres sumarselo. el mensaje era para que me de el largo de la lista
		// y con eso se la cantiadad de cuotas pagas
		
		//PARA MI ES COMO ESTABA. PERO ME PUEDO EQUIVOCAR
		
		
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
	
	public Calendar getFecNac() {
		return cliente.getFechaNacimiento();
	}


	public Calendar getFechaDeInscripcion() {
		return fechaDeInscripcion;
	}

	public void seAdjudico() {
		this.esAdjudicado=true;	
	}

	public Cliente getCliente() {	
		return this.cliente;
	}
	
	public void pagarCuota(PlanDeAhorro plan) {
		ComprobanteDePago comprobanteNuevo = new ComprobanteDePago(plan, this);
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
	 * 
	 * 
	private Integer numeroDeCuota() {
		Integer cuota = 0;
		for(ComprobanteDePago comprobante : comprobantes)
		cuota = comprobante.getNumeroDeCuotas() + 1;
		return cuota;
	}
	LO MODIFIQUE COMO CREO QUE VA ASI, y lo ago publico porque lo va utilizar comprobante
	de pago
	 * */
	public Integer proximaCuotaAPagar() {
		
		return this.comprobantes.size()+1;
	}

	
	
	
}