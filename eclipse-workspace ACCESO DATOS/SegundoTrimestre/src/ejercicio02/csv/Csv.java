package ejercicio02.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ceu.dam.ad.ejerciciosTema2.ejercicio5.solucion.modelo.City;
import ceu.dam.ad.ejerciciosTema2.ejercicio5.solucion.services.CityServiceImpl;
import ceu.dam.ad.ejerciciosTema2.ejercicio5.solucion.services.ServerErrorException;

public class Csv {

	public void importarCiudades(String nombreFichero) {
		try {
			File file = new File(nombreFichero);
			Scanner scanner = new Scanner(file);
			CityServiceImpl service = new CityServiceImpl();
			while (scanner.hasNext()) {
				String linea = scanner.nextLine();
				City city = new City();
				String[] lineaATrozos = linea.split("\t");
				city.setDescripcion(lineaATrozos[0]);
				city.setCountryId(Long.parseLong(lineaATrozos[1]));
				service.createCity(city);
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ServerErrorException e) {
			e.printStackTrace();
		}
	}

}
