package Ejercicio02.test;

import java.util.HashMap;
import java.util.Map;

import Ejercicio02.modelo.Cliente;
import Ejercicio02.service.ClientesServices;


public class App {
public static void main(String[] args) {

	ClientesServices clientes = new ClientesServices();
	Map<String,Cliente> mapaClientes;
	try {
		mapaClientes=new HashMap<String, Cliente>();
		mapaClientes=clientes.consultarClientes();
		System.out.println(mapaClientes.get("MARILYN.ROSS@sakilacustomer.org"));
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
