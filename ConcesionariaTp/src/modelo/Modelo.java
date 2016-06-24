package modelo;

public class Modelo {

	private String nombre;
	private Integer anhoDeLanzamiento;
	private Integer puertas;
	private String clase;
	private Float precioVenta;

	public Modelo(String unNombre, Integer unAnho, Integer nPuertas, String unaClase, Float unPrecio) {
		this.nombre = unNombre;
		this.anhoDeLanzamiento = unAnho;
		this.puertas = nPuertas;
		this.clase = unaClase;
		this.precioVenta = unPrecio;
	}

	public Float getValorVenta() {
		return this.precioVenta;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setPrecio(Float precioNuevo) {
		this.precioVenta = precioNuevo;
	}
}