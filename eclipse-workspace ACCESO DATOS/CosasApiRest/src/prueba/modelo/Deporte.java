package prueba.modelo;

public class Deporte {

	private String nombre;
	private int id;
	private Integer jugadores;
	private Boolean equipo;
	private String torneo;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getJugadores() {
		return jugadores;
	}
	public void setJugadores(Integer jugadores) {
		this.jugadores = jugadores;
	}
	public Boolean getEquipo() {
		return equipo;
	}
	public void setEquipo(Boolean equipo) {
		this.equipo = equipo;
	}
	public String getTorneo() {
		return torneo;
	}
	public void setTorneo(String torneo) {
		this.torneo = torneo;
	}
	@Override
	public String toString() {
		return "Deporte [nombre=" + nombre + ", jugadores=" + jugadores + ", equipo=" + equipo + ", torneo=" + torneo
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
