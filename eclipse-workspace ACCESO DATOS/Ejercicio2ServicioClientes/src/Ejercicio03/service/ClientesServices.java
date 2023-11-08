package Ejercicio03.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Ejercicio03.dao.ClientesDao;
import Ejercicio03.modelo.Cliente;

public class ClientesServices {

	private OpenConnection openConnection;

	public ClientesServices() {
		openConnection = new OpenConnection();
	}

	public Map<String, Cliente> consultarClientes(String email) throws ClientesServiceException {
		Connection conn = null;
		try {
			conn = openConnection.getConection();
			ClientesDao dao = new ClientesDao();
			Map<String, Cliente> mapaClientes = new HashMap<String, Cliente>();
			List<Cliente> listaCliente = new ArrayList<Cliente>();
			listaCliente = dao.consultarClientes(conn);
			for (Cliente cliente : listaCliente) {
				mapaClientes.put(cliente.getEmail(), cliente);
			}
			return mapaClientes;
		} catch (Exception e) {
			System.out.println("Ha habido un error en la base de datos: " + e.getMessage());
			e.printStackTrace();
			throw new ClientesServiceException("Error al obtener clientes de la bbdd", e);// enlazar el hilo con la otra
																							// excepcion
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}

}
