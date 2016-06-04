package GoogleMap;

import java.util.Random;

import concesionaria.Consecionaria;
import planta.Planta;

public interface GoogleMap {

	//Modificar
	/**
	 * Obs: La distancia en kilometros que hay 
	 * @ entre la concesionaria y una planta es 0 < x < 500
	 */
	public Float calcularDistancia(Planta unaPlanta, Consecionaria consecionaria);		
}