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
    	return calcularDistancia(unaPlanta,this);
    }
	
	private Float gastoPorKilometro(){		
		return 20f;
	}

	@Override
	public Float calcularDistancia(Planta unaPlanta, Concesionaria consecionaria){
		return 10f * gastoPorKilometro();
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
	
	public void adjudicarAuto(PlanDeAhorro unPlan){
		//Cliente unCliente = unPlan.getAdjudicacion().seleccionDeCliente(unPlan);
		//unPlan.quitarCliente(unCliente);
		this.quitarUnModelo(unPlan.getModelo(),stocks);

	}
 
	private void quitarUnModelo(Modelo modelo, List<StockDeModelo> stocks) {
		
	     for(StockDeModelo stock:stocks)
	    {
	 	 if(stock.getModelo().getNombre()==(modelo.getNombre()))
           stock.setCantidad(stock.getCantidad()+1);
	    }
	}

	public StockDeModelo buscarStockDelModelo(Modelo model){
		StockDeModelo stockQueBusco;
		stockQueBusco = null;
		
		for(StockDeModelo stock : stocks){
			if(stock.nombreDelModelo()==(model.getNombre())){
				stockQueBusco = stock;
			}
		}
		return stockQueBusco;
	}
	
	public Integer cantidadDelStock(Modelo modelo){
		
		return (buscarStockDelModelo(modelo)).getCantidad();
	}
	
	//Hacer el observer
	//Prec: Debe haber al menos un stock en la lista de stocks

	
	@Override
	public void update(Observable o, Object arg){
		modificarStock((StockDeModelo) o);
	}

	public void modificarStock(StockDeModelo stock){
		StockDeModelo stockBuscado = buscarStockDelModelo(stock.getModelo());
		stocks.remove(stockBuscado);
		stocks.add(stock);
	}

	public void agregarPlanta(Planta unaPlanta) {

        fabrica.agregarPlanta(unaPlanta);
		
	}

	public List<StockDeModelo> getStocks() {
		// TODO Auto-generated method stub
		return this.stocks;
	}

	
}
