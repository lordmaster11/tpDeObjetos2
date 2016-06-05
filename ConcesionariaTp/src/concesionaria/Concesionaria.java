package concesionaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import GoogleMap.GoogleMap;
import cliente.Cliente;
import fabrica.Fabrica;
import modelo.Modelo;
import planta.Planta;
import stockDeModelo.StockDeModelo;

public class Concesionaria implements GoogleMap, Observer{
	
	private List<Cliente> clientes;
	private Fabrica fabrica;
	private GoogleMap mapa;
	private List<StockDeModelo> stocks;
	
	public Concesionaria(Fabrica unaFabrica) {
		this.clientes = new ArrayList<Cliente>();
		this.stocks = new ArrayList<StockDeModelo>();
	}

	public Float gastoDeFlete(Planta unaPlanta)
    {
    	return mapa.calcularDistancia(unaPlanta,this)* this.gastoPorKilometro();
    }
	private Float gastoPorKilometro() {
		
		return 20f;
	}

	@Override
	public Float calcularDistancia(Planta unaPlanta, Concesionaria consecionaria) {
		return 100f;
	}
	
	public Integer stock(Modelo model){
		return buscarStockDelModelo(model).getCantidad();
	}
	//Hacer el observer
	//Prec: Debe haber al menos un stock en la lista de stocks
	public StockDeModelo buscarStockDelModelo(Modelo model){
		StockDeModelo stockQueBusco = null;
		
		for(StockDeModelo stock : stocks){
			if(stock.nombreDelModelo().equals(model.getNombre())){
				stockQueBusco = stock;
			}
		}
		return stockQueBusco;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		modificarStock((StockDeModelo) o);
	}

	public void modificarStock(StockDeModelo stock) {
		StockDeModelo stockBuscado = buscarStockDelModelo(stock.getModelo());
		stocks.remove(stockBuscado);
		stocks.add(stock);
	}
}
