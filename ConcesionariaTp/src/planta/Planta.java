package planta;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import modelo.Modelo;
import stockDeModelo.StockDeModelo;

public class Planta implements Observer{
	
	private List<StockDeModelo> stocks;
	private String direccion;

	public Planta(String unaDireccion) {
		this.direccion = unaDireccion;
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
			if(stock.getModelo().equals(model.getNombre())){
				stockQueBusco = stock;
			}
		}
		return stockQueBusco;
	}

	public Integer stockDeModelo(Modelo model){
        Integer resp;
        resp = 0;
		
		for(StockDeModelo stock : stocks){
			if(stock.nombreDelModelo().equals(model.getNombre())){
				resp = resp + stock.getCantidad() ;
			}
		}
		return resp;
	}
	
	
	public ArrayList<String> nombresDeLosModelos(){
		ArrayList<String> nombres = new ArrayList<String>();
		
		for(StockDeModelo stock : stocks){
			nombres.add(stock.getModelo().getNombre());
		}
		return nombres;
	}

	public void agregarStock(StockDeModelo unStock) {
		 if(this.existeStockDeModelo(unStock)){
			this.agregarNModelos(unStock.getCantidad(),this.buscarStockDelModelo(unStock.getModelo()));
		 }else{
		     stocks.add(unStock);
		  }
	}

	private boolean existeStockDeModelo(StockDeModelo unStock){
          boolean resp;
          resp = false;
		  

  		for(StockDeModelo stock:stocks)
  		{
  			if(unStock.getModelo() == stock.getModelo()){
  		        resp = true;
  		    }		
  	}
		return resp;
	}

	private void agregarNModelos(Integer cantidad,
			StockDeModelo unStock) {
		
		for(StockDeModelo stock:stocks){
			if((unStock.getModelo().getNombre()).equals(stock.getModelo().getNombre())){
		        stock.setCantidad(stock.getCantidad()+cantidad);
		    }		
		}
	}

	public void setStock(List<StockDeModelo> unStocksDeModelos) {

         this.stocks=unStocksDeModelos;
		
	}
}
