package planta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import modelo.Modelo;
import stockDeModelo.StockDeModelo;

public class Planta{	
	private List<StockDeModelo> stocks;
	private String direccion;

	public Planta(String unaDireccion) {
		this.direccion = unaDireccion;
		this.stocks = new ArrayList<StockDeModelo>();
	}

	public List<StockDeModelo> getStocks() {
		return stocks;
	}
	
	public StockDeModelo buscarStockDelModelo(Modelo model){
		return stocks.stream()
				     .filter(stock -> (stock.getModelo().getNombre())
				     .equals(model.getNombre()))
				     .collect(Collectors.toList())
				     .get(0);
	}
	
	public List<String> nombresDeLosModelos(){
		return  stocks.stream()
	                  .map(StockDeModelo::getNombreDelModelo)
	                  .collect(Collectors.toList());
	}
	
	public void agregarModelo(Modelo modelo) {	
		if(existeElModelo(modelo)){
			StockDeModelo stock = buscarStockDelModelo(modelo);
			stock.agregarCantidad();			
		}else{
			this.agregarStock(new StockDeModelo(modelo));
		}
	}

	public Boolean existeElModelo(Modelo modelo) {
		return nombresDeLosModelos().contains(modelo.getNombre());
	}

	public void quitarModelo(Modelo modelo) {
        StockDeModelo stock = buscarStockDelModelo(modelo);
		if(stock.getCantidad()!=1){
			stock.quitarCantidad();
		}else{
			stocks.remove(stock);
		}
	}

	public void agregarStock(StockDeModelo unStockTest) {
		stocks.add(unStockTest);		
	}  
}