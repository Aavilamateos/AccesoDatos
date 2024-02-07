package ejemplo.modelo;

public class Asignatura {

	private Integer id;
	private String nombre;
	private String ciclo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String cif) {
		this.ciclo = cif;
	}

	public String toCSV() {
		return id + ";" + nombre + ";" + ciclo;
	}

	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", nombre=" + nombre + ", ciclo=" + ciclo + "]";
	}

}
