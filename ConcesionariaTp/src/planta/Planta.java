package planta;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import modelo.Modelo;
import stock.StockDeModelo;

public class Planta implements Observer{
	
	private List<StockDeModelo> stocks;

	public Planta() {
		this.stocks = new ArrayList<StockDeModelo>();
	}

	public List<StockDeModelo> getStocks() {
		return stocks;
	}

	@Override
	public void update(Observable o, Object arg) {
		StockDeModelo stockBuscado = buscarStockDelModelo(((StockDeModelo) o).getModelo());
		stocks.remove(stockBuscado);
		stocks.add((StockDeModelo) o);
	}

	public StockDeModelo buscarStockDelModelo(Modelo model){
		StockDeModelo stockQueBusco = null;
		
		for(StockDeModelo stock : stocks){
			if(stock.nombreDelModelo().equals(model.getNombre())){
				stockQueBusco = stock;
			}
		}
		return stockQueBusco;
	}
	//Hacer stock
	
	public ArrayList<String> nombresDeLosModelos(){
		ArrayList<String> nombres = new ArrayList<String>();
		
		for(StockDeModelo stock : stocks){
			nombres.add(stock.getModelo().getNombre());
		}
		return nombres;
	}
}
