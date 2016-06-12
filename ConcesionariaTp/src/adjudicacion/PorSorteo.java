package adjudicacion;

import java.util.Random;

import cliente.Cliente;
import planDeAhorro.PlanDeAhorro;

public class PorSorteo implements Adjudicacion{

	Random  rnd;
	
	public PorSorteo(Random rnd) {
		super();
		this.rnd = rnd;
	}
	
	@Override
	public Cliente seleccionDeCliente(PlanDeAhorro plan){
		
				Cliente ganador = plan.getSubscriptos().get(rnd.nextInt() );
				
				//(int)(rnd.nextDouble() * (plan.getSubscriptos().size()-1)));
		return ganador;
	}
	
	/*
	@Override
	public Cliente seleccionDeCliente2(PlanDeAhorro plan){
		
		Random  rnd = new Random();
		Cliente ganador = plan.getSubscriptos().get((int)(rnd.nextDouble() * (plan.getSubscriptos().size()-1)));
		return ganador;
	}
	*/
}
