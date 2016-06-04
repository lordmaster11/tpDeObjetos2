package modelo;

import java.util.Observable;
import java.util.Observer;

public class Modelo implements Observer{

	private String nombre;
	private Integer a�oDeLanzamiento;
	private Integer puertas;
	private String clase;
	private Float precioInicial;
	private Float precioVenta;

	public Modelo(String unNombre, Integer unA�o, Integer nPuertas, String unaClase, Float unPrecio) {
		this.nombre = unNombre;
		this.a�oDeLanzamiento = unA�o;
		this.puertas = nPuertas;
		this.clase = unaClase;
		this.precioInicial = unPrecio;
	}

	@Override
	public void update(Observable observable, Object valor) {
		setNuevoValor(this.precioInicial *(Float) valor);	
	}

	private void setNuevoValor(Float nuevoValor) {
		this.precioVenta = nuevoValor;
	}

	public Float getValorVenta() {
		return this.precioVenta;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setPrecio(Float precioNuevo) {
		this.precioInicial = precioNuevo;
	}
}
