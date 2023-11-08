package ejercicio01.test;

import java.util.List;

import ejercicio01.modelo.Pelicula;
import ejercicio01.service.PeliculasServices;

public class App {
	public static void main(String[] args) {
		PeliculasServices pelis = new PeliculasServices();
		List<Pelicula> listaPelis;
		try {
			listaPelis = pelis.consultarPeliculas(100);
			for (Pelicula pelicula : listaPelis) {
				System.out.println(pelicula);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
