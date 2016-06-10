package adjudicacion;

import cliente.Cliente;
import planDeAhorro.PlanDeAhorro;

public class PorMayorCobertura implements Adjudicacion{

	@Override
	public Cliente seleccionDeCliente(PlanDeAhorro plan) {
		Cliente res;
		res = plan.getSubscriptos().get(0);
       	
		for(Cliente unCliente:(plan.getSubscriptos()))
		 {
			// if(unCliente.getFechaIngreso()>res.getFechaIngreso()){
		      // res = unCliente;
			 //else(unCliente.getFechaIngreso()>res.getFechaIngreso())		 
			 if(unCliente.edadCliente2()>res.edadCliente2());
		       res = unCliente;
		 }

		
		return res;
	}
	//ESTO SE TIENE QUE HACER CON EXPRESIONES LAMDA.. PROXIMAMENTE
	//el if debe conmemplar mayor proporcion de pago y antiguedad
	
	
	
/** 
 * agarrar todos los clientes que hayan pagado la mayor cantidad de cuotas 
 * recorrer toda la lista recibo de cuotas desde planDe ahorro, y devolver el numero mayor de 
 * cuotas pagadas, una vez que tenes ese numero recorrer de vuelta la lista y guard en una nueva lista 
 * todos los clientes q tengan esa cantidad de cuotas pagas
 */
}
