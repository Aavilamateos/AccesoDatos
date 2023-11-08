package ceufct.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ceufct.modelo.Usuario;

public class UsuariosDao {

	public Usuario consultarUsuario(Connection conn, String email) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * from usuarios where email='" + email + "'";
			Usuario u = new Usuario();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				u.setId_usuario(rs.getLong("id_usuario"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setNombre(rs.getString("nombre"));
				u.setApellidos(rs.getString("apellidos"));
				u.setCiclo(rs.getString("ciclo"));
				u.setActivo(rs.getBoolean(1));
				return u;
			} else {
				return null;
			}

		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
	}

	public void insertarUsuario(Connection conn, Usuario usuario) throws SQLException {

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "INSERT into usuarios (email, password, nombre, apellidos, ciclo, activo) values (?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getPassword());
			stmt.setString(3, usuario.getNombre());
			stmt.setString(4, usuario.getApellidos());
			stmt.setString(5, usuario.getCiclo());
			stmt.setBoolean(6, usuario.getActivo());
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			rs.next();
			Long idUsuario = rs.getLong(1);
			usuario.setId_usuario(idUsuario);
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}

	}

}
