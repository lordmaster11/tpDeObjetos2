package adjudicacion;

import java.util.Random;

import RegistroDePlan.Suscripto;
import planDeAhorro.PlanDeAhorro;

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
