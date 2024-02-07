package ejercicio07;

import java.util.List;

import ejercicio06.exception.PeliculasXMLException;
import ejercicio06.modelo.Pelicula;
import ejercicio07.xml.Ejercicio07;


public class App {

	public static void main(String[] args) {
		
		Ejercicio07 service = new Ejercicio07();
		try {
			List<Pelicula> lista = service.leerXml("C:\\\\Users\\\\aavila3794\\\\OneDrive - Fundación Universitaria San Pablo CEU\\\\Escritorio\\\\Ejercicio06.xml");
			System.out.println(lista);
		} catch (PeliculasXMLException e) {
 
			e.printStackTrace();
		}
	
}

}
