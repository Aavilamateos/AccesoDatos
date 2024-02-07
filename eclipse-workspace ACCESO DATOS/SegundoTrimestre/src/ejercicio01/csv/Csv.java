package ejercicio01.csv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ejercicio01.exception.FicheroException;
import ejercicio01.modelo.Pelicula;
import ejercicio01.service.PeliculasServiceException;
import ejercicio01.service.PeliculasServices;


public class Csv {
	
	public List<Pelicula> escribirCsvAsignaturas(String rutaDestino) throws FicheroException {
		PeliculasServices pelisService=new PeliculasServices();
		List<Pelicula> lista = null;
		try {
			lista = pelisService.consultarPeliculas(100);
		} catch (PeliculasServiceException e) {
			e.printStackTrace();
		}
 
		File fichero = new File(rutaDestino);
		FileWriter escribidor = null;
		try {
			escribidor = new FileWriter(fichero, true);
			for (Pelicula peli : lista) {
 
				escribidor.write(peli.getTitulo() + ";");
				escribidor.write(peli.getId() + ";");
				escribidor.write(peli.getLongitud() + "\n");
 
			}
			return lista;
		} catch (IOException e) {
			throw new FicheroException("Error escribiendo csv.", e);
		} finally {
			try {
				escribidor.close();
			} catch (Exception ignore) {
 
			}
		}
	}

}
