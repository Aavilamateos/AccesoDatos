package prueba.service;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import prueba.modelo.Deporte;

@RestController
public class NombreService {

	@GetMapping("/cumpleañer")
	public String getNombre() {
		return "Pabs";
	}
	@GetMapping("/cuadrado")
	public Integer getCuadrado(@RequestParam Integer num) {
		return num*num;
	}
	@GetMapping("/potencia")
	public Double getPotencia(@RequestParam Double num, @RequestParam Double pot) {
		return Math.pow(num, pot);
	}
	@GetMapping("/potencia1/{num}/{pot}")
	public Double getPotencia1(@PathVariable Double num, @PathVariable Double pot) {
		return Math.pow(num, pot);
	}
	@GetMapping("/deporte")
	public Deporte getDeporte(@RequestParam int id) throws DeporteNotFoundException {
		Deporte deporte=new Deporte();
		if (id==99) {
			throw new DeporteNotFoundException("No existe el deporte con id 99");
		}
		deporte.setId(id);
		deporte.setNombre("Furbo");
		deporte.setEquipo(true);
		deporte.setJugadores(11);
		deporte.setTorneo("Champions");
		return deporte;
	}
	@PostMapping("/deporte")
	public Deporte crearDeporte(@RequestBody Deporte depor) {
		System.out.println("Creando deporte en BBDD");
		System.out.println(depor);
		System.out.println("Deporte creado");
		return depor;
	}
	
}
