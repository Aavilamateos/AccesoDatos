package ejercicio09;

import java.util.List;

import ejercicio09.exception.PeliculasXMLException;
import ejercicio09.modelo.Pelicula;
import ejercicio09.sax.XML09PeliculasService;

public class App {

	public static void main(String[] args) {
		// testCrearXMLCurso();

		// testLeerXMLCurso();

		testLeerXMLPelissSax();

	}

	private static void testLeerXMLPelissSax() {
		XML09PeliculasService service = new XML09PeliculasService();
		try {
			List<Pelicula> pelis = service.leerLibros("C:\\Users\\aavila3794\\Downloads\\xmlPeliculas.xml");
			for (Pelicula peli : pelis) {
				System.out.println(peli);
			}

		} catch (PeliculasXMLException e) {
			e.printStackTrace();
		}

	}

}
