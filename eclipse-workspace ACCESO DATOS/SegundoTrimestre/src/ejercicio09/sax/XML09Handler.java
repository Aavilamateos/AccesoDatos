package ejercicio09.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ejercicio09.modelo.Pelicula;
import ejercicio09.modelo.Persona;

public class XML09Handler extends DefaultHandler {
	private Boolean openTag;
	private String texto;

	private List<Pelicula> pelis;
	private List<Persona> personas;
	private Pelicula peli;
	private Persona persona;

	public XML09Handler() {
		openTag = false;
		texto = "";
		pelis = new ArrayList<Pelicula>();
		personas = new ArrayList<Persona>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		openTag = true;
		texto = "";
		if (qName.equals("pelicula")) {
			peli = new Pelicula();
			pelis.add(peli);
		} else if (qName.equals("artista")) {
			persona = new Persona();
			String tipo = attributes.getValue("tipo");
			if (tipo.equals(persona.DIRECCION)) {
				peli.setDireccion(persona);
			} else if (tipo.equals(persona.PRODUCCION)) {
				peli.setProduccion(persona);
			} else if (tipo.equals(persona.INTERPRETACION)) {
				peli.getActores().add(persona);
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		openTag = false;
		if (qName.equals("titulo")) {
			peli.setTitulo(texto);
		} else if (qName.equals("duracion")) {
			peli.setDuracion(Integer.parseInt(texto));
		} else if (qName.equals("año")) {
			peli.setAño(Integer.parseInt(texto));
		} else if (qName.equals("nombre")) {
			persona.setNombre(texto);
		} else if (qName.equals("nacionalidad")) {
			persona.setNacionalidad(texto);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		if (openTag) {
			texto += new String(ch, start, length);
		}
	}

	public List<Pelicula> getPelis() {
		return pelis;
	}

}
