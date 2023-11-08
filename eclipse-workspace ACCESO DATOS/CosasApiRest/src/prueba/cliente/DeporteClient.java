package prueba.cliente;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import prueba.modelo.Deporte;

public class DeporteClient {

	private String urlBase;
	private RestTemplate restTemplate;
	
	public DeporteClient(String urlBase,Integer msTimeout) {
		this.urlBase = urlBase;
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectionRequestTimeout(msTimeout);
		this.restTemplate = new RestTemplate(requestFactory);
	}
 
	public Deporte consultarDeporte(Integer id) {
		String url = urlBase + "/deporte?id=" + id;
		Deporte d = restTemplate.getForObject(url, Deporte.class);
		return d;
	}
	public Deporte crearDeporte(Deporte deporte) {
		String url = urlBase + "/deporte";
		restTemplate.postForObject(url, deporte, Deporte.class);
		return deporte;
	}

}
