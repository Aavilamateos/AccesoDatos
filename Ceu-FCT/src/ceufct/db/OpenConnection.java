package ceufct.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class OpenConnection {
	public Connection getConection() throws SQLException {

		String urlConexion = "jdbc:mariadb://localhost:3306/ceu-fct";

		String claseDriver = "org.mariadb.jdbc.Driver";

		String usuario = "ceu-fct";

		String password = "ceu-fct";

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
