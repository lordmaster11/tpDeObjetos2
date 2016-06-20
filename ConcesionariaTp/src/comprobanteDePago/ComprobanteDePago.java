package comprobanteDePago;

import java.util.Date;

import planDeAhorro.PlanDeAhorro;
import suscripto.Suscripto;

public class ComprobanteDePago {

	private Suscripto suscripto;
	private Integer numeroDeCuota;
	private Date fechaDePago;
	private Float alicuota;
	private Float gastosAdministrativos;
	private Float seguroDeVida;

	public ComprobanteDePago(PlanDeAhorro plan, Suscripto suscripto){
		this.suscripto = suscripto;
		this.numeroDeCuota = suscripto.proximaCuotaAPagar();
		this.fechaDePago = new Date();
		this.alicuota = plan.alicuota();
		this.gastosAdministrativos = plan.getConcesionaria().gastosAdministrativos();
		this.seguroDeVida = plan.getConcesionaria().montoDelSeguro(suscripto,plan.getModelo());
	}

	public Integer getNumeroDeCuotas() {
		return this.numeroDeCuota;
	}

	
}
