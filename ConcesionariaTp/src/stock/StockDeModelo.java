package stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import modelo.Modelo;

public class StockDeModelo extends Observable{

	private Modelo modelo;
	private Integer cantidadDelStock;
	private List<Observer> observadores;
	
	public StockDeModelo(Modelo unModelo){
		this.observadores = new ArrayList<Observer>();
		this.modelo = unModelo;
		this.cantidadDelStock = 1;
	}

	public String nombreDelModelo() {
		return modelo.getNombre();
	}

	public Integer getCantidad() {
		return cantidadDelStock;
	}
	
	public void agregarCantidad(){
		cantidadDelStock++;
		for(Observer obs: observadores){
			obs.update(this, "subi el stock");
		}
	}
	
	//Prec: Si la cantidad es cero, rompe el invariante de stock
	// que dice que cantidad>0.
	public void quitarCantidad(){
		cantidadDelStock--;
		for(Observer obs: observadores){
			obs.update(this, "reste el stock");
		}
	}

	public Modelo getModelo() {
		return modelo;
	}
	
	public void addObserver(Observer obs){
		observadores.add(obs);
	}
}
