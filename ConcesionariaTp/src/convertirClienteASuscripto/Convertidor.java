package convertirClienteASuscripto;

import cliente.Cliente;
import planDeAhorro.PlanDeAhorro;
import suscripto.Suscripto;

public class Convertidor {
	
	public Convertidor() {
	}

	public Suscripto convertirClienteASuscripto (Cliente unCliente, PlanDeAhorro plan) {
		return new Suscripto(unCliente, plan);
	}
}
