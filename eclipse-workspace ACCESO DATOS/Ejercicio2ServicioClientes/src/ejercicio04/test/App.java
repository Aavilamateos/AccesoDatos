package ejercicio04.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ejercicio04.modelo.LineaPedido;
import ejercicio04.modelo.Pedido;
import ejercicio04.service.PedidosService;

public class App {
	public static void main(String[] args) {
		Pedido p1=new Pedido();
		LineaPedido articulo1=new LineaPedido();
		LineaPedido articulo2=new LineaPedido();
		List<LineaPedido>listaArticulos=new ArrayList<LineaPedido>();
		//articulo1.setIdPedido(1L);
		articulo1.setArticulo("Gafas de sol");
		articulo1.setNumeroLinea(1);
		articulo1.setPrecio(new BigDecimal(50.0));
		//articulo2.setIdPedido(1L);
		articulo2.setArticulo("Condone");
		articulo2.setNumeroLinea(2);
		articulo2.setPrecio(new BigDecimal(5.80));
		listaArticulos.add(articulo1);
		listaArticulos.add(articulo2);
		LocalDate fechaEntrega=LocalDate.of(2023, 10, 23);
		LocalDate fechaPedido=LocalDate.of(2023, 10, 20);
		//p1.setIdPedido(1L);
		p1.setCliente("Fabio erxiulo");
		p1.setListaLineas(listaArticulos);
		p1.setFechaEntrega(fechaEntrega);
		p1.setFechaPedido(fechaPedido);
		
		try {
			PedidosService pService=new PedidosService();
			pService.registrarPedido(p1);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
