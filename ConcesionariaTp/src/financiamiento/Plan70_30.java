package financiamiento;

import modelo.Modelo;

public class Plan70_30 extends Financiamiento{

	@Override
	public Float valorTotalEnCuotas(Modelo m){
		return (m.getValorVenta() * 70) / 100;
	}
}
