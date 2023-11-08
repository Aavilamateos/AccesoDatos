package ejemplo1servicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import ejemplo1dao.ActoresDao;
import ejemplo1modelo.Actor;

public class ActoresServices {
	
	private OpenConnection openConnection;

	public ActoresServices() {
		openConnection = new OpenConnection();
	}

	public List<Actor> consultarActores() throws ActoresServiceException {
		Connection conn = null;
		
		try {
			conn = openConnection.getConection();
			ActoresDao dao=new ActoresDao();
			
			return dao.consultarActores(conn);
			
		} catch (SQLException e) {
			System.out.println("Ha habido un error en la base de datos: " + e.getMessage());
			e.printStackTrace();
			throw new ActoresServiceException("Error al obtener actores de la bbdd", e);//enlazar el hilo con la otra excepcion
		} 
		finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}
}
