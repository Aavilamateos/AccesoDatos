package ceufct.service;

import java.sql.Connection;
import java.sql.SQLException;

import ceufct.dao.UsuariosDao;
import ceufct.db.OpenConnection;
import ceufct.exception.AutenticarException;
import ceufct.exception.UsuariosServiceException;
import ceufct.modelo.Usuario;

public class UsuariosService {
	private OpenConnection openConnection;
	private UsuariosDao usuDao;
	private Usuario usuario;

	public UsuariosService() {
		openConnection = new OpenConnection();
		usuDao = new UsuariosDao();
		usuario = new Usuario();
	}

	public Usuario login(String email, String pass) throws UsuariosServiceException, AutenticarException {
		Connection conn = null;
		try {
			conn = openConnection.getConection();
			usuario = usuDao.consultarUsuario(conn, email);
			if (usuario == null) {
				throw new AutenticarException("El email indicado no existe");
			} else if (!usuario.getPassword().equals(pass)) {
				throw new AutenticarException("La contraseña es incorrecta");
			} else {
				return usuario;
			}
		} catch (SQLException e) {
			System.out.println("Ha habido un error en la base de datos" + e.getMessage());
			e.printStackTrace();
			throw new UsuariosServiceException("Error al obtener el usuario de la base de datos", e);
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}

	public void altaUsuario(Usuario usuario) throws UsuariosServiceException {
		Connection conn = null;
		try {
			conn = openConnection.getConection();

			Usuario usuExistente = new Usuario();
			usuExistente = usuDao.consultarUsuario(conn, usuario.getEmail());
			if (usuExistente == null) {
				usuario.setActivo(false);
				usuDao.insertarUsuario(conn, usuario);
			} else {
				throw new UsuariosServiceException("Ese email está registado");
			}
		} catch (SQLException e) {
			System.out.println("Ha habido un error en la base de datos: " + e.getMessage());
			e.printStackTrace();
			throw new UsuariosServiceException("Error al insertar el usuario en la base de datos", e);
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}
}
