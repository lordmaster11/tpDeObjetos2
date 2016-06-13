package cuponDeAdjudicacion;

import java.util.ArrayList;

import cliente.Cliente;

public class CuponDeAdjudicacion {

	private  Cliente cliente;
	private  Float monto;
	
	public CuponDeAdjudicacion(Cliente unCliente, Float unMonto){
		this.cliente = unCliente;	
		this.monto = unMonto;
	}
	
	/*nose si esta bien esto, pq se pone static?????
	public void montoAPagar(Cliente cliente2, Float monto2){
		cliente = cliente2;
		monto = monto2;
	}
*/
	
}
