package modelo;

public class Direccion {

	private String domicilio;
	private String ciudad;
	private Integer cp;
	public Direccion(String string, String string2, int i) {
		
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public Integer getCp() {
		return cp;
	}
	public void setCp(Integer cp) {
		this.cp = cp;
	}
	public Direccion(String domicilio, String ciudad, Integer cp) {
		super();
		this.domicilio = domicilio;
		this.ciudad = ciudad;
		this.cp = cp;
	}

}
