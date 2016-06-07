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
		Planta p = plantaConModelo(model);
		p.buscarStockDelModelo(model).getModelo().setPrecio(precioNuevo);
	}
	
	//Busca en su lista de plantas, cual tiene el modelo dado por parametro
	public Planta plantaConModelo(Modelo m){
		Planta planta = null;
	
		for(Planta unaPlanta : plantas){
			if(unaPlanta.nombresDeLosModelos().contains(m.getNombre()))
					planta = unaPlanta;
		}
		return planta;
	}

	public void agregarPlanta(Planta planta) {
		plantas.add(planta);	
	}
	
	public ArrayList<Planta> getPlantas(){
		return (ArrayList<Planta>) this.plantas;
	}
}
