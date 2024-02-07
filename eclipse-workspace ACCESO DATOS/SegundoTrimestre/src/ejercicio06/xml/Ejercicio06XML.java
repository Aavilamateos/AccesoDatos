package ejercicio06.xml;

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

import ejercicio06.exception.PeliculasXMLException;
import ejercicio06.modelo.Pelicula;
import ejercicio06.modelo.Persona;

public class Ejercicio06XML {
	private Document xml;

	public void crearXmlLibros(List<Pelicula> peliculas, String rutaFicheroCompleta) throws PeliculasXMLException {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			xml = builder.newDocument();
			Element root = xml.createElement("peliculas");
			xml.appendChild(root);
			for (Pelicula pelicula : peliculas) {

				Element peliculaTag = xml.createElement("pelicula");
				root.appendChild(peliculaTag);

				Element tituloTag = xml.createElement("titulo");
				peliculaTag.appendChild(tituloTag);
				tituloTag.setTextContent(pelicula.getTitulo());

				Element duracionTag = xml.createElement("duracion");
				peliculaTag.appendChild(duracionTag);
				duracionTag.setTextContent(pelicula.getDuracion().toString());

				Element añoTag = xml.createElement("año");
				peliculaTag.appendChild(añoTag);
				añoTag.setTextContent(pelicula.getAño().toString());

				Element artistasTag = xml.createElement("artistas");
				peliculaTag.appendChild(artistasTag);

				artistasTag.appendChild(generarTag(pelicula.getDireccion(), Persona.DIRECCION));
				artistasTag.appendChild(generarTag(pelicula.getProduccion(), Persona.PRODUCCION));
				for (Persona persona : pelicula.getActores()) {
					artistasTag.appendChild(generarTag(persona, Persona.INTERPRETACION));
				}

			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(xml);
			File file = new File(rutaFicheroCompleta);
			StreamResult stream = new StreamResult(file);
			transformer.transform(source, stream);

		} catch (Exception e) {
			throw new PeliculasXMLException();
		}
	}

	public Element generarTag(Persona per, String tipo) {

		Element artistaTag = xml.createElement("artista");
		artistaTag.setAttribute("tipo", tipo);

		Element nombreTag = xml.createElement("nombre");
		artistaTag.appendChild(nombreTag);
		nombreTag.setTextContent(per.getNombre());

		Element nacionalidadTag = xml.createElement("nacionalidad");
		artistaTag.appendChild(nacionalidadTag);
		nacionalidadTag.setTextContent(per.getNacionalidad());

		return artistaTag;
	}

}
