package GoogleMap;

import java.util.Random;

import planta.Planta;

public class GoogleMap {
	
	public Integer calcularDistancia(Planta unaPlanta)
	{
		Random  rnd = new Random();
		return (rnd.nextInt() * 3000 + 1);
	}		
}