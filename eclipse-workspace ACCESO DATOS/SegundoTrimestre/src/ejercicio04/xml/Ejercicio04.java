package ejercicio04.xml;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ejercicio04.exception.LibrosXMLException;
import ejercicio04.modelo.Edicion;
import ejercicio04.modelo.Libro;

public class Ejercicio04 {
	
	public void crearXmlLibros(List<Libro>libros, String rutaFicheroCompleta) throws LibrosXMLException {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document xml = builder.newDocument();
			Element root = xml.createElement("libros");
			xml.appendChild(root);
			
			
			for (Libro libro : libros) {
				Element libroTag=xml.createElement("libro");
				root.appendChild(libroTag);
				libroTag.setAttribute("isbn", libro.getIsbn().toString());
				
				Element tituloTag=xml.createElement("titulo");
				libroTag.appendChild(tituloTag);
				tituloTag.setTextContent(libro.getTitulo());
				
				Element autoresTag=xml.createElement("autores");
				libroTag.appendChild(autoresTag);
				
				for (String listaAutores : libro.getAutores()) {
					Element autorTag=xml.createElement("autor");
					autoresTag.appendChild(autorTag);
					autorTag.setTextContent(listaAutores);
				}
				
				
				Element edicionesTag=xml.createElement("ediciones");
				libroTag.appendChild(edicionesTag);
				
				for (Edicion edicion : libro.getEdiciones()) {
					Element edicionTag=xml.createElement("edicion");
					edicionesTag.appendChild(edicionTag);
					
					Element añoTag=xml.createElement("año");
					edicionTag.appendChild(añoTag);
					añoTag.setTextContent(edicion.getAño().toString());
					
					Element editorialTag=xml.createElement("editorial");
					edicionTag.appendChild(editorialTag);
					editorialTag.setTextContent(edicion.getEditorial());
				}
				
				
			}
			

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(xml);
			File file = new File(rutaFicheroCompleta);
			StreamResult stream = new StreamResult(file);
			transformer.transform(source, stream);

		} catch (Exception e) {
			throw new LibrosXMLException();
		}
	}
}
