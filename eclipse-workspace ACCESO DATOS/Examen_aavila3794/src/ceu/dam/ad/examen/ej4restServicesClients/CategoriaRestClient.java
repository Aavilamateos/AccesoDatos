package ceu.dam.ad.examen.ej4restServicesClients;

import ceu.dam.ad.examen.exceptions.AccessDatabaseException;
import ceu.dam.ad.examen.exceptions.InvalidParamException;
import ceu.dam.ad.examen.exceptions.NotFoundException;
import ceu.dam.ad.examen.modelo.Categoria;

public interface CategoriaRestClient {

	/** Cliente REST que debe invocar al servicio REST del ejercio 3. 
	 * Devolverá la categoría recién creada por el sevicio. 
	 * Si el servicio REST devuelve un 400, lanzará un InvalidParamException
	 * Si el servicio REST devuelve un 503, lanzará un AccessDatabaseException
	 */
	public Categoria crearCategoria(Categoria categoria) throws InvalidParamException, AccessDatabaseException;

	

	
	
	/** Cliente REST que debe invocar al servicio REST del ejercicio 3. 
	 * Devolverá la categoría con el id indicado. 
	 *  
	 * Si el servicio REST devuelve un 400, lanzará un InvalidParamException
	 * Si el servicio REST devuelve un 504, lanzará un NotFoundException
	 * Si el servicio REST devuelve un 503, lanzará un AccessDatabaseException
	 */
	public Categoria consultarCategoria(Long id) throws InvalidParamException, NotFoundException, AccessDatabaseException;
	
}
