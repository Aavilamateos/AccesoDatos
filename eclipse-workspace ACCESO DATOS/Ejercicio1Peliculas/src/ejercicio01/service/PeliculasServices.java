package ejercicio01.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ejercicio01.dao.PeliculasDao;
import ejercicio01.modelo.Pelicula;

public class PeliculasServices {
	private OpenConnection openConnection;

	public PeliculasServices() {
		openConnection = new OpenConnection();
	}

	public List<Pelicula> consultarPeliculas(Integer longitud) throws PeliculasServiceException {
		Connection conn = null;
		try {
			conn = openConnection.getConection();
			PeliculasDao dao = new PeliculasDao();
			List<Pelicula> listaMenorDe100 = new ArrayList<Pelicula>();
			listaMenorDe100 = dao.consultarPelis(conn);
			Iterator<Pelicula> it = listaMenorDe100.iterator();
			while (it.hasNext()) {
				if (it.next().getLongitud() > longitud) {
					it.remove();
				}
			}
			return listaMenorDe100;
		} catch (SQLException e) {
			System.out.println("Ha habido un error en la base de datos: " + e.getMessage());
			e.printStackTrace();
			throw new PeliculasServiceException("Error al obtener actores de la bbdd", e);// enlazar el hilo con la otra
																							// excepcion
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}
}
