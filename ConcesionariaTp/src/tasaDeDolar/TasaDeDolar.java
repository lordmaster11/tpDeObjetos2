package tasaDeDolar;

import java.util.Observable;

import modelo.Modelo;

public class TasaDeDolar extends Observable{

	private Float tasaDeDolar;
	private Modelo modelo;
	
	public TasaDeDolar(Float tasa) {
		this.tasaDeDolar = tasa;
	}

	public Float getTasaDeDolar() {
		return tasaDeDolar;
	}

	public void setTasaDeDolar(Float tasa) {
		this.tasaDeDolar = tasa;
		if(modelo != null)
			modelo.update(this, tasaDeDolar);
	}
	
	public void addObserver(Modelo model){
		this.modelo = model;
	}

}
