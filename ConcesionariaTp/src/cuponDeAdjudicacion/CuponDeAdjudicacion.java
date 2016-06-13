package cuponDeAdjudicacion;

import java.util.ArrayList;

import cliente.Cliente;

public class CuponDeAdjudicacion {

	private static Cliente cliente;
	private static Float monto;
	
	public CuponDeAdjudicacion(Cliente unCliente, Float unMonto){
		this.cliente = unCliente;	
		this.monto = unMonto;
	}
	
	//nose si esta bien esto, pq se pone static?????
	public static void montoAPagar(Cliente cliente2, Float monto2){
		cliente = cliente2;
		monto = monto2;
	}

	
}
