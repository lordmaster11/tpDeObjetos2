package cuponDeAdjudicacion;

import java.util.ArrayList;

import cliente.Cliente;

public class CuponDeAdjudicacion {

	private Cliente cliente;
	private Float monto;
	
	public CuponDeAdjudicacion(Cliente unCliente, Float unMonto){
		this.cliente = unCliente;	
		this.monto = unMonto;
	}
	
	public Float montoAPagar(){
		return monto= gastoDeFlete() + valorMovil();
	}

	private Float valorMovil() {
		// TODO Auto-generated method stub
		return 0f;
	}

	private Float gastoDeFlete() {
		// TODO Auto-generated method stub
		return 0f;
	}
}
