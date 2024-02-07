package apuntesXml.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import apuntesXml.modelo.Alumno;
import apuntesXml.modelo.Curso;

public class XmlSampleService {

	public List<Curso> leerXMLCursos(String rutaFichero) throws CursosXMLException{
		try {
			List<Curso> cursos = new ArrayList<Curso>();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document xml = builder.parse(new File(rutaFichero));
			
			Element root = xml.getDocumentElement(); // Root
			
			NodeList listaCursosTag = root.getElementsByTagName("curso");
			for (int i = 0; i < listaCursosTag.getLength(); i++) {
				Element cursoTag = (Element) listaCursosTag.item(i);
				Curso curso = new Curso();
				cursos.add(curso);
				
				Element nombreTag = (Element) cursoTag.getElementsByTagName("nombre").item(0);
				String nombre = nombreTag.getTextContent();
				curso.setNombre(nombre);
				
				Element horasTag = (Element) cursoTag.getElementsByTagName("horas").item(0);
				String horas = horasTag.getTextContent();
				curso.setHora(Integer.parseInt(horas));
				
				Element alumnosTag = (Element) cursoTag.getElementsByTagName("alumnos").item(0);
				NodeList listaAlumnoTag = alumnosTag.getElementsByTagName("alumno");
				for (int j = 0; j < listaAlumnoTag.getLength(); j++) {
					Alumno a = new Alumno();
					curso.getAlumnos().add(a);
					Element alumnoTag = (Element) listaAlumnoTag.item(j);
					String nombreAlumno = alumnoTag.getTextContent();
					a.setNombre(nombreAlumno);
					String dni = alumnoTag.getAttribute("dni");
					a.setDni(dni);
				}
				
			}
			return cursos;
			
		}
		catch(Exception e) {
			throw new CursosXMLException("Error leyendo XML" , e);
		}
		
		
		
	}
	
	
	public void crearXMLCursos(List<Curso> cursos, String rutaFicheroCompleta) throws CursosXMLException {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document xml = builder.newDocument();
			
			Element root = xml.createElement("cursos");
			xml.appendChild(root);
			
			for (Curso curso : cursos) {
				Element cursoTag = xml.createElement("curso");
				root.appendChild(cursoTag);
				
				Element nombreTag = xml.createElement("nombre");
				cursoTag.appendChild(nombreTag);
				nombreTag.setTextContent(curso.getNombre());
				
				Element horasTag = xml.createElement("horas");
				cursoTag.appendChild(horasTag);
				horasTag.setTextContent(curso.getHora().toString());
				
				Element alumnosTag = xml.createElement("alumnos");
				cursoTag.appendChild(alumnosTag);
				
				for (Alumno alumno : curso.getAlumnos()) {
					Element alumnoTag = xml.createElement("alumno");
					alumnosTag.appendChild(alumnoTag);
					alumnoTag.setTextContent(alumno.getNombre());
					alumnoTag.setAttribute("dni", alumno.getDni());
				}
				
				
			}
			
			
			
			
			
			
			// Guardar XML en fichero
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(xml);
			File file = new File(rutaFicheroCompleta);
			StreamResult stream = new StreamResult(file);
			transformer.transform(source, stream);
			
		}
		catch(Exception e) {
			throw new CursosXMLException("Error generando XML de cursos", e);
		}
		
	}
	

}
