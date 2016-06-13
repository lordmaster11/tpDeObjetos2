package cliente;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import planDeAhorro.PlanDeAhorro;

public class Cliente {

	private String nombre;
	private String apellido;
	private Integer dni;
	private Calendar fechaNacimiento;
	private String direccion;
	private String mail;
	private Date fechaIngreso;
	private List<PlanDeAhorro> planes;
	
	public Cliente(String unNombre, String unApellido, Integer unDni, Calendar unaFechaNac,
			       String unaDireccion, String unMail) {
		this.nombre = unNombre;
		this.apellido = unApellido;
		this.dni = unDni;
		this.fechaNacimiento = unaFechaNac;
		this.direccion = unaDireccion;
		this.mail = unMail;
		this.fechaIngreso = new Date();
		this.planes = new ArrayList<PlanDeAhorro>();
	}

	public String getNombre(){		
		return this.nombre;
	}
	
    public String getApellido(){		
		return this.apellido;
	}

	public Integer getDNI(){
		return this.dni;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	
	public Integer edadCliente(){
		Calendar fechaNac = fechaNacimiento;
		Integer anioFechaNac = fechaNac.get(Calendar.YEAR);
		
		Calendar fechaActual = Calendar.getInstance();
		Integer anioFechaActual = fechaActual.get(Calendar.YEAR);
				
		Integer edad = anioFechaActual - anioFechaNac;
		Integer mes =fechaActual.get(Calendar.MONTH)- fechaNac.get(Calendar.MONTH);
        Integer dia = fechaActual.get(Calendar.DATE)- fechaNac.get(Calendar.DATE);
        //Se ajusta el año dependiendo el mes y el día
        	if(mes<0 || (mes==0 && dia<0)){
            edad--;
        	}
        //Regresa la edad en base a la fecha de nacimiento
        System.out.println("La edad es " + edad);	
		return edad;	
	}	
}