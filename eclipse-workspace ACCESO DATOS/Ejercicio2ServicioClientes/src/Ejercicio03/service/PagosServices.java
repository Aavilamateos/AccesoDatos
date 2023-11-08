package Ejercicio03.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Ejercicio03.dao.ClientesDao;
import Ejercicio03.dao.PagosDao;
import Ejercicio03.modelo.Cliente;
import Ejercicio03.modelo.Pago;

public class PagosServices {
	private OpenConnection openConnection;

	public PagosServices() {
		openConnection = new OpenConnection();
	}

	public Map<String, List<Pago>> consultarPagos() throws PagosServiceException {
		Connection conn = null;
		try {
			conn = openConnection.getConection();
			PagosDao dao = new PagosDao();
			ClientesDao clientesDao = new ClientesDao();
			List<Cliente> listaClientes = clientesDao.consultarClientes(conn);
			List<Pago> listaPagos = new ArrayList<Pago>();
			Map<String, List<Pago>> mapaPagos = new HashMap<String, List<Pago>>();
			for (Cliente clientes : listaClientes) {
				listaPagos = dao.consultarPagos(conn, clientes.getId());
				mapaPagos.put(clientes.getEmail(), listaPagos);
			}

			return mapaPagos;

		} catch (Exception e) {
			System.out.println("Ha habido un error en la base de datos: " + e.getMessage());
			e.printStackTrace();
			throw new PagosServiceException("Error al obtener actores de la bbdd", e);// enlazar el hilo con la otra
																						// excepcion
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}

	}

}
