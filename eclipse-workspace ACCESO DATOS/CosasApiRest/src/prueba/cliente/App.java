package prueba.cliente;

import prueba.modelo.Deporte;

public class App {

	public static void main(String[] args) {
		DeporteClient client=new DeporteClient("http://localhost:8080", 2000);
		Deporte deporte=client.consultarDeporte(63);
		System.out.println(deporte);
		Deporte deporte2 = client.crearDeporte(deporte);
		System.out.println("Deporte creado: " + deporte2);
	}

}
