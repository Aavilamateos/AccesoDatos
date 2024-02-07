package ejercicio05.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ejercicio04.exception.LibrosXMLException;
import ejercicio04.modelo.Edicion;
import ejercicio04.modelo.Libro;

public class Ejercicio05 {

	public List<Libro> leerXml(String rutaFichero) throws LibrosXMLException {
		try {
			List<Libro>libros=new ArrayList<Libro>();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder= factory.newDocumentBuilder();
			Document xml =builder.parse(new File(rutaFichero));
			Element root =xml.getDocumentElement();
			NodeList listaLibro=root.getElementsByTagName("libro");
			for (int i = 0; i < listaLibro.getLength(); i++) {
				Element libroTag =(Element) listaLibro.item(i);
				Libro libro=new Libro();
				String isbn=libroTag.getAttribute("isbn");
				libro.setIsbn(Integer.parseInt(isbn));
				libros.add(libro);
				
				Element tituloTag = (Element) libroTag.getElementsByTagName("titulo").item(0);
				String titulo = tituloTag.getTextContent();
				libro.setTitulo(titulo);
				
				Element autoresTag = (Element) libroTag.getElementsByTagName("autores").item(0);
				NodeList listaAutorTag = autoresTag.getElementsByTagName("autor");
				for (int j = 0; j < listaAutorTag.getLength(); j++) {
					Element autorTag= (Element) listaAutorTag.item(j);
					String autor=autorTag.getTextContent();
					libro.getAutores().add(autor);
				}
				Element edicionesTag = (Element) libroTag.getElementsByTagName("ediciones").item(0);
				NodeList listaEdicionTag=edicionesTag.getElementsByTagName("edicion");
				for (int j = 0; j < listaEdicionTag.getLength(); j++) {
					Element edicionTag = (Element) listaEdicionTag.item(j);
					
					Element añoTag=(Element) edicionTag.getElementsByTagName("año").item(0);
					String año=añoTag.getTextContent();
					
					Element editorialTag=(Element) edicionTag.getElementsByTagName("editorial").item(0);
					String editorial=editorialTag.getTextContent();
					
					Edicion e=new Edicion(Integer.parseInt(año), editorial);
					
					libro.getEdiciones().add(e);
					
				}
				
			}
			return libros;
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new LibrosXMLException("Error leyendo XML");
		}
		
	}
}
