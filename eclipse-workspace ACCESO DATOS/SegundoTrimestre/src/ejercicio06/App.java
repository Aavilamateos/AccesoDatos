package ejercicio06;

import java.util.ArrayList;
import java.util.List;

import ejercicio06.exception.PeliculasXMLException;
import ejercicio06.modelo.Pelicula;
import ejercicio06.xml.Ejercicio06XML;

public class App {

	public static void main(String[] args) {
		Ejercicio06XML ej6=new Ejercicio06XML();
		List<Pelicula>listaPelis=new ArrayList<Pelicula>();
		listaPelis=Pelicula.createRandomList(5);
		try {
			ej6.crearXmlLibros(listaPelis, "C:\\Users\\aavila3794\\OneDrive - Fundación Universitaria San Pablo CEU\\Escritorio\\Ejercicio06.xml");
		} catch (PeliculasXMLException e) {
			e.printStackTrace();
		}
	}
}
