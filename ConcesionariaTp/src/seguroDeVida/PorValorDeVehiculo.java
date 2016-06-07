package seguroDeVida;

import cliente.Cliente;
import modelo.Modelo;

public class PorValorDeVehiculo implements SeguroDeVida{

	@Override
	public Float montoAPagar(Cliente cliente, Modelo modelo) {
		return (modelo.getValorVenta() * 5) /100;
	}

}
