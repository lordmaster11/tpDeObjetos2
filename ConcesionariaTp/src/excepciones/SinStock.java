package excepciones;

public class SinStock extends RuntimeException {

	public SinStock(){
		super("no hay stock");
	}
}
