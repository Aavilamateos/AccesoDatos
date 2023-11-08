package ceu.dam.ad.ejerciciosTema2.ejercicio1al3.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ejercicio01.modelo.Pelicula;
import ejercicio01.services.PeliculasException;
import ejercicio01.services.PeliculasService;

@RestController
public class PeliculasRestService {


	@GetMapping("/peliculas1")
	public List<Pelicula> getPeliculas1() throws PeliculasServiceException{
		try {
			PeliculasService service = new PeliculasService();
			return service.consultarPeliculas();
		} catch (PeliculasException e) {
			throw new PeliculasServiceException("Error al consultar peliculas", e);
		}
	}
	
	@GetMapping("/peliculas2")
	public List<Pelicula> getPeliculas2(@RequestParam Integer longitud) throws PeliculasServiceException{
		try {
			PeliculasService service = new PeliculasService();
			return service.consultarPeliculas(longitud);
		} catch (PeliculasException e) {
			throw new PeliculasServiceException("Error al consultar peliculas", e);
		}
	}
	
	@GetMapping("/peliculas3")
	public List<Pelicula> getPeliculas3(@RequestParam Integer longitud) throws PeliculasServiceException, ParamIncorrectoException{
		try {
			if (longitud < 20 || longitud > 300) {
				throw new ParamIncorrectoException("La longitud tienes que estar entre 20 y 300");
			}
			PeliculasService service = new PeliculasService();
			return service.consultarPeliculas(longitud);
		} catch (PeliculasException e) {
			throw new PeliculasServiceException("Error al consultar peliculas", e);
		}
	}
	
}
