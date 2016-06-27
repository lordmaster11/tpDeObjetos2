package adjudicacion;

import java.util.Random;

import planDeAhorro.PlanDeAhorro;
import suscripto.Suscripto;

public class PorSorteo implements Adjudicacion{

	private Random  rnd;
	
	public PorSorteo(Random rnd) {
		this.rnd = rnd;
	}
	 
	@Override
	public Suscripto seleccionDeCliente(PlanDeAhorro plan){		
		return plan.disponibles().get(rnd.nextInt() );
	}
}
