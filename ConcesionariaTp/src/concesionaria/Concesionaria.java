package concesionaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import GoogleMap.GoogleMap;
import cliente.Cliente;
import fabrica.Fabrica;
import modelo.Modelo;
import planDeAhorro.PlanDeAhorro;
import planta.Planta;
import stockDeModelo.StockDeModelo;

public class Concesionaria implements GoogleMap, Observer{
	
	private String direccion;
	private Fabrica fabrica;
	private List<Cliente> clientes;
	private GoogleMap mapa;
	private List<StockDeModelo> stocks;
	private List<PlanDeAhorro> planes;
	
	public Concesionaria(String unaDireccion, Fabrica unaFabrica){
		this.direccion = unaDireccion;
		this.fabrica = unaFabrica;
		this.clientes = new ArrayList<Cliente>();
		this.stocks = new ArrayList<StockDeModelo>();
		this.planes = new ArrayList<PlanDeAhorro>();
	}

	public Float gastoDeFlete(Planta unaPlanta){
    	return mapa.calcularDistancia(unaPlanta,this) * this.gastoPorKilometro();
    }
	
	private Float gastoPorKilometro(){		
		return 20f;
	}

	@Override
	public Float calcularDistancia(Planta unaPlanta, Concesionaria consecionaria){
		return 10f; 
	}
	
	public void agregarCliente(Cliente cliente){
		clientes.add(cliente);
	}
	
	public ArrayList getClientes() {
		return (ArrayList<Cliente>) clientes;
	}
	
	public void agregarPlanDeAhorro(PlanDeAhorro plan){
		planes.add(plan);
	}
	
	public ArrayList getPlanes() {
		return (ArrayList<PlanDeAhorro>) planes;
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
	public void update(Observable o, Object arg){
		modificarStock((StockDeModelo) o);
	}

	public void modificarStock(StockDeModelo stock){
		StockDeModelo stockBuscado = buscarStockDelModelo(stock.getModelo());
		stocks.remove(stockBuscado);
		stocks.add(stock);
	}

	
}
