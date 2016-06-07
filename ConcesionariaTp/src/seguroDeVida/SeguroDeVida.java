package seguroDeVida;

import cliente.Cliente;
import modelo.Modelo;

public interface SeguroDeVida {
	
	public Float montoAPagar(Cliente cliente, Modelo modelo);
}
