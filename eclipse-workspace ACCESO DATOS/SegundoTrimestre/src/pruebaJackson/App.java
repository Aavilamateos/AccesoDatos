package pruebaJackson;

import apuntesXml.modelo.Alumno;
import apuntesXml.modelo.Curso;
import apuntesXml.xml.CursosXMLException;
import pruebaJackson.jackson.XMLJacksonService;

public class App {

	public static void main(String[] args) {
		Curso c1 = new Curso("DAM", 8);
		Alumno a1 = new Alumno("234234234", "Carlos");
		Alumno a2 = new Alumno("6789789", "Pedro");
		c1.getAlumnos().add(a1);
		c1.getAlumnos().add(a2);
		XMLJacksonService service = new XMLJacksonService();
		try {
			service.escribirXML("C:\\Users\\aavila3794\\OneDrive - Fundación Universitaria San Pablo CEU\\Documentos", c1);
		} catch (CursosXMLException e) {
			e.printStackTrace();
		}
	}
	}
