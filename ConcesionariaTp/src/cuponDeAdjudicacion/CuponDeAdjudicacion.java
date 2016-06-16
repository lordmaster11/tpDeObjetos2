package cuponDeAdjudicacion;

import planDeAhorro.PlanDeAhorro;
import registroDePlan.Suscripto;

public class CuponDeAdjudicacion {

	private  Suscripto suscripto;
	private  Float monto;
	
	public CuponDeAdjudicacion(PlanDeAhorro plan,Suscripto unSuscripto){
		this.suscripto = unSuscripto;
		this.monto = calcularMonto(plan);
	}
	
	public Float calcularMonto(PlanDeAhorro plan){
		Float total = plan.getConcesionaria().gastoDeFlete(
						plan.getConcesionaria().plantaMasCercana(
							plan.getModelo()));
		
		return total+plan.efectivoAPagar();
	}
}
