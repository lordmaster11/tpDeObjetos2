package cliente;

import java.util.ArrayList;
import java.util.Date;

import planDeAhorro.PlanDeAhorro;

public class Cliente {

	private String nombre;
	private String apellido;
	private Integer dni;
	private Date fechaNacimiento;
	private String direccion;
	private String mail;
	private Date fechaIngreso;
	private ArrayList<PlanDeAhorro> planes;
	
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

}
