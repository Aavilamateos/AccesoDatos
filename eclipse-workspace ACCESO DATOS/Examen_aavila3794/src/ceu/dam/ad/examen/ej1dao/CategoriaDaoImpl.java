package ceu.dam.ad.examen.ej1dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ceu.dam.ad.examen.modelo.Categoria;

public class CategoriaDaoImpl implements CategoriaDao {

	@Override
	public Long insertarCategoria(Connection conn, String nombreCategoria) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO category (name) VALUES (?) ";
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, nombreCategoria);
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			rs.next();
			//Date fecha=rs.getDate();
			Long id = rs.getLong(1);
			return id;
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	@Override
	public Categoria consultarCategoria(Connection conn, Long id) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			String sql = "SELECT * from category where category_id= ?";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			Categoria categoria = new Categoria();

			if (rs.next()) {
				categoria.setId(rs.getLong("category_id"));
				categoria.setName(rs.getString("name"));
				categoria.setLastUpdate(rs.getDate("last_update"));
				return categoria;
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
}
