package ejerciciosPracticos.ej4.service;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Ejercicio03.modelo.Cliente;
import Ejercicio03.service.ClientesServiceException;
import Ejercicio03.service.ClientesServices;

@RestController
public class ClientesServiceRest {
	@GetMapping("/getCliente")
	public Cliente consultarCliente(@RequestParam String email) throws ClientesServiceException, ClienteNoEncontradoException {
		
		ClientesServices clienService=new ClientesServices();
		Map<String, Cliente>mapaCliente=clienService.consultarClientes(email);
		if (mapaCliente.get(email)==null) {
			throw new ClienteNoEncontradoException("Cliente con ese email no encontrado");
		}
		return mapaCliente.get(email);
		
	}

}
