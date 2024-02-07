package ejercicio09.sax;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import ejercicio09.exception.PeliculasXMLException;
import ejercicio09.modelo.Pelicula;

public class XML09PeliculasService {

	public List<Pelicula> leerLibros(String filePath) throws PeliculasXMLException {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			XML09Handler handler = new XML09Handler();
			File file = new File(filePath);
			parser.parse(file, handler);
			return handler.getPelis();
		} catch (Exception e) {
			System.err.println("Error leyendo XML: " + e.getMessage());
			throw new PeliculasXMLException(e);
		}
	}

}
