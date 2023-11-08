package Ejercicio03.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pago {
	private BigDecimal importe;
	private LocalDate fechaPago;

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	@Override
	public String toString() {
		return "Pago [importe=" + importe + ", fechaPago=" + fechaPago + "] \n";
	}
}
