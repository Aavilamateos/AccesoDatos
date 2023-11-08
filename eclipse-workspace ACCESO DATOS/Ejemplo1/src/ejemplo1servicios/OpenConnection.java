package ejemplo1servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class OpenConnection {

	public Connection getConection() throws SQLException {

		String urlConexion = "jdbc:mariadb://localhost:3306/sakila";

		String claseDriver = "org.mariadb.jdbc.Driver";

		String usuario = "SakilaDB";

		String password = "sakila";

		try {

			Class.forName(claseDriver);

		} catch (ClassNotFoundException e) {

			System.err.println("No se encuentra el driver JDBC. Revisa tu configuracion");

			throw new RuntimeErrorException(null, e.getMessage());

		}

		Connection conn = DriverManager.getConnection(urlConexion, usuario, password);

		return conn;

	}
}
