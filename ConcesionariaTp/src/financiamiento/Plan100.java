package financiamiento;

import modelo.Modelo;

public class Plan100 extends Financiamiento{

	@Override
	public Float valorTotalEnCuotas(Modelo m){
		return m.getValorVenta();
	}

}
