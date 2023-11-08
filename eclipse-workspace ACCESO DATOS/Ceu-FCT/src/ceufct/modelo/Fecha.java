package ceufct.modelo;

import java.time.LocalDate;

public class Fecha {

	@Override
	public String toString() {
		return "Fecha [fecha=" + fecha + ", año=" + año + ", evaluacion=" + evaluacion + ", disponibilidad="
				+ disponibilidad + "]";
	}

	private LocalDate fecha;
	private int año;
	private int evaluacion;
	private Boolean disponibilidad;

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public int getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(int evaluacion) {
		this.evaluacion = evaluacion;
	}

	public Boolean getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
}
