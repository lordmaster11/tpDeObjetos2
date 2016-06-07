package seguroDeVida;

import cliente.Cliente;
import modelo.Modelo;

public class PorEdad implements SeguroDeVida{

	@Override
	public Float montoAPagar(Cliente cliente, Modelo modelo) {		
		return  (50f + this.mayorDeEdad(cliente.edadCliente()));
	}

	private Integer mayorDeEdad(Integer edad) {
		Integer resp;
		resp = 0;
		
		if(edad>50)
			resp = (edad -50)*10;
		
		return resp;
	}

}
