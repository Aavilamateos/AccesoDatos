package ejercicio08;

import java.util.ArrayList;
import java.util.List;

import ejercicio08.exception.LibrosXMLException;
import ejercicio08.jackson.XMLJacksonLibros;
import ejercicio08.modelo.Libro;
import ejercicio08.sax.XMLLibrosService;
import pruebaJackson.jackson.XMLJacksonService;

public class App {

	public static void main(String[] args) {
		// testCrearXMLCurso();
		
		// testLeerXMLCurso();
		
		//testLeerXMLLibrosSax();
		
		//testEscribirXMLLibros();
		
		leerXMLLibros();
	}
	public static void testEscribirXMLLibros() {
		XMLJacksonLibros service=new XMLJacksonLibros();
		Libro l1 =new Libro();
		List<Libro>listaLibros=new ArrayList<Libro>();
		listaLibros=l1.createRandomList(5);
		try {
			service.escribirLibros("C:\\Users\\aavila3794\\Downloads\\librosJackson.xml", listaLibros);
		} catch (LibrosXMLException e) {
			e.printStackTrace();
		}
	}
	public static void testLeerXMLLibrosSax() {
		XMLLibrosService service = new XMLLibrosService();
		try {
			List<Libro> libros = service.leerLibros("C:\\Users\\aavila3794\\Downloads\\xmlLibros.xml");
			for (Libro libro : libros) {
				System.out.println(libro);
			}

		} catch (LibrosXMLException e) {
			e.printStackTrace();
		}
	}
	public static void leerXMLLibros() {
		XMLLibrosService service = new XMLLibrosService();
		try {
			List<Libro>listaLibros=service.leerLibros("C:\\Users\\aavila3794\\Downloads\\xmlLibros.xml");
			for (Libro libro : listaLibros) {
				System.out.println(libro);
			}
		} catch (LibrosXMLException e) {
			e.printStackTrace();
		}
	}

}
