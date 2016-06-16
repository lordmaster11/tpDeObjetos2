package seguroDeVida;

import modelo.Modelo;
import suscripto.Suscripto;

public class SeguroDeVida {
	
	public Float montoAPagar(Suscripto s, Modelo modelo){
		Integer i =(50 + this.mayorDeEdad(s.edadSuscripto()));
		return i + ((modelo.getValorVenta() * 5) /100);
	}

	private Integer mayorDeEdad(Integer edad) {
		Integer resp = 0;
	
		if(50<edad){
			resp = (edad - 50) * 10;
		}
		return resp;
	}
}