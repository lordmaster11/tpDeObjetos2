package seguroDeVida;

import RegistroDePlan.Suscripto;
import modelo.Modelo;

public class SeguroDeVida {
	
	public Float montoAPagar(Suscripto s, Modelo modelo){
		Integer i =(50 + this.mayorDeEdad(s.edadSuscripto()));
		return i + (modelo.getValorVenta() * 5) /100;
	}

	private Integer mayorDeEdad(Integer edad) {
		Integer resp = 0;
	
		if(edad>50)
			resp = (edad - 50) * 10;
	
		return resp;
	}
}