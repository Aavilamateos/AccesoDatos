package ceu.dam.ad.examen.ej4restServicesClients;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import ceu.dam.ad.examen.exceptions.AccessDatabaseException;
import ceu.dam.ad.examen.exceptions.InvalidParamException;
import ceu.dam.ad.examen.exceptions.NotFoundException;
import ceu.dam.ad.examen.modelo.Categoria;

public class CategoriaRestClientImpl implements CategoriaRestClient {

	private String urlBase;
	private RestTemplate restTemplate;

	public CategoriaRestClientImpl(String urlBase, Integer msTimeout) {
		this.urlBase = urlBase;
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectionRequestTimeout(msTimeout);
		this.restTemplate = new RestTemplate(requestFactory);
	}

	@Override
	public Categoria crearCategoria(Categoria categoria) throws InvalidParamException, AccessDatabaseException {
		try {
			String url = urlBase + "/categoria";
			categoria = restTemplate.postForObject(url, categoria, Categoria.class);
			return categoria;
		} catch (HttpStatusCodeException e) {
			e.printStackTrace();
			if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
				throw new InvalidParamException(e.getMessage());
			}
			if (e.getStatusCode() == HttpStatus.SERVICE_UNAVAILABLE) {
				throw new AccessDatabaseException("Error con la BBDD");
			}
			throw e;
		}
	}

	@Override
	public Categoria consultarCategoria(Long id)
			throws InvalidParamException, NotFoundException, AccessDatabaseException {
		try {
			Categoria cate=new Categoria();
			String url = urlBase + "/categoria/{id}" ;
			cate=restTemplate.getForObject(url, Categoria.class, id);
			return cate;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
				throw new InvalidParamException("Error en el parámetro");
			}if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new NotFoundException("No encontrado");
			}
			if (e.getStatusCode() == HttpStatus.SERVICE_UNAVAILABLE) {
				throw new AccessDatabaseException("Error con la BBDD");
			}
			throw e;
		}
		
	}

}
