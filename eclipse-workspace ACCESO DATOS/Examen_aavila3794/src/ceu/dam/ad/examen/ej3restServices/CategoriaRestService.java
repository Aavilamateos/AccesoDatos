package ceu.dam.ad.examen.ej3restServices;

import ceu.dam.ad.examen.exceptions.AccessDatabaseException;
import ceu.dam.ad.examen.exceptions.InvalidParamException;
import ceu.dam.ad.examen.exceptions.NotFoundException;
import ceu.dam.ad.examen.modelo.Categoria;

public interface CategoriaRestService {

	/** Servicio REST que debe crear (utilizando el servicio del ejercio 2) una categoría como la que se indica por parámetro. 
	 * El objeto categoría recibido únicamente tendrá lleno el atributo name. El resto serán NULL.
	 * El servicio devolverá un objeto de la clase Categoria con todos sus atributos llenos que corresponderá a la categoría recién creada.
	 *  
	 * Si la categoría que se quiere crear tiene un nombre NULL, vacío, sólo tiene espacios o es mayor a 25 caracteres, lanzará un 400 (BAD_REQUEST)
	 * Si hay algún error al conectar o trabajar con la bbdd, lanzará un 503 (SERVICE_UNAVAILABLE)
	 * Se invocará mediante el método adecuado a la url /categoria
	 * El parámetro categoria vendrá dentro de un JSON en el RequestBody. 
	 */
	public Categoria crearCategoria(Categoria categoria) throws InvalidParamException, AccessDatabaseException;

	
	
	
	
	/** Servicio REST que debe consultar (utilizando el servicio del ejercio 2) una categoría con el id indicado. 
	 * El servicio devolverá un objeto de la clase Categoria con todos sus atributos llenos que corresponderá a la categoría con ese ID.
	 *  
	 * Si el ID indicado es NULL, lanzará un 400 (BAD_REQUEST)
	 * Si no existe ninguna categoría con el ID indicado, lanzará un 404 (NOT_FOUND)
	 * Si hay algún error al conectar o trabajar con la bbdd, lanzará un 503 (SERVICE_UNAVAILABLE)
	 * Se invocará mediante el método adecuado a la url /categoria
	 * El parámetro categoria vendrá dentro de la URL como un PathVariable. Por ejemplo: /categoria/45. 
	 */
	public Categoria consultarCategoria(Long id) throws InvalidParamException, NotFoundException, AccessDatabaseException;
	
	
	
}
