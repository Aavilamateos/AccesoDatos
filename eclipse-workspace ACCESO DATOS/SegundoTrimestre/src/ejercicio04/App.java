package ejercicio04;

import java.util.ArrayList;
import java.util.List;

import ejercicio04.exception.LibrosXMLException;
import ejercicio04.modelo.Libro;
import ejercicio04.xml.Ejercicio04;

public class App {

public static void main(String[] args) {
		
		Ejercicio04 ej4=new Ejercicio04();
		Libro l1=new Libro();
		List<Libro>listaLibros=new ArrayList<Libro>();
		listaLibros=l1.createRandomList(5);
		
		try {
			ej4.crearXmlLibros(listaLibros,"C:\\Users\\aavila3794\\OneDrive - Fundación Universitaria San Pablo CEU\\Escritorio\\Ejercicio04.xml");
		} catch (LibrosXMLException e) {
			e.printStackTrace();
		}
	}

}
