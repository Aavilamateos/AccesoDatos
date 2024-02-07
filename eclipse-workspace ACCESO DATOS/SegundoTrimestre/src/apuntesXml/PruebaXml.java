package apuntesXml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class PruebaXml {

	public void crearXmlCursos(String rutaFicheroCompleta) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document xml = builder.newDocument();
			Element root = xml.createElement("cursos");
			xml.appendChild(root);
			
			Element cursoTag=xml.createElement("curso");
			root.appendChild(cursoTag);
			
			Element nombreTag=xml.createElement("nombre");
			cursoTag.appendChild(nombreTag);
			nombreTag.setTextContent("Programación");
			
			Element horasTag=xml.createElement("horas");
			nombreTag.appendChild(horasTag);
			horasTag.setTextContent("8");
			
			Element alumnosTag=xml.createElement("alumnos");
			horasTag.appendChild(alumnosTag);
			
			Element alumnoTag=xml.createElement("alumno");
			alumnosTag.appendChild(alumnoTag);
			alumnoTag.setTextContent("Pablo Torres Mantero");
			alumnoTag.setAttribute("dni", "1234X");
			

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(xml);
			File file = new File(rutaFicheroCompleta);
			StreamResult stream = new StreamResult(file);
			transformer.transform(source, stream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
