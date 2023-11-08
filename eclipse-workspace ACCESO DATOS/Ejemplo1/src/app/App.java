package app;

import java.util.List;

import ejemplo1modelo.Actor;
import ejemplo1servicios.ActoresServiceException;
import ejemplo1servicios.ActoresServices;

public class App {
	public static void main(String[] args) {
		ActoresServices service = new ActoresServices();
		List<Actor> listActores;
		try {
			listActores = service.consultarActores();
			for (Actor actor : listActores) {
				System.out.println(actor);
			}
		} catch (ActoresServiceException e) {
			e.printStackTrace();
		}

	}
}
