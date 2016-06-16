package adjudicacion;

import planDeAhorro.PlanDeAhorro;
import registroDePlan.Suscripto;

public interface Adjudicacion {

	public Suscripto seleccionDeCliente(PlanDeAhorro plan);
}

