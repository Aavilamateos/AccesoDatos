package ceufct.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ceufct.dao.FechasDao;
import ceufct.db.OpenConnection;
import ceufct.exception.FechaException;
import ceufct.exception.FechasServices;
import ceufct.modelo.Fecha;

public class FechasService {
	private OpenConnection openConnection;
	private Integer año;
	private Integer evaluacion;

	public FechasService() {
		openConnection = new OpenConnection();
		año = 0;
		evaluacion = 0;
	}

	public List<Fecha> consultarFecha() throws FechasServices, FechaException {
		Connection conn = null;

		try {
			conn = openConnection.getConection();
			List<Fecha> listFechas = new ArrayList<Fecha>();

			año = LocalDate.now().getYear();
			if (LocalDate.now().getMonthValue() >= 9 || LocalDate.now().getMonthValue() <= 12) {
				evaluacion = 1;
			} else if (LocalDate.now().getMonthValue() == 1 || LocalDate.now().getMonthValue() == 3) {
				evaluacion = 2;
			} else if (LocalDate.now().getMonthValue() > 3 || LocalDate.now().getMonthValue() <= 6) {
				evaluacion = 3;
			} else {
				throw new FechaException();
			}
			FechasDao fechaDao = new FechasDao();
			listFechas = fechaDao.consultarFechas(conn, año, evaluacion);

			return listFechas;
		} catch (SQLException e) {
			System.out.println("Ha habido un error en la base de datos" + e.getMessage());
			e.printStackTrace();
			throw new FechasServices("Error al obtener el usuario de la base de datos", e);
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}

		}

	}
}
