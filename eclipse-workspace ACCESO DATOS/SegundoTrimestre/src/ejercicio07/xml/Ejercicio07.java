package ejercicio07.xml;

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

import ejercicio06.exception.PeliculasXMLException;
import ejercicio06.modelo.Pelicula;
import ejercicio06.modelo.Persona;
public class Ejercicio07 {
	public List<Pelicula>leerXml(String rutaFichero) throws PeliculasXMLException{
		try {
			List<Pelicula>listaPelis=new ArrayList<Pelicula>();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder= factory.newDocumentBuilder();
			Document xml =builder.parse(new File(rutaFichero));
			Element root =xml.getDocumentElement();
			NodeList listaPelicula=root.getElementsByTagName("pelicula");
			for (int i = 0; i <listaPelicula.getLength(); i++) {
				Element peliculaTag=(Element) listaPelicula.item(i);
				Pelicula peli=new Pelicula();
				listaPelis.add(peli);
				Element titulotag=(Element) peliculaTag.getElementsByTagName("titulo").item(0);
				String titulo=titulotag.getTextContent();
				peli.setTitulo(titulo);
				
				Element duracionTag=(Element) peliculaTag.getElementsByTagName("duracion").item(0);
				String duracion=duracionTag.getTextContent();
				peli.setDuracion(Integer.parseInt(duracion));
				
				Element añoTag=(Element) peliculaTag.getElementsByTagName("año").item(0);
				String año=añoTag.getTextContent();
				peli.setAño(Integer.parseInt(año));
				
				Element artistasTag=(Element) peliculaTag.getElementsByTagName("artistas").item(0);
				NodeList listaArtistaTag=artistasTag.getElementsByTagName("artista");
				for (int j = 0; j < listaArtistaTag.getLength(); j++) {
					List<Persona>listaActores=new ArrayList<Persona>();
					peli.setActores(listaActores);
					Element artistaTag=(Element) listaArtistaTag.item(j);
					Persona p=new Persona();
					String tipo=artistaTag.getAttribute("tipo");
					Element nombreTag=(Element) artistaTag.getElementsByTagName("nombre").item(0);
					String nombre=nombreTag.getTextContent();
					p.setNombre(nombre);
					
					Element nacionalidadTag=(Element) artistaTag.getElementsByTagName("nacionalidad").item(0);
					String nacionalidad=nacionalidadTag.getTextContent();
					p.setNacionalidad(nacionalidad);
					
					if (tipo.equals(Persona.DIRECCION)) {
						peli.setDireccion(p);
					}else if (tipo.equals(Persona.PRODUCCION)) {
						peli.setProduccion(p);
					}else {
						listaActores.add(p);
					}
				}
			}
			return listaPelis;
		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new PeliculasXMLException("Error leyendo XML");
		}
		
	}


}
