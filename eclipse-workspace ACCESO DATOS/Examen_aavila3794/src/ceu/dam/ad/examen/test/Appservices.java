package ceu.dam.ad.examen.test;

import ceu.dam.ad.examen.ej2services.CategoriaServiceImpl;

public class Appservices {
	public static void main(String[] args) {
		
		CategoriaServiceImpl catService=new CategoriaServiceImpl();
		try {
			catService.crearCategoria("prueba");
			System.out.println(catService.consultarCategoria(9L));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
	}
}
