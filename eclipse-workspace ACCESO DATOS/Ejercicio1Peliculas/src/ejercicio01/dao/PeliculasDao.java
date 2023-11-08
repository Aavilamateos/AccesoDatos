package ejercicio01.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ejercicio01.modelo.Pelicula;

public class PeliculasDao {
	public List<Pelicula> consultarPelis(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			List<Pelicula> listaPelis = new ArrayList<Pelicula>();
			String sql = "SELECT * FROM FILM ";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {

				Pelicula peli = new Pelicula();

				peli.setId(rs.getInt("film_id"));

				peli.setTitulo(rs.getString("title"));

				peli.setLongitud(rs.getInt("length"));

				listaPelis.add(peli);
			}

			return listaPelis;

		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
	}
}
