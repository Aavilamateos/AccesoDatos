package ceu.dam.ad.examen.modelo;

import java.util.Date;

public class Categoria {
	private Long id;
	private String name;
	private Date lastUpdate;
	
	public Categoria() {
	}
	
	

	public Categoria(String name) {
		super();
		this.name = name;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", name=" + name + ", lastUpdate=" + lastUpdate + "]";
	}

	
}
