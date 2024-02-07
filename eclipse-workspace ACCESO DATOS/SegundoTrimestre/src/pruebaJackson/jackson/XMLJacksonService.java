package pruebaJackson.jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import apuntesXml.modelo.Curso;
import apuntesXml.xml.CursosXMLException;

public class XMLJacksonService {

	public void escribirXML(String pathName, Curso curso) throws CursosXMLException {
		XmlMapper mapper = new XmlMapper();
		File file =new File(pathName);
		try {
			mapper.writeValue(file, curso);
		} catch (StreamWriteException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error al escribir el xml de curso"+e.getMessage());
			throw new CursosXMLException("Error escribiendo xml", e);
		}
	}

}
