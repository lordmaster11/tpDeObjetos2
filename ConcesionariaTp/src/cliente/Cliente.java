package cliente;

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
			       String unaDireccion, String unMail, Date unaFechaIngreso) {
		this.nombre = unNombre;
		this.apellido = unApellido;
		this.dni = unDni;
		this.fechaNacimiento = unaFechaNac;
		this.direccion = unaDireccion;
		this.mail = unMail;
		this.fechaIngreso = unaFechaIngreso;
		this.planes = new ArrayList<PlanDeAhorro>();
	}


	public String getNombre() {
		
		return this.nombre;
	}
      public String getApellido() {
		
		return this.apellido;
	}

	public Integer getDNI() {

		return this.dni;
	}

	public Date getfechaDeNacimiento() {
		
		return this.fechaNacimiento;
	}

	public String getMail() {

		return this.mail;
	}

	public String getDireccion() {

		return this.direccion;
	}

	public Date getFechaDeIngreso() {


		return this.fechaIngreso;
	}

}
	
	
}
