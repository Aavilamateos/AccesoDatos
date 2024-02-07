package ejercicio05;

import java.util.List;

import ejercicio04.exception.LibrosXMLException;
import ejercicio04.modelo.Libro;
import ejercicio05.xml.Ejercicio05;

public class App {

public static void main(String[] args) {
	
		Ejercicio05 service = new Ejercicio05();
		try {
			List<Libro> lista = service.leerXml("C:\\\\Users\\\\aavila3794\\\\OneDrive - Fundación Universitaria San Pablo CEU\\\\Escritorio\\\\Ejercicio04.xml");
			System.out.println(lista);
		} catch (LibrosXMLException e) {
 
			e.printStackTrace();
		}
	
}
}
