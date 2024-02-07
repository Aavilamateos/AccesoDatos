package ejercicio08.jackson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ejercicio08.exception.LibrosXMLException;
import ejercicio08.modelo.Libro;
import ejercicio08.modelo.Libros;

public class XMLJacksonLibros {

	public void escribirLibros(String pathName, List<Libro> libros) throws LibrosXMLException {
		XmlMapper mapper = new XmlMapper();
		File file = new File(pathName);
		try {
			Libros listaLibros = new Libros();
			listaLibros.setLibros(libros);
			mapper.writeValue(file, listaLibros);
		} catch (StreamWriteException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error al escribir el xml de curso" + e.getMessage());
			throw new LibrosXMLException("Error escribiendo xml", e);
		}
	}

	public List<Libro> leerLibros(String pathName) throws LibrosXMLException {
		XmlMapper mapper = new XmlMapper();
		File file = new File(pathName);

		Libros libros;
		try {
			libros = mapper.readValue(file, Libros.class);
			return libros.getLibros();
		} catch (IOException e) {
			throw new LibrosXMLException();
		}
		

	}

}
