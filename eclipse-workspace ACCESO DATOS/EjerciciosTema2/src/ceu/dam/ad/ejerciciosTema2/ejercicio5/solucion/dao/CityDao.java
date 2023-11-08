package ceu.dam.ad.ejerciciosTema2.ejercicio5.solucion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import ceu.dam.ad.ejerciciosTema2.ejercicio5.solucion.modelo.City;


public class CityDao {

	public CityDao() {
	}

	public List<City> buscarCiudades(Connection conn, String filtroDescripcion) throws SQLException {
		ResultSet rs = null;
		Statement stmt = null;
		try {
			List<City> resultados = new ArrayList<>();
			String sql = "SELECT * FROM city WHERE city LIKE '%" + filtroDescripcion + "%'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while ( rs.next()) {
				City ciudad = new City();
				ciudad.setId(rs.getLong("city_id"));
				ciudad.setDescripcion(rs.getString("city"));
				ciudad.setCountryId(rs.getLong("country_id"));
				resultados.add(ciudad);
			}
			return resultados;
		}
		finally {
			if (rs!=null) {
				rs.close();
			}
			if (stmt!=null) {
				stmt.close();
			}
		}
	}

	public City consultarCiudad(Connection conn, Long id) throws SQLException {
		ResultSet rs = null;
		Statement stmt = null;
		try {
			String sql = "SELECT * FROM city WHERE city_id = " + id;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if ( rs.next()) {
				City ciudad = new City();
				ciudad.setId(rs.getLong("city_id"));
				ciudad.setDescripcion(rs.getString("city"));
				ciudad.setCountryId(rs.getLong("country_id"));
				return ciudad;
			}
			return null;
		}
		finally {
			if (rs!=null) {
				rs.close();
			}
			if (stmt!=null) {
				stmt.close();
			}
		}
	}

	public void insertarCiudad(Connection conn, City city) throws SQLException {
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO city (CITY, COUNTRY_ID) VALUES (?, ?) ";
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // La constante es para que luego podamos pedir la key generada
			stmt.setString(1, city.getDescripcion());
			stmt.setLong(2, city.getCountryId());
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			rs.next();
			Long id = rs.getLong(1);
			city.setId(id);
		}
		finally {
			if (rs!=null) {
				rs.close();
			}
			if (stmt!=null) {
				stmt.close();
			}
		}
	}

	public Integer updateCiudad(Connection conn, City city) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = "UPDATE city SET CITY = ?, COUNTRY_ID = ? WHERE CITY_ID = ? ";
			stmt = conn.prepareStatement(sql); 
			stmt.setString(1, city.getDescripcion());
			if (city.getCountryId() != null) {
				stmt.setLong(2, city.getCountryId());
			}
			else {
				stmt.setNull(2, Types.SMALLINT);
			}
			stmt.setLong(3, city.getId());
			return stmt.executeUpdate();
		}
		finally {
			if (stmt!=null) {
				stmt.close();
			}
		}
		
	}

	public Integer updateSelectivoCiudad(Connection conn, City city) throws SQLException {
		Statement stmt = null;
		try {
			String sql = "UPDATE city SET ";
			Boolean primerParametro = true;
			if (city.getDescripcion()!=null) {
				sql += " CITY =  '" + city.getDescripcion() + "'" ;
				primerParametro = false;
			}
			
			if (city.getCountryId()!=null) {
				if (!primerParametro) {
					sql += ", ";
				}
				sql += " COUNTRY_ID = " + city.getCountryId();
			}
			sql += " WHERE CITY_ID = " + city.getId();
			stmt = conn.createStatement(); 
			return stmt.executeUpdate(sql);
		}
		finally {
			if (stmt!=null) {
				stmt.close();
			}
		}
		
	}

	public Integer deleteCiudad(Connection conn, Long id) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = "DELETE FROM city WHERE CITY_ID = ? ";
			stmt = conn.prepareStatement(sql); 
			stmt.setLong(1, id);
			return stmt.executeUpdate();
		}
		finally {
			if (stmt!=null) {
				stmt.close();
			}
		}
		
	}
	
	

}
