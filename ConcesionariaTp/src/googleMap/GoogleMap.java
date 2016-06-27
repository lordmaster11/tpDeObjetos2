package googleMap;

import java.util.Random;

import planta.Planta;

public class GoogleMap {
	
	private Random random;
	
	public GoogleMap(Random ran){
		this.random = ran;	
	}
	
	public Integer calcularDistancia(Planta unaPlanta) {
		return (random.nextInt() * 3000 + 1);
	}		
}