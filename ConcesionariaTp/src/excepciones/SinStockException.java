package excepciones;

public class SinStockException extends RuntimeException {

	public SinStockException(){
		super("no hay stock");
	}
}
