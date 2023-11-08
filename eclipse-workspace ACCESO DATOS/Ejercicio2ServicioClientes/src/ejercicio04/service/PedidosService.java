package ejercicio04.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejercicio04.dao.LineaPedidosDao;
import ejercicio04.dao.PedidosDao;
import ejercicio04.modelo.LineaPedido;
import ejercicio04.modelo.Pedido;

public class PedidosService {

	private OpenConnection openConnection;
	public PedidosService() {
		openConnection = new OpenConnection();
	}
	public void registrarPedido(Pedido pedido) throws PedidosServiceException {
		Connection conn = null;
		try {
			conn=openConnection.getConection();
			conn.setAutoCommit(false);
			PedidosDao pDao=new PedidosDao();
			LineaPedidosDao lPDao=new LineaPedidosDao();
			Long id=pDao.añadirPedido(conn, pedido);
			List<LineaPedido>listaLinea=new ArrayList<LineaPedido>();
			listaLinea=pedido.getListaLineas();
			int numLinea=1;
			for (LineaPedido lineaPedido : listaLinea) {
				lineaPedido.setIdPedido(id);
				lineaPedido.setNumeroLinea(numLinea);
				lPDao.añadirLineaPedido(conn, lineaPedido);
				numLinea++;
			}
			conn.commit();

		} catch (Exception e) {
			System.out.println("Ha habido un error en la base de datos: " + e.getMessage());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new PedidosServiceException("Error al insertar pedidos a la bbdd", e);// enlazar el hilo con la otra
																							// excepcion
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}

}
