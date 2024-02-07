package ceu.dam.ad.examen.test;

import ceu.dam.ad.examen.ej4restServicesClients.CategoriaRestClient;
import ceu.dam.ad.examen.ej4restServicesClients.CategoriaRestClientImpl;
import ceu.dam.ad.examen.exceptions.AccessDatabaseException;
import ceu.dam.ad.examen.exceptions.InvalidParamException;
import ceu.dam.ad.examen.exceptions.NotFoundException;
import ceu.dam.ad.examen.modelo.Categoria;

public class Test {

	// Aquí se proporciona un test para probar el ClienteRest (Ejercicio 4) que llama al resto de 
	// métodos de los demás ejercicios. 
	// El alumno es libre de modificarlos o de crear sus propios TEST para lo que considere
	// Los test que se implementen no son evaluables (no suben ni bajan nota)
	
	// IMPORTANTE: que el TEST funcione no implica que los ejercicios estén correctos.
	
	public static void main(String[] args) {
		testRestServiceClient();
	}

	private static void testRestServiceClient() {
		CategoriaRestClient client = new CategoriaRestClientImpl("http://localhost:8080", 1000);
		Categoria c1 = null, c2 = null;
		try {
			System.out.println(">>>>>>>>>>>> PRUEBA 1");
			c1 = client.crearCategoria(new Categoria("test1"));
			System.out.println(c1);
			System.out.println("Debería haber impreso la categoría TEST1. Si la ha impreso y si está en BBDD, estaría OK.");
			System.out.println("<<<<<<<<<<<<");
		} catch (InvalidParamException e) {
			e.printStackTrace();
		} catch (AccessDatabaseException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(">>>>>>>>>>>> PRUEBA 2");
			System.out.println(client.crearCategoria(new Categoria("")));
			System.err.println("No es correcto. Debería lanzar un InvalidParam. REVISA EL CÓDIGO");
			System.out.println("<<<<<<<<<<<<");
		} catch (InvalidParamException e) {
			System.out.println("Correcto!!");
			System.out.println("<<<<<<<<<<<<");
		} catch (AccessDatabaseException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(">>>>>>>>>>>> PRUEBA 3");
			System.out.println(client.crearCategoria(new Categoria(null)));
			System.err.println("No es correcto. Debería lanzar un InvalidParam. REVISA EL CÓDIGO");
			System.out.println("<<<<<<<<<<<<");
		} catch (InvalidParamException e) {
			System.out.println("Correcto!!");
			System.out.println("<<<<<<<<<<<<");
		} catch (AccessDatabaseException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(">>>>>>>>>>>> PRUEBA 4");
			System.out.println(client.crearCategoria(new Categoria("   ")));
			System.err.println("No es correcto. Debería lanzar un InvalidParam. REVISA EL CÓDIGO");
			System.out.println("<<<<<<<<<<<<");
		} catch (InvalidParamException e) {
			System.out.println("Correcto!!");
			System.out.println("<<<<<<<<<<<<");
		} catch (AccessDatabaseException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(">>>>>>>>>>>> PRUEBA 5");
			c2 = client.crearCategoria(new Categoria("test2"));
			System.out.println(c2);
			System.out.println("Debería haber impreso la categoría TEST2. Si la ha impreso y si está en BBDD, estaría OK.");
			System.out.println("<<<<<<<<<<<<");
		} catch (InvalidParamException e) {
			e.printStackTrace();
		} catch (AccessDatabaseException e) {
			e.printStackTrace();
		}
		
		if (c1!=null && c1.getId()!=null) {
			try {
				System.out.println(">>>>>>>>>>>> PRUEBA 6");
				System.out.println(client.consultarCategoria(c1.getId()));
				System.out.println("Debería haber impreso la categoría TEST1. Si la ha impreso, estaría OK.");
				System.out.println("<<<<<<<<<<<<");
			} catch (NotFoundException e) {
				e.printStackTrace();
			} catch (InvalidParamException e) {
				e.printStackTrace();
			} catch (AccessDatabaseException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println(">>>>>>>>>>>> PRUEBA 6 NO SE PUEDE REALIZR PORQUE HA FALLADO PRUEBA 1");
		}
		if (c2!=null && c2.getId()!=null) {
			try {
				System.out.println(">>>>>>>>>>>> PRUEBA 7");
				System.out.println(client.consultarCategoria(c2.getId()));
				System.out.println("Debería haber impreso la categoría TEST2. Si la ha impreso, estaría OK.");
				System.out.println("<<<<<<<<<<<<");
			} catch (NotFoundException e) {
				e.printStackTrace();
			} catch (InvalidParamException e) {
				e.printStackTrace();
			} catch (AccessDatabaseException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println(">>>>>>>>>>>> PRUEBA 7 NO SE PUEDE REALIZR PORQUE HA FALLADO PRUEBA 5");
		}
		
		try {
			System.out.println(">>>>>>>>>>>> PRUEBA 8");
			System.out.println(client.consultarCategoria(null));
			System.out.println("No es correcto. Debería lanzar un InvalidParam. REVISA EL CÓDIGO");
			System.out.println("<<<<<<<<<<<<");
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (InvalidParamException e) {
			System.out.println("Correcto!!");
			System.out.println("<<<<<<<<<<<<");
		} catch (AccessDatabaseException e) {
			e.printStackTrace();
		}
		
		
		try {
			System.out.println(">>>>>>>>>>>> PRUEBA 9");
			System.out.println(client.consultarCategoria(99999999L));
			System.out.println("No es correcto. Debería lanzar un NotFound. REVISA EL CÓDIGO");
			System.out.println("<<<<<<<<<<<<");
		} catch (NotFoundException e) {
			System.out.println("Correcto!!");
			System.out.println("<<<<<<<<<<<<");
		} catch (InvalidParamException e) {
			e.printStackTrace();
		} catch (AccessDatabaseException e) {
			e.printStackTrace();
		}
		
	}
	
}
