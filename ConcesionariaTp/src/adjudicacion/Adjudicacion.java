package adjudicacion;

import RegistroDePlan.Suscripto;
import planDeAhorro.PlanDeAhorro;

public interface Adjudicacion {

	public Suscripto seleccionDeCliente(PlanDeAhorro plan);
}

