package mondongo;


import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

import modelo.Direccion;
import modelo.Persona;

public class Test {

	public static void main(String[] args) {
		MongoDatabase db=MondongoSession.getDatabase();
		MongoCollection<Persona>c=db.getCollection("personas", Persona.class);
		Persona p=new Persona("Alberto", "Avila Mateos", "54181544F");
		p.setDirecciones(new ArrayList<>());
		p.getDirecciones().add(new Direccion("Avda e","Sevilla", 41927));
		
		Document doc=new Document();
		doc.append("nombre", "Alberto");
		doc.append("apellidos", "Avila Mateos");
		doc.append("dni", "54181544F");
		doc.append("edad", "24");
		InsertOneResult result=c.insertOne(p);
	}

}
