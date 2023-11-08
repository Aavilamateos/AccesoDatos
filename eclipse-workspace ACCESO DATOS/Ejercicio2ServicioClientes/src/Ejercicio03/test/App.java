package Ejercicio03.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Ejercicio03.modelo.Pago;
import Ejercicio03.service.PagosServices;

public class App {
	public static void main(String[] args) {

		Map<String, List<Pago>> mapaClientes;
		PagosServices pagos = new PagosServices();
		try {
			mapaClientes = new HashMap<String, List<Pago>>();
			mapaClientes = pagos.consultarPagos();
			System.out.println(mapaClientes.get("MARILYN.ROSS@sakilacustomer.org"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
