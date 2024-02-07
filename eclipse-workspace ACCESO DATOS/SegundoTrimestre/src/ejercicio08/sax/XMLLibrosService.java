package ejercicio08.sax;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import ejercicio08.exception.LibrosXMLException;
import ejercicio08.modelo.Libro;

public class XMLLibrosService {

	public List<Libro> leerLibros(String filePath) throws LibrosXMLException {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			XML08Handler handler = new XML08Handler();
			File file = new File(filePath);
			parser.parse(file, handler);
			return handler.getLibros();
		} catch (Exception e) {
			System.err.println("Error leyendo XML: " + e.getMessage());
			throw new LibrosXMLException(e);
		}
	}
}
