package ceu.dam.ad.ejerciciosTema2.ejercicio4.services;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ejercicio02.modelo.Cliente;
import ejercicio02.service.ClienteService;
import ejercicio02.service.ClientesException;

@RestController
public class ClientesRestService {

	@GetMapping("/cliente")
	public Cliente consultarCliente(@RequestParam String email) throws ClienteNotFoundException, ClienteServiceErrorException {
		try {
			ClienteService service = new ClienteService();
			Map<String, Cliente> mapa;
				mapa = service.consultarMapaClientes();
			if (!mapa.containsKey(email)) {
				throw new ClienteNotFoundException("No se encuentra cliente con ese email");
			}
			return mapa.get(email);
		} catch (ClientesException e) {
			throw new ClienteServiceErrorException(e.getMessage(), e);
		}		
		
		
		
	}

}
