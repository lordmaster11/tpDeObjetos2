package planta;

import java.util.ArrayList;
import java.util.List;

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
		StockDeModelo stockQueBusco = null;
		 
		for(StockDeModelo stock : stocks){
			if(stock.getModelo().getNombre()==(model.getNombre())){
				stockQueBusco = stock;
			}
		}
		return stockQueBusco;
	}
	
	public ArrayList<String> nombresDeLosModelos(){
		ArrayList<String> nombres = new ArrayList<String>();
		
		for(StockDeModelo stock : stocks){
			nombres.add(stock.getModelo().getNombre());
		}
		return nombres;
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