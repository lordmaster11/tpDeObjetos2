package fabrica;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import excepciones.SinStockException;
import modelo.Modelo;
import planta.Planta;

public class Fabrica {
	
	private List<Planta> plantas; 

	public Fabrica() {
		this.plantas = new ArrayList<Planta>();
	}
	
	public void actualizarPrecio(Float precioNuevo, Modelo model){
		plantasConModelo(model).stream()
							   .forEach(planta -> planta.buscarStockDelModelo(model)
				               .getModelo().setPrecio(precioNuevo));
	}
	
	public List<Planta> plantasConModelo(Modelo m){
		return plantas.stream()
				.filter(planta -> planta.nombresDeLosModelos().contains(m.getNombre()))
				.collect(Collectors.toList());
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

	public Integer stock(Modelo unModelo) throws SinStockException{
		Integer total = 0;
		List<Planta> plantas = plantasConModelo(unModelo);
			if(plantas.size()>0){
				for(Planta p : plantas)
					total += p.buscarStockDelModelo(unModelo).getCantidad();
			}else{
				throw new SinStockException();
		}
		return total;
	}
}