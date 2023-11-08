package Ejercicio03.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Ejercicio03.modelo.Pago;

public class PagosDao {

	public List<Pago> consultarPagos(Connection conn, Integer id) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			List<Pago> listaPagos = new ArrayList<Pago>();
			String sql = "SELECT AMOUNT, PAYMENT_DATE FROM PAYMENT where customer_id=" + id;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Pago pago = new Pago();
				pago.setImporte(rs.getBigDecimal("amount"));

				pago.setFechaPago(rs.getDate("payment_date").toLocalDate());

				listaPagos.add(pago);
			}

			return listaPagos;
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
	}

}
