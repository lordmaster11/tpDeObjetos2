package seguroDeVida;

import modelo.Modelo;
import suscripto.Suscripto;

public class SeguroDeVida {
	
	public Float montoAPagar(Suscripto suscripto, Modelo modelo){
		Integer monto = (50 + this.mayorDeEdad(suscripto.edadSuscripto()));
		return monto + ((modelo.getValorVenta() * 5) /100);
	}

	private Integer mayorDeEdad(Integer edad) {
		Integer resp = 0;
	
		if(50<edad){
			resp = (edad - 50) * 10;
		}
		return resp;
	}
}