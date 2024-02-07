package ejemplo.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ejemplo.modelo.Asignatura;
import ejemplo.service.AsignaturaService;

public class CsvSampleService {

	public void escribirAsignaturas(String rutaDestino) throws FicheroException {
		AsignaturaService service = new AsignaturaService();
		List<Asignatura> lista = service.consultarAsignatura();

		File fichero = new File(rutaDestino);
		FileWriter escribidor = null;
		try {
			escribidor = new FileWriter(fichero, false);
			for (Asignatura asignatura : lista) {
//				escribidor.write(asignatura.getId() + ";");
//				escribidor.write(asignatura.getNombre() + ";");
//				escribidor.write(asignatura.getCiclo() + "\n");
				escribidor.write(asignatura.toCSV() + "\n");

			}
		} catch (IOException e) {
			throw new FicheroException("Error escribiendo csv.", e);
		} finally {
			try {
				escribidor.close();
			} catch (Exception ignore) {

			}
		}
	}

	public List<Asignatura> leerCsvAsignaturas(String rutaOrigen) throws FicheroException {
		File fichero = new File(rutaOrigen);
		Scanner scanner = null;
		try {
			List<Asignatura> asignaturas = new ArrayList<Asignatura>();
			scanner = new Scanner(fichero);
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				Asignatura a = new Asignatura();
				String[] campos = line.split(";");
				a.setId(Integer.parseInt(campos[0]));
				a.setNombre(campos[1]);
				a.setCiclo(campos[2]);
				asignaturas.add(a);
			}
			return asignaturas;
		} catch (FileNotFoundException e) {
			throw new FicheroException("No existe ese fichero.");
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

}
