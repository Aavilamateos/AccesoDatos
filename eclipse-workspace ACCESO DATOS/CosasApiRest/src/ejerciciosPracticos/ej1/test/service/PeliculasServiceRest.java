package ejerciciosPracticos.ej1.test.service;

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
	public List<Pelicula> getListaPeliculas(@RequestParam Integer longitud) throws PeliculasServiceException {
		List<Pelicula> listaPelis = new ArrayList<Pelicula>();
		PeliculasServices service = new PeliculasServices();
		listaPelis = service.consultarPeliculas(longitud);
		return listaPelis;
	}

}
