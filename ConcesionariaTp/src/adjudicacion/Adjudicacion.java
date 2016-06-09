package adjudicacion;

import cliente.Cliente;
import planDeAhorro.PlanDeAhorro;

public interface Adjudicacion {

	Cliente seleccionDeCliente(PlanDeAhorro plan);
	
}

