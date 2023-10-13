package ceufct.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ceufct.modelo.Fecha;

public class FechasDao {

	public List<Fecha> consultarFechas(Connection conn, Integer año, Integer evalu) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			List<Fecha> listaFechas = new ArrayList<Fecha>();
			String sql = "SELECT * from fechas where año= " + año + " and evaluacion= " + evalu;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Fecha fecha = new Fecha();
				fecha.setFecha(rs.getDate("fecha").toLocalDate());
				fecha.setAño(rs.getInt("año"));
				fecha.setEvaluacion(rs.getInt("evaluacion"));
				fecha.setDisponibilidad(rs.getBoolean("disponibilidad"));
				listaFechas.add(fecha);
			}
			return listaFechas;
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
	}

}
