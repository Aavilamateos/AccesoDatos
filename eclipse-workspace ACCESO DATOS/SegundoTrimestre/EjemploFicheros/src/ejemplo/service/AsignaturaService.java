package ejemplo.service;

import java.util.ArrayList;
import java.util.List;

import ejemplo.modelo.Asignatura;

public class AsignaturaService {

	public List<Asignatura> consultarAsignatura() {
		List<Asignatura> lista = new ArrayList<Asignatura>();
		for (int i = 1; i <= 100; i++) {
			Asignatura a = new Asignatura();
			if (i % 2 == 0) {
				a.setCiclo("DAM");
			} else {
				a.setCiclo("DAW");
			}

			a.setId(i);
			a.setNombre("Experimento numero: " + i);
			lista.add(a);
		}
		return lista;
	}

}
