package Ejercicio02.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Ejercicio02.modelo.Cliente;

public class ClientesDao {

	public List<Cliente> consultarClientes(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			List<Cliente> listaClientes = new ArrayList<Cliente>();
			String sql = "SELECT * FROM customer ";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {

				Cliente cliente = new Cliente();

				cliente.setId(rs.getInt("customer_id"));

				cliente.setFirstName(rs.getString("first_name"));

				cliente.setLastName(rs.getString("last_name"));
				
				cliente.setEmail(rs.getString("email"));
				
				cliente.setActivo(rs.getBoolean("active"));

				listaClientes.add(cliente);
			}

			return listaClientes;

		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
	}

}
