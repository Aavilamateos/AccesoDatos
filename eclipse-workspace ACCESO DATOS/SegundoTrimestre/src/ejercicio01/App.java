package ejercicio01;

import java.util.List;

import ejercicio01.csv.Csv;
import ejercicio01.exception.FicheroException;
import ejercicio01.modelo.Pelicula;


public class App {
	public static void main(String[] args) {
	Csv serviceCsv = new Csv();
	 
	List<Pelicula> resultado = null;
	try {
		resultado = serviceCsv.escribirCsvAsignaturas("C:\\Users\\arodriguez1063\\Desktop/peliculas.csv");
	} catch (FicheroException e) {
		e.printStackTrace();
	}
	for (Pelicula asignatura : resultado) {
		System.out.println(asignatura);
	}
}
}
