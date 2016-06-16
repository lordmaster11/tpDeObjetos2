package adjudicacion;

import java.util.List;

import planDeAhorro.PlanDeAhorro;
import registroDePlan.Suscripto;

public class PorMayorCobertura implements Adjudicacion{
	
	@Override
	public Suscripto seleccionDeCliente(PlanDeAhorro plan) {
		
		Suscripto retorno;
		List<Suscripto> pagadores = plan.losQueMasPagaron();
		
		if(pagadores.size()==1){
			retorno = pagadores.get(0);
		}
		else{
			if(plan.losMasViejos(pagadores).size()==1){
				retorno = plan.losMasViejos(pagadores).get(0);	
			} 
			else {
				retorno = plan.elPrimerSuscriptor(plan.losMasViejos(pagadores));
			}
		}
		return retorno;
	}
	//ESTO SE TIENE QUE HACER CON EXPRESIONES LAMDA.. PROXIMAMENTE
	//el if debe conmemplar mayor proporcion de pago y antiguedad
}
