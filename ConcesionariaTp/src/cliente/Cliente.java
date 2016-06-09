package cliente;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import planDeAhorro.PlanDeAhorro;

public class Cliente {

	private String nombre;
	private String apellido;
	private Integer dni;
	private Date fechaNacimiento;
	private String direccion;
	private String mail;
	private Date fechaIngreso;
	private List<PlanDeAhorro> planes;
	
	public Cliente(String unNombre, String unApellido, Integer unDni, Date unaFechaNac,
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

	public Integer edadCliente() {
		return new Date().getYear() - fechaNacimiento.getYear();
	}
	
	public Integer edad() {     //fecha_nac debe tener el formato dd/MM/yyyy
		   
	    Date fechaActual = new Date();
	    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	    String hoy = formato.format(fechaActual);
	    String nac = formato.format(fechaNacimiento);
	    String[] dat1 = nac.split("/");
	    String[] dat2 = hoy.split("/");
	    
	    Integer anos = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
/*	    Integer mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
	    if (mes < 0) {
	      anos = anos - 1;
	    } else if (mes == 0) {
	      Integer dia = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
	      if (dia > 0) {
	        anos = anos - 1;
	      }
	    }*/
	    return anos;
	  }
}