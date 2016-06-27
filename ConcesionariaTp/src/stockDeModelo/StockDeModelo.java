package stockDeModelo;

import modelo.Modelo;

public class StockDeModelo{

	private Modelo modelo;
	private Integer cantidadDelStock;

	public StockDeModelo(Modelo unModelo){	
		this.modelo = unModelo;
		this.cantidadDelStock = 1;
	} 

	public String nombreDelModelo() {
		return modelo.getNombre();
	}

	public Integer getCantidad() {
		return this.cantidadDelStock;
	}
	
	public void agregarCantidad(){
		cantidadDelStock++;
	}
	
	//Prec: Si la cantidad es cero, rompe el invariante de stock
	// que dice que cantidad>0.
	public void quitarCantidad(){
		cantidadDelStock--;
	}

	public Modelo getModelo() {
		return modelo;
	}
}