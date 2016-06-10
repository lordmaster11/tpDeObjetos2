package comprobanteDePago;

import java.util.Date;

import cliente.Cliente;
import seguroDeVida.SeguroDeVida;

public class ComprobanteDePago {

	private Cliente cliente;
	private Integer numeroDeCuota;
	private Date fechaDePago;
	private Float alicuota;
	private Float gastosAdministrativos;
	private SeguroDeVida seguroDeVida;

	public ComprobanteDePago(Cliente unCliente, Integer nCuotas, Date unaFecha, Float alicuota, Float gastos, SeguroDeVida unSeguro) {
		this.cliente = unCliente;
		this.numeroDeCuota = nCuotas;
		this.fechaDePago = unaFecha;
		this.alicuota = alicuota;
		this.gastosAdministrativos = gastos;
		this.seguroDeVida = unSeguro;
	}

	
}
