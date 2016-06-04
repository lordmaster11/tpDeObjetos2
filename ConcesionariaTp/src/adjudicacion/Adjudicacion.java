package adjudicacion;

import java.util.ArrayList;

import cliente.Cliente;
import planDeAhorro.PlanDeAhorro;

public abstract class Adjudicacion {

	public abstract Cliente seleccionDeCliente(PlanDeAhorro plan); 

}
