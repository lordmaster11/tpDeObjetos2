package fabrica;

import java.util.ArrayList;
import java.util.List;

import modelo.Modelo;
import planta.Planta;

public class Fabrica {
	
	private List<Planta> plantas; 

	public Fabrica() {
		this.plantas = new ArrayList<Planta>();
	}
	
	public void actualizarPrecio(Float precioNuevo, Modelo model){
		List<Planta> plantasEncontradas = plantasConModelo(model);
		
		for(Planta p:plantasEncontradas)
			p.buscarStockDelModelo(model).getModelo().setPrecio(precioNuevo);
	}
	 
	public List<Planta> plantasConModelo(Modelo m){
		ArrayList<Planta> plantasEncontradas = new ArrayList<Planta>(); 
	
		for(Planta unaPlanta : plantas){
			if(unaPlanta.nombresDeLosModelos().contains(m.getNombre()))
				plantasEncontradas.add(unaPlanta);
		}
		return plantasEncontradas;
	}

	public void agregarPlanta(Planta planta) {
		plantas.add(planta);	
	}
	
	public List<Planta> getPlantas(){
		return this.plantas;
	}

	public void quitarUnModeloDeStock(Modelo modelo, Planta unaPlanta) {
		 unaPlanta.quitarModelo(modelo);	
	}

	public Integer stock(Modelo unModelo) {
		
		Integer total = 0;
		List<Planta> plantas = plantasConModelo(unModelo);
		
		for(Planta p : plantas)
			total += p.buscarStockDelModelo(unModelo).getCantidad();
		return total;
	}
}