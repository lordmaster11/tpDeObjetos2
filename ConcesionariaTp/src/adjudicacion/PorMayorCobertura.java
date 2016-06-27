package adjudicacion;

import java.util.List;

import planDeAhorro.PlanDeAhorro;
import suscripto.Suscripto;

public class PorMayorCobertura implements Adjudicacion{
	
	@Override
	public Suscripto seleccionDeCliente(PlanDeAhorro plan) {		
		Suscripto adjudicado;
		List<Suscripto> suscriptosConMasCuotas = plan.suscriptosConMayorCantidadDeCuotasPagas();
		
		if(suscriptosConMasCuotas.size()==1){
			adjudicado = suscriptosConMasCuotas.get(0);
		}
		else{
			if(plan.losMasAntiguosEnConcesionaria(suscriptosConMasCuotas).size()==1){
				adjudicado = plan.losMasAntiguosEnConcesionaria(suscriptosConMasCuotas).get(0);	
			} 
			else {
				adjudicado = plan.suscriptoMasAntiguo(plan.losMasAntiguosEnConcesionaria(suscriptosConMasCuotas));
			}
		} 
		return adjudicado;
	}
}