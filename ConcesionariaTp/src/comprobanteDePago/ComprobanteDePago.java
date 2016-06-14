package comprobanteDePago;

import java.util.Date;

import RegistroDePlan.Suscripto;
import planDeAhorro.PlanDeAhorro;

public class ComprobanteDePago {

	private Suscripto suscripto;
	private Integer numeroDeCuota;
	private Date fechaDePago;
	private Float alicuota;
	private Float gastosAdministrativos;
	private Float seguroDeVida;

	public ComprobanteDePago(Integer nCuota, PlanDeAhorro plan, Suscripto s){
		this.suscripto = s;
		this.numeroDeCuota = nCuota;
		this.fechaDePago = new Date();
		this.alicuota = plan.alicuota();
		this.gastosAdministrativos = plan.getConcesionaria().gastosAdministrativos();
		this.seguroDeVida = plan.getConcesionaria().montoDelSeguro(s,plan.getModelo());
	}
}
