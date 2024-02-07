package ejemplo;

import java.util.List;

import ejemplo.csv.CsvSampleService;
import ejemplo.csv.FicheroException;
import ejemplo.modelo.Asignatura;

public class App {

	public static void main(String[] args) {
		CsvSampleService serviceCsv = new CsvSampleService();
//		try {
//			serviceCsv.escribirAsignaturas("C:\\Users\\ptorres8870\\Desktop/alumnos.csv");
//		} catch (FicheroException e) {
//
//			e.printStackTrace();
//		}
		try {
			List<Asignatura> resultado = serviceCsv.leerCsvAsignaturas("C:\\Users\\ptorres8870\\Desktop/alumnos.csv");
			for (Asignatura asignatura : resultado) {
				System.out.println(asignatura);
			}
		} catch (FicheroException e) {
			e.printStackTrace();
		}
	}

}
