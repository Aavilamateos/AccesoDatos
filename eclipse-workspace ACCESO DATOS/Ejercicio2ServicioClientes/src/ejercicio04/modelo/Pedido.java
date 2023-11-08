package ejercicio04.modelo;

import java.time.LocalDate;
import java.util.List;

public class Pedido {

	private Long idPedido;
	private LocalDate fechaPedido;
	private LocalDate fechaEntrega;
	private String cliente;
	private List<LineaPedido>listaLineas;
	
	
	public List<LineaPedido> getListaLineas() {
		return listaLineas;
	}
	public void setListaLineas(List<LineaPedido> listaLineas) {
		this.listaLineas = listaLineas;
	}
	public LocalDate getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	
	

}
