package ceufct.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ceufct.dao.RegistrosDao;
import ceufct.db.OpenConnection;
import ceufct.exception.IncompletoException;
import ceufct.exception.RegistrosServiceException;
import ceufct.modelo.Registro;

public class RegistrosService {

	private OpenConnection openConnection;
	private RegistrosDao regisDao;

	public RegistrosService() {
		openConnection = new OpenConnection();
		regisDao = new RegistrosDao();
	}

	public List<Registro> consultarRegistros(Long idUsuario) throws RegistrosServiceException, IncompletoException {
		Connection conn = null;
		try {
			conn = openConnection.getConection();
			return regisDao.consultarRegistro(conn, idUsuario);

		} catch (SQLException e) {
			System.out.println("Ha habido un error en la base de datos" + e.getMessage());
			e.printStackTrace();
			throw new RegistrosServiceException("Error al obtener el registro de la base de datos", e);
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}

	public void insertarRegistro(Registro regis) throws RegistrosServiceException {
		Connection conn = null;
		try {
			conn = openConnection.getConection();
			Registro registroExistente = new Registro();
			registroExistente = regisDao.consultarRegistroFechaYUsuario(conn, regis.getId_usuario(), regis.getFecha());
			if (registroExistente == null) {
				regisDao.insertarRegistro(conn, regis);
			} else {
				throw new RegistrosServiceException("Error al insertar el registro en la base de datos");
			}

		} catch (SQLException e) {
			System.out.println("Ha habido un error en la base de datos: " + e.getMessage());
			e.printStackTrace();
			throw new RegistrosServiceException("Error al insertar el registro en la base de datos", e);
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}
}
