package ejerciciosPracticos.ej2y3.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ejercicio01.modelo.Pelicula;
import ejercicio01.service.PeliculasServiceException;
import ejercicio01.service.PeliculasServices;

@RestController
public class PeliculasServiceRest {
	@GetMapping("/getPelis")
	public List<Pelicula> getListaPeliculas(@RequestParam Integer longitud) throws PeliculasServiceException, LongitudException {
		List<Pelicula> listaPelis = new ArrayList<Pelicula>();
		PeliculasServices service = new PeliculasServices();
		if (longitud<20||longitud>300) {
			throw new LongitudException("La longitud debe estar entre 20 y 300 mins");
		}
			listaPelis = service.consultarPeliculas(longitud);
			return listaPelis;
	}

}
