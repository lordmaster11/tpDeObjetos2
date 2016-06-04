package adjudicacion;

import java.util.ArrayList;
import java.util.Random;

import cliente.Cliente;
import planDeAhorro.PlanDeAhorro;

public class PorSorteo extends Adjudicacion{

	@Override
	public Cliente seleccionDeCliente(PlanDeAhorro plan){
		
		Random  rnd = new Random();
		Cliente ganador = plan.getSubscriptos().get((int)(rnd.nextDouble() * (plan.getSubscriptos().size()-1)));
		return ganador;
	}

}
