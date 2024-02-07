package ejercicio08.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ejercicio08.modelo.Edicion;
import ejercicio08.modelo.Libro;

public class XML08Handler extends DefaultHandler {

	private Boolean openTag;
	private String texto;

	private List<Libro> libros;
	private List<Edicion> ediciones;
	private Libro libro;
	private Edicion edicion;
	private String año;
	private String editorial;

	public XML08Handler() {
		openTag = false;
		texto = "";
		libros = new ArrayList<Libro>();
		ediciones = new ArrayList<Edicion>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		openTag = true;
		texto = "";

		if (qName.equals("libro")) {
			libro = new Libro();
			libros.add(libro);
			String isbn = attributes.getValue("isbn");
			libro.setIsbn(Integer.parseInt(isbn));
		} else if (qName.equals("edicion")) {
			edicion = new Edicion();
			ediciones.add(edicion);
			libro.setEdiciones(ediciones);
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		openTag = false;
		if (qName.equals("libro")) {
			libro.setTitulo(texto);

		} else if (qName.equals("autor")) {
			libro.getAutores().add(texto);
		}

		else if (qName.equals("año")) {
			año = texto;
			edicion.setAño(Integer.parseInt(año));
		} else if (qName.equals("editorial")) {
			editorial = texto;
			edicion.setEditorial(editorial);

		}

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		if (openTag) {
			texto += new String(ch, start, length);
		}
	}

	public List<Libro> getLibros() {
		return libros;
	}

}
