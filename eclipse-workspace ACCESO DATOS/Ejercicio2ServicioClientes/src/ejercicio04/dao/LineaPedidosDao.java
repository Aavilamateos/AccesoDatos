package ejercicio04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ejercicio04.modelo.LineaPedido;

public class LineaPedidosDao {
	public void añadirLineaPedido(Connection conn, LineaPedido LPedido) throws SQLException {
		PreparedStatement stmt = null;
		
		try {
			String sql= "INSERT into pedidos_lineas (id_pedido, numero_linea, articulo, precio) values (?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setLong(1, LPedido.getIdPedido());
			stmt.setInt(2, LPedido.getNumeroLinea());
			stmt.setString(3, LPedido.getArticulo());
			stmt.setBigDecimal(4, LPedido.getPrecio());
			stmt.execute();
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
	}

}
